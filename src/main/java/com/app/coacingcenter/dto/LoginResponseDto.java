package com.app.coacingcenter.dto;

import java.util.List;

import com.app.coacingcenter.utils.FieldMapper;

public class LoginResponseDto {

	@FieldMapper(name = "sequenceId")
	private Integer userSeq;

	@FieldMapper(name = "userId")
	private String userId;

	@FieldMapper(name = "userName")
	private String userName;

	private Integer centerSeq;

	private String centerName;

	private List<String> role;

	private String sessionId;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getCenterSeq() {
		return centerSeq;
	}

	public void setCenterSeq(Integer centerSeq) {
		this.centerSeq = centerSeq;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public List<String> getRole() {
		return role;
	}

	public void setRole(List<String> role) {
		this.role = role;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
