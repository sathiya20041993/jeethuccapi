package com.app.coacingcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.coacingcenter.dto.CollectionDueReportDto;
import com.app.coacingcenter.jdbcmodel.StudentCourseReport;
import com.app.coacingcenter.service.StudentCoursesService;

@RestController
@RequestMapping("report/others")
public class ReportsController {
	@Autowired
	StudentCoursesService studentCoursesService;

	@PostMapping("students")
	public List<StudentCourseReport> searchStudents(@RequestBody CollectionDueReportDto collectionReportDto) {
		return studentCoursesService.getStudentCourseReport(collectionReportDto);
	}
}
