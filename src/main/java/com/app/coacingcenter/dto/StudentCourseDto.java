package com.app.coacingcenter.dto;

import java.util.Date;

public class StudentCourseDto {

	private Integer registrationId;

	private StudentDto student;

	private CoursesDto course;

	private double courseFee;

	private Date registeredDate;

	private String status;

	private Integer certificateNumberSuffix;

	private String gradeObtained;

	private boolean isIndentCompleted;

	private boolean isCertificatePreinted;

	private String studentName;

	private String batchName;

	private String certificateNumber;

	private String courseName;

	private String certificatePrintedYesOrNo;

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public StudentDto getStudent() {
		return student;
	}

	public void setStudent(StudentDto student) {
		this.student = student;
	}

	public CoursesDto getCourse() {
		return course;
	}

	public void setCourse(CoursesDto course) {
		this.course = course;
	}

	public double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCertificateNumberSuffix() {
		return certificateNumberSuffix;
	}

	public void setCertificateNumberSuffix(Integer certificateNumberSuffix) {
		this.certificateNumberSuffix = certificateNumberSuffix;
	}

	public String getGradeObtained() {
		return gradeObtained;
	}

	public void setGradeObtained(String gradeObtained) {
		this.gradeObtained = gradeObtained;
	}

	public boolean getIsIndentCompleted() {
		return isIndentCompleted;
	}

	public void setIsIndentCompleted(boolean isIndentCompleted) {
		this.isIndentCompleted = isIndentCompleted;
	}

	public boolean getIsCertificatePreinted() {
		return isCertificatePreinted;
	}

	public void setIsCertificatePreinted(boolean isCertificatePreinted) {
		this.isCertificatePreinted = isCertificatePreinted;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCertificatePrintedYesOrNo() {
		return certificatePrintedYesOrNo;
	}

	public void setCertificatePrintedYesOrNo(String certificatePrintedYesOrNo) {
		this.certificatePrintedYesOrNo = certificatePrintedYesOrNo;
	}

}
