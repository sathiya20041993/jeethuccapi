package com.app.coacingcenter.dto;

import java.sql.Date;
import java.util.List;

import com.app.coacingcenter.utils.FieldMapper;

public class StudentDto {

	@FieldMapper(name = "studentId")
	private Integer studentId;

	@FieldMapper(name = "studentCode")
	private String studentCode;

	@FieldMapper(name = "studentName")
	private String studentName;

	@FieldMapper(name = "email")
	private String email;

	@FieldMapper(name = "phoneNumber")
	private String phoneNumber;

	@FieldMapper(name = "joinDate")
	private Date joinDate;

	@FieldMapper(name = "centerId")
	private Integer centerId;

	private List<String> course;

	private PaymentDetailDto paymentDetails;

	private Integer userSeq;

	public PaymentDetailDto getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetailDto paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public List<String> getCourse() {
		return course;
	}

	public void setCourse(List<String> course) {
		this.course = course;
	}

	private PaymentDetailDto paymentDetailDto;

	public String getStudentCode() {
		return studentCode;
	}

	public PaymentDetailDto getPaymentDetailDto() {
		return paymentDetailDto;
	}

	public void setPaymentDetailDto(PaymentDetailDto paymentDetailDto) {
		this.paymentDetailDto = paymentDetailDto;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public Integer getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(Integer userSeq) {
		this.userSeq = userSeq;
	}

}
