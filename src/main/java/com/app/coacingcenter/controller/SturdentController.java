package com.app.coacingcenter.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.coacingcenter.dto.PaymentDetailDto;
import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.dto.StudentDto;
import com.app.coacingcenter.dto.StudentIndentDto;
import com.app.coacingcenter.service.StudentService;

@RestController
@RequestMapping("student")
public class SturdentController {

	@Autowired
	StudentService studentService;

	@GetMapping
	public List<StudentDto> getStudents() {
		return studentService.getStudents();
	}

	@GetMapping("byCenterSeq/{centerSeq}")
	public List<StudentDto> getStudentsBySenterSeq(@PathVariable("centerSeq") Integer centerSeq) {
		return studentService.getStudentsBySenterSeq(centerSeq);
	}

	@GetMapping("{id}")
	public StudentDto getStudent(@PathVariable("id") Integer studentId) {
		return studentService.getStudent(studentId);
	}

	@PostMapping
	public Map<String, Object> saveStudent(@RequestBody StudentDto studentDto) {
		return studentService.saveStudent(studentDto);
	}

	@GetMapping("search/{key}/{centerSeq}")
	public List<StudentDto> getStudent(@PathVariable("key") String key, @PathVariable("centerSeq") Integer centerSeq) {
		return studentService.getSearchStudent(centerSeq, key);
	}

	@GetMapping("payments/{id}")
	public Map<String, Object> getStudentPayments(@PathVariable("id") Integer studentId) {
		return studentService.getStudentPayments(studentId);
	}

	@GetMapping("payment/{id}")
	public Map<String, Object> getStudentPayment(@PathVariable("id") Integer studentId) {
		return studentService.getStudentPayment(studentId);
	}

	@PostMapping("payment")
	public String saveStudentPayment(@RequestBody PaymentDetailDto paymentDetailDto) {
		return studentService.saveStudentPayment(paymentDetailDto);
	}

	@GetMapping("courses/{id}")
	public ResponseDto studentCourses(@PathVariable("id") Integer studentId) {
		return studentService.getStudentCourses(studentId);
	}

	@GetMapping("coursesCertificateInfo/{studentId}/{courseId}")
	public ResponseDto studentCourses(@PathVariable("studentId") Integer studentId,
			@PathVariable("courseId") Integer courseId) {
		return studentService.getStudentCourseCertificateInfo(studentId, courseId);
	}

	@PostMapping("indentStudent")
	public ResponseDto indentStudent(@RequestBody StudentIndentDto StudentIndentDto) {
		return studentService.saveStudentIndent(StudentIndentDto);
	}
}
