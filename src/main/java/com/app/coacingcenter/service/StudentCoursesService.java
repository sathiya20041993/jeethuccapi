package com.app.coacingcenter.service;

import java.util.List;

import com.app.coacingcenter.dto.CollectionDueReportDto;
import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.jdbcmodel.StudentCourseReport;

public interface StudentCoursesService {

	ResponseDto getBatches(Integer centerSeq);

	ResponseDto getStudentCoursePendingcertificateList(Integer centerSeq, String batchName);

	ResponseDto updateCertificatePrinted(Integer centerSeq, String batchName);

	List<StudentCourseReport> getStudentCourseReport(CollectionDueReportDto collectionReportDto);

}
