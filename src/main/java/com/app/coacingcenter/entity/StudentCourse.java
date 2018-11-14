package com.app.coacingcenter.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_course")
public class StudentCourse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer registrationId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;

	@Column
	private double courseFee;

	@Column(name = "registered_date")
	private Date registeredDate;

	@Column
	private String status;

	@Column
	private Integer certificateNumberSuffix;

	@Column
	private String certificateNumber;

	@Column
	private String gradeObtained;

	@Column
	private boolean isIndentCompleted;

	@Column
	private Date indentedDate;

	@Column
	private String batchName;

	@Column
	private boolean isCertificatePreinted;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "addedBy", nullable = false)
	private User user;

	@Column
	private Integer centerSeq;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
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

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public Date getIndentedDate() {
		return indentedDate;
	}

	public void setIndentedDate(Date indentedDate) {
		this.indentedDate = indentedDate;
	}

	public Integer getCenterSeq() {
		return centerSeq;
	}

	public void setCenterSeq(Integer centerSeq) {
		this.centerSeq = centerSeq;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

}
