package com.app.coacingcenter.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.app.coacingcenter.dao.StudentCoursesDao;
import com.app.coacingcenter.dto.CoachingCenterDto;
import com.app.coacingcenter.dto.CoursesDto;
import com.app.coacingcenter.dto.LabelValuePair;
import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.dto.UserDto;
import com.app.coacingcenter.dto.UserRolesDto;
import com.app.coacingcenter.entity.CoachingCenter;
import com.app.coacingcenter.entity.Course;
import com.app.coacingcenter.entity.Role;
import com.app.coacingcenter.entity.User;
import com.app.coacingcenter.entity.UserRoles;
import com.app.coacingcenter.jdbcmodel.BatcheWithPendingCertificate;
import com.app.coacingcenter.repository.CoachingCenterRepository;
import com.app.coacingcenter.repository.RoleRepository;
import com.app.coacingcenter.repository.UserRepository;
import com.app.coacingcenter.repository.UserRolesRepository;
import com.app.coacingcenter.service.CochingService;
import com.app.coacingcenter.service.UserService;
import com.app.coacingcenter.utils.CommomUtils;
import com.app.coacingcenter.utils.FieldMapperService;

@Service
public class CouchingServiceImpl implements CochingService {

	@Autowired
	CoachingCenterRepository coachingCenterRepository;

	@Autowired
	UserService userService;

	@Autowired
	FieldMapperService fieldMapperService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRolesRepository userRolesRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	StudentCoursesDao studentCoursesDao;

	@Override
	public ResponseDto getAllcouchingcenters() {
		// TODO Auto-generated method stub
		List<CoachingCenter> couchingCenters = (List<CoachingCenter>) coachingCenterRepository.findAll();
		List<CoachingCenterDto> couchingCenterdtos = new ArrayList<>();
		for (CoachingCenter center : couchingCenters) {
			CoachingCenterDto dto = fieldMapperService.populateDataToNewInstance(center, CoachingCenterDto.class);
			couchingCenterdtos.add(dto);
		}

		return new ResponseDto(200, "success", couchingCenterdtos);
	}

	@Override
	public ResponseDto getAllAsLabelValue() {
		List<CoachingCenter> couchingCenters = (List<CoachingCenter>) coachingCenterRepository.findAll();
		List<LabelValuePair> couchingCenterdtos = new ArrayList<>();
		for (CoachingCenter center : couchingCenters) {
			LabelValuePair labelValue = new LabelValuePair();

			labelValue.setLabel(center.getCouchingCenterId());
			labelValue.setValue(center.getCenterSeqId());
			couchingCenterdtos.add(labelValue);
		}

		return new ResponseDto(200, "success", couchingCenterdtos);
	}

	@Override
	public ResponseDto save(CoachingCenterDto dto) {
		CoachingCenter center = null;

		if (dto.getCenterSeq() != null) {
			Optional<CoachingCenter> existingCenter = coachingCenterRepository.findById(dto.getCenterSeq());

			if (existingCenter.isPresent()) {
				center = existingCenter.get();
				center = fieldMapperService.populateDataToNewInstance(dto, CoachingCenter.class);
			}
		} else {
			center = fieldMapperService.populateDataToNewInstance(dto, CoachingCenter.class);
		}

		List<UserDto> counselors = dto.getCouncellors();

		boolean isDuplicateUserIdExist = checkDuplicateUserIdExistInrequest(counselors);
		if (isDuplicateUserIdExist) {
			return new ResponseDto(410, "Duplicate User Id provided in screen", null);
		}

		List<User> existingUsers = new ArrayList<>();

		for (UserDto userDto : counselors) {

			User user = fieldMapperService.populateDataToNewInstance(userDto, User.class);
			user.setIsActive(userDto.getIsActive());
			ResponseDto duplicateUserExistResponse = checkDuplicateUserIdExistInDb(userDto, user);
			if (duplicateUserExistResponse != null) {
				return duplicateUserExistResponse;
			}

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
			existingUsers.add(user);
		}

		center.setUsers(existingUsers);

		try {
			center = coachingCenterRepository.save(center);
		} catch (Exception ex) {
			return new ResponseDto(400, "Failed", null);
		}

		return new ResponseDto(200, "success", null);
	}

	public boolean checkDuplicateUserIdExistInrequest(List<UserDto> counselors) {
		boolean duplicatePresent = false;

		Set<String> userIds = new HashSet<>();

		for (UserDto userDto : counselors) {
			userIds.add(userDto.getUserId().trim());
		}

		if (!CollectionUtils.isEmpty(counselors)) {
			if (userIds.size() < counselors.size()) {
				duplicatePresent = true;
			}
		}

		return duplicatePresent;
	}

	public ResponseDto checkDuplicateUserIdExistInDb(UserDto userDto, User user) {
		Optional<User> userExistWithId = userRepository.findOneByUserId(user.getUserId());

		if (userExistWithId.isPresent()) {
			User ExistUser = userExistWithId.get();
			if (userDto.getUserSeq() == null || !userDto.getUserSeq().equals(ExistUser.getUserSeq())) {
				return new ResponseDto(410, "User Id Already Exist " + user.getUserId(), user.getUserId());
			}
		}
		return null;
	}

	@Override
	public ResponseDto getCenterDetail(String centerId) {
		CoachingCenter center = coachingCenterRepository.findByCouchingCenterId(centerId);

		CoachingCenterDto centerDto = fieldMapperService.populateDataToNewInstance(center, CoachingCenterDto.class);

		List<User> users = center.getUsers();
		List<UserDto> counselors = new ArrayList<>();

		for (User user : users) {

			UserDto userDto = fieldMapperService.populateDataToNewInstance(user, UserDto.class);
			if (user.getUserRoles() != null && !CollectionUtils.isEmpty(user.getUserRoles())) {

				UserRoles userRole = user.getUserRoles().get(0);

				if (userRole.getRole().getRoleId().equals(2)) {
					userDto.setIsCenterHead(true);
				}
				if (userRole != null) {
					UserRolesDto userRolesDto = new UserRolesDto();
					userRolesDto.setUserRoleSeqId(userRole.getUserRoleSeqId());
					userDto.setUserRoles(userRolesDto);
				}

			}
			counselors.add(userDto);
		}

		centerDto.setCouncellors(counselors);

		List<CoursesDto> coursesDto = getCoursesInCenter(center);
		centerDto.setCoursesDto(coursesDto);

		return new ResponseDto(200, "success", centerDto);

	}

	@Override
	public List<CoursesDto> getCoursesInCenter(CoachingCenter center) {

		List<Course> coursesExist = center.getCourses();
		List<CoursesDto> courseDtos = new ArrayList<>();

		for (Course course : coursesExist) {
			CoursesDto dto = fieldMapperService.populateDataToNewInstance(course, CoursesDto.class);
			courseDtos.add(dto);

		}

		return courseDtos;
	}

	@Override
	public List<CoursesDto> getActiveCoursesInCenter(CoachingCenter center) {

		List<Course> coursesExist = center.getCourses();
		List<CoursesDto> courseDtos = new ArrayList<>();

		for (Course course : coursesExist) {
			if (course.getIsActive()) {
				CoursesDto dto = fieldMapperService.populateDataToNewInstance(course, CoursesDto.class);
				courseDtos.add(dto);
			}
		}

		return courseDtos;
	}

	@Override
	public ResponseDto checkCenterIdExist(String centerId) {
		CoachingCenter center = coachingCenterRepository.findByCouchingCenterId(centerId);

		if (center != null) {
			return new ResponseDto(200, "Center Id Already Exist", null);
		} else {
			return new ResponseDto(410, "Not Exist", null);
		}
	}

	@Override
	public ResponseDto getBAtchesWithPendingCertificate(String centerId) {
		// TODO Auto-generated method stub
		ResponseDto responseDto = null;
		List<BatcheWithPendingCertificate> pendingCertificateBatches = studentCoursesDao
				.getCenterPendingCertificateBatchesReport(centerId);

		if (!CollectionUtils.isEmpty(pendingCertificateBatches)) {
			responseDto = new ResponseDto(200, "success", pendingCertificateBatches);
		} else {
			responseDto = new ResponseDto(210, "No Batches Found", null);
		}
		return responseDto;
	}

	@Override
	public ResponseDto getcounselorsAsLabelValue(Integer centerSeq) {
		Optional<CoachingCenter> couchingCenter = coachingCenterRepository.findById(centerSeq);

		CoachingCenter center = couchingCenter.get();

		List<User> counselors = center.getUsers();
		List<LabelValuePair> counselorsdtos = new ArrayList<>();
		for (User user : counselors) {
			LabelValuePair labelValue = new LabelValuePair();

			labelValue.setLabel(user.getUserId());
			labelValue.setValue(user.getUserSeq());
			counselorsdtos.add(labelValue);
		}

		return new ResponseDto(200, "success", counselorsdtos);
	}

}
