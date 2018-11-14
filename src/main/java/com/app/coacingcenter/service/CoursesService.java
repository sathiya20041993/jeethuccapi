package com.app.coacingcenter.service;

import org.springframework.core.io.Resource;

import com.app.coacingcenter.dto.CourseCreationRequestDto;
import com.app.coacingcenter.dto.CoursesDto;
import com.app.coacingcenter.dto.ResponseDto;

public interface CoursesService {

	ResponseDto saveCourses(CourseCreationRequestDto courseCreationRequestDto);

	ResponseDto getByCenterSeqenceNumber(Integer centerSeq);

	ResponseDto updateCourse(CoursesDto coursesDto);

	Resource loadFileAsResource(Integer courseSeq);

	public ResponseDto getActiveCources(Integer centerSeq);

}
