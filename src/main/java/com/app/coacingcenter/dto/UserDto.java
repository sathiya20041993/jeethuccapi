package com.app.coacingcenter.dto;

import com.app.coacingcenter.utils.FieldMapper;

public class UserDto {

	@FieldMapper(name = "sequenceId")
	private Integer userSeq;

	@FieldMapper(name = "userId")
	private String userId;

	@FieldMapper(name = "userName")
	private String userName;

	@FieldMapper(name = "phone")
	private String phoneNumber;

	@FieldMapper(name = "password")
	private String password;

	private boolean isCenterHead;

	@FieldMapper(name = "isActive", type = "boolean")
	private boolean isActive;

	private UserRolesDto userRoles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRolesDto getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(UserRolesDto userRoles) {
		this.userRoles = userRoles;
	}

	public Integer getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(Integer userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean getIsCenterHead() {
		return isCenterHead;
	}

	public void setIsCenterHead(boolean isCenterHead) {
		this.isCenterHead = isCenterHead;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

}
