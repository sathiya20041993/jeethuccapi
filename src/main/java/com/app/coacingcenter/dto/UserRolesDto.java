package com.app.coacingcenter.dto;

import com.app.coacingcenter.utils.FieldMapper;

public class UserRolesDto {

	@FieldMapper(name = "userRoleSeqId")
	private Integer userRoleSeqId;

	private Integer roleId;

	private Integer userSeqId;

	public Integer getUserRoleSeqId() {
		return userRoleSeqId;
	}

	public void setUserRoleSeqId(Integer userRoleSeqId) {
		this.userRoleSeqId = userRoleSeqId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserSeqId() {
		return userSeqId;
	}

	public void setUserSeqId(Integer userSeqId) {
		this.userSeqId = userSeqId;
	}

}
