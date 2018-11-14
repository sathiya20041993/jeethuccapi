package com.app.coacingcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.service.StudentCoursesService;

@RestController
@RequestMapping("studentCourses")
public class StudentCoursesController {

	@Autowired
	StudentCoursesService studentCoursesService;

	@GetMapping("batches/{centerSeq}")
	public ResponseDto getBatches(@PathVariable Integer centerSeq) {
		return studentCoursesService.getBatches(centerSeq);
	}

	@GetMapping("batches/{centerSeq}/{batchName}")
	public ResponseDto getStudentCoursePendingcertificateList(@PathVariable Integer centerSeq,
			@PathVariable String batchName) {
		return studentCoursesService.getStudentCoursePendingcertificateList(centerSeq, batchName);
	}

	@GetMapping("update-printed/{centerSeq}/{batchName}")
	public ResponseDto updatePrinted(@PathVariable Integer centerSeq, @PathVariable String batchName) {
		return studentCoursesService.updateCertificatePrinted(centerSeq, batchName);
	}
}
