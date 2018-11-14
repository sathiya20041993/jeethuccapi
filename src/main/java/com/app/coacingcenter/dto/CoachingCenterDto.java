package com.app.coacingcenter.dto;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.app.coacingcenter.utils.FieldMapper;

public class CoachingCenterDto {

	@FieldMapper(name = "centerSeqId")
	private Integer centerSeq;

	@FieldMapper(name = "centerId")
	private String centerId;

	@FieldMapper(name = "address")
	private String postalAddress;

	@FieldMapper(name = "phone")
	private String phone;

	private List<UserDto> councellors;

	private List<CoursesDto> coursesDto;

	private UserRolesDto userRules;

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<UserDto> getCouncellors() {
		return councellors;
	}

	public void setCouncellors(List<UserDto> councellors) {
		if (!CollectionUtils.isEmpty(councellors)) {
			councellors.sort((a, b) -> Boolean.compare(b.getIsActive(), a.getIsActive()));
			this.councellors = councellors;
		} else {
			this.councellors = councellors;
		}
	}

	public Integer getCenterSeq() {
		return centerSeq;
	}

	public void setCenterSeq(Integer centerSeq) {
		this.centerSeq = centerSeq;
	}

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public UserRolesDto getUserRules() {
		return userRules;
	}

	public void setUserRules(UserRolesDto userRules) {
		this.userRules = userRules;
	}

	public List<CoursesDto> getCoursesDto() {
		return coursesDto;
	}

	public void setCoursesDto(List<CoursesDto> coursesDto) {

		if (!CollectionUtils.isEmpty(coursesDto)) {
			coursesDto.sort((a, b) -> Boolean.compare(b.getIsActive(), a.getIsActive()));
			this.coursesDto = coursesDto;
		} else {
			this.coursesDto = coursesDto;
		}
	}

}
