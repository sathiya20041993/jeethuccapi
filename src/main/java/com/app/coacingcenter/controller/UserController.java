package com.app.coacingcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.coacingcenter.dto.LoginDto;
import com.app.coacingcenter.dto.PasswordUpdate;
import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.service.CochingService;
import com.app.coacingcenter.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	CochingService cochingService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseDto login(@RequestBody LoginDto dto) {
		return userService.login(dto);

	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseDto logOut(@RequestBody LoginDto dto) {
		return userService.logOut(dto);

	}

	@RequestMapping(value = "/checkDuplicateUserId/{userId}", method = RequestMethod.GET)
	public ResponseDto checkDuplicateUserId(@PathVariable String userId) {
		return userService.checkDuplicateUserId(userId);

	}

	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public ResponseDto save(@RequestBody PasswordUpdate dto) {
		return userService.updatePassword(dto);

	}

}
