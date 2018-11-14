package com.app.coacingcenter.service;

import java.util.List;

import com.app.coacingcenter.dto.CoachingCenterDto;
import com.app.coacingcenter.dto.CoursesDto;
import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.entity.CoachingCenter;

public interface CochingService {

	public ResponseDto getAllcouchingcenters();

	public ResponseDto save(CoachingCenterDto dto);

	public ResponseDto getCenterDetail(String centerId);

	public List<CoursesDto> getCoursesInCenter(CoachingCenter center);

	public ResponseDto checkCenterIdExist(String centerId);

	List<CoursesDto> getActiveCoursesInCenter(CoachingCenter center);

	public ResponseDto getAllAsLabelValue();

	public ResponseDto getBAtchesWithPendingCertificate(String centerId);

	public ResponseDto getcounselorsAsLabelValue(Integer centerSeq);

}
