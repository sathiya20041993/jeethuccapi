package com.app.coacingcenter.service;

import com.app.coacingcenter.dto.CoachingCenterDto;
import com.app.coacingcenter.dto.LoginDto;
import com.app.coacingcenter.dto.PasswordUpdate;
import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.entity.CoachingCenter;

public interface UserService {

	ResponseDto login(LoginDto dto);

	void updateCouchingCenterUser(CoachingCenter center, CoachingCenterDto dto);

	ResponseDto checkDuplicateUserId(String userId);

	ResponseDto updatePassword(PasswordUpdate dto);

	ResponseDto logOut(LoginDto dto);

}
