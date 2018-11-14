package com.app.coacingcenter.service;

import java.util.List;
import java.util.Map;

import com.app.coacingcenter.dto.PaymentDetailDto;
import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.dto.StudentDto;
import com.app.coacingcenter.dto.StudentIndentDto;

public interface StudentService {

	public List<StudentDto> getStudents();

	public StudentDto getStudent(Integer studentId);

	public Map<String, Object> saveStudent(StudentDto studentDto);

	List<StudentDto> getSearchStudent(Integer centerSeq, String key);

	public Map<String, Object> getStudentPayments(Integer studentId);

	Map<String, Object> getStudentPayment(Integer studentId);

	public String saveStudentPayment(PaymentDetailDto paymentDetailDto);

	public ResponseDto getStudentCourses(Integer studentId);

	public ResponseDto getStudentCourseCertificateInfo(Integer studentId, Integer courseId);

	public ResponseDto saveStudentIndent(StudentIndentDto studentIndentDto);

	public List<StudentDto> getStudentsBySenterSeq(Integer centerSeq);

}
