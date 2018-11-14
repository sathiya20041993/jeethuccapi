package com.app.coacingcenter.dto;

import java.util.List;

public class CourseCreationRequestDto {

	private CoachingCenterDto centerDto;

	private List<CoursesDto> courses;

	public CoachingCenterDto getCenterDto() {
		return centerDto;
	}

	public void setCenterDto(CoachingCenterDto centerDto) {
		this.centerDto = centerDto;
	}

	public List<CoursesDto> getCourses() {
		return courses;
	}

	public void setCourses(List<CoursesDto> courses) {
		this.courses = courses;
	}

}
