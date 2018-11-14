package com.app.coacingcenter.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.coacingcenter.dto.CoachingCenterDto;
import com.app.coacingcenter.dto.LoginDto;
import com.app.coacingcenter.dto.LoginResponseDto;
import com.app.coacingcenter.dto.PasswordUpdate;
import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.dto.UserDto;
import com.app.coacingcenter.entity.CoachingCenter;
import com.app.coacingcenter.entity.Role;
import com.app.coacingcenter.entity.User;
import com.app.coacingcenter.entity.UserRoles;
import com.app.coacingcenter.repository.RoleRepository;
import com.app.coacingcenter.repository.UserRepository;
import com.app.coacingcenter.repository.UserRolesRepository;
import com.app.coacingcenter.service.UserService;
import com.app.coacingcenter.utils.CommomUtils;
import com.app.coacingcenter.utils.FieldMapperService;
import com.app.coacingcenter.utils.UserSessionUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FieldMapperService fieldMapperService;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRolesRepository userRolesRepository;

	@Override
	@Transactional
	public ResponseDto login(LoginDto dto) {
		// TODO Auto-generated method stub
		ResponseDto response = null;
		CoachingCenter center = null;
		boolean isAdmin = false;
		Optional<User> user = userRepository.findOneByUserIdAndPasswordAndActiveTrue(dto.getUserName(),
				dto.getPassword());

		List<String> roles = new ArrayList<>();

		if (user.isPresent()) {
			User loggingUser = user.get();
			List<UserRoles> userRoles = new ArrayList<>();
			userRoles.addAll(loggingUser.getUserRoles());

			LoginResponseDto loginResponseDto = fieldMapperService.populateDataToNewInstance(loggingUser,
					LoginResponseDto.class);

			for (UserRoles UserRole : userRoles) {

				String roleName = UserRole.getRole().getRoleName();
				if (roleName.equalsIgnoreCase("ADMIN")) {
					isAdmin = true;
				}
				roles.add(roleName);
			}
			if (!isAdmin) {
				center = loggingUser.getCouchingCenter();
			}
			if (center != null) {
				loginResponseDto.setCenterSeq(center.getCenterSeqId());
				loginResponseDto.setCenterName(center.getCouchingCenterId());
			}
			loginResponseDto.setRole(roles);

			String sessionId = UserSessionUtils.getSaltString();
			loginResponseDto.setSessionId(sessionId);
			addUserSessionId(loginResponseDto.getUserId(), sessionId);
			response = new ResponseDto(200, "success", loginResponseDto);
		} else {
			response = new ResponseDto(400, "Failed", null);
		}
		return response;
	}

	public void addUserSessionId(String userId, String sessionKey) {

		if (UserSessionUtils.userSession.containsKey(userId)) {
			UserSessionUtils.userSession.get(userId).add(sessionKey);
		} else {

			List<String> sessionIds = new ArrayList<>();
			sessionIds.add(sessionKey);
			UserSessionUtils.userSession.put(userId, sessionIds);
		}

	}

	@Override
	public void updateCouchingCenterUser(CoachingCenter center, CoachingCenterDto dto) {

		List<UserDto> counselors = dto.getCouncellors();

		List<User> existingUsers = center.getUsers();

		for (UserDto userDto : counselors) {

			User user = fieldMapperService.populateDataToNewInstance(userDto, User.class);

			List<UserRoles> userRoles = new ArrayList<>();
			UserRoles userRole = null;
			if (userDto.getUserRoles() != null) {
				Optional<UserRoles> optUserQoles = userRolesRepository
						.findById(userDto.getUserRoles().getUserRoleSeqId());
				userRole = optUserQoles.get();
			} else {
				userRole = new UserRoles();
			}
			Optional<Role> centerHeadRole = null;

			if (userDto.getIsCenterHead()) {
				centerHeadRole = roleRepository.findById(2);

				Role roleObj = centerHeadRole.get();
				roleObj.setUserRoles(userRoles);
				userRole.setRole(roleObj);
			} else {
				centerHeadRole = roleRepository.findById(3);
				userRole.setRole(CommomUtils.getCounsellorRole());
			}
			userRole.setUser(user);
			userRoles.add(userRole);
			user.setUserRoles(userRoles);

			user.setCouchingCenter(center);
			userRepository.save(user);
		}

	}

	@Override
	public ResponseDto checkDuplicateUserId(String userId) {
		ResponseDto response = null;
		Optional<User> user = userRepository.findOneByUserId(userId);
		if (user.isPresent()) {
			response = new ResponseDto(200, "Exist", true);
		} else {
			response = new ResponseDto(205, "Not Exist", false);
		}
		return response;
	}

	@Override
	public ResponseDto updatePassword(PasswordUpdate dto) {
		ResponseDto response = null;
		Optional<User> optionalIUser = userRepository.findOneByUserIdAndPasswordAndActiveTrue(dto.getUserId(),
				dto.getOldPassword());
		if (optionalIUser.isPresent()) {
			User user = optionalIUser.get();
			user.setPassword(dto.getNewPassword());
			userRepository.save(user);

			response = new ResponseDto(200, "Password Updated", true);
		} else {
			response = new ResponseDto(205, "Password Update failed", false);
		}
		return response;
	}

	@Override
	public ResponseDto logOut(LoginDto dto) {
		ResponseDto response = null;

		if (UserSessionUtils.userSession.containsKey(dto.getUserName())) {
			UserSessionUtils.userSession.remove(dto.getUserName());
			response = new ResponseDto(200, "Logout Success", true);
		} else {
			response = new ResponseDto(210, "No Session", false);
		}
		return response;
	}

}
