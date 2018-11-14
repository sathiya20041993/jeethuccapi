package com.app.coacingcenter.dao;

import java.util.List;

import com.app.coacingcenter.dto.CollectionDueReportDto;
import com.app.coacingcenter.jdbcmodel.BatcheWithPendingCertificate;
import com.app.coacingcenter.jdbcmodel.StudentCourseReport;

public interface StudentCoursesDao {

	List<BatcheWithPendingCertificate> getCenterPendingCertificateBatchesReport(String centerId);

	List<StudentCourseReport> getStudentCourseReport(CollectionDueReportDto collectionReportDto);

}
