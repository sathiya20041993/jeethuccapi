package com.app.coacingcenter.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.coacingcenter.utils.FieldMapper;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@FieldMapper(name = "studentId")
	private Integer studentId;

	@Column
	@FieldMapper(name = "studentCode")
	private String studentCode;

	@Column
	@FieldMapper(name = "studentName")
	private String studentName;

	@Column
	@FieldMapper(name = "email")
	private String email;

	@Column
	@FieldMapper(name = "phoneNumber")
	private String phoneNumber;

	@Column
	@FieldMapper(name = "joinDate")
	private Date joinDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
	private List<PaymentDetail> payments;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
	private List<StudentCourse> studentCourse;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "couch_center_id", nullable = false)
	private CoachingCenter couchingCenter;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "submitted_by", nullable = false)
	private User user;

	public Integer getStudentId() {

		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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

	public List<PaymentDetail> getPayments() {
		if (payments == null)
			this.payments = new ArrayList<>();
		return payments;
	}

	public void setPayments(List<PaymentDetail> payments) {
		this.payments = payments;
	}

	public List<StudentCourse> getStudentCourse() {
		if (studentCourse == null)
			this.studentCourse = new ArrayList<>();
		return studentCourse;
	}

	public void setStudentCourse(List<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public CoachingCenter getCouchingCenter() {
		return couchingCenter;
	}

	public void setCouchingCenter(CoachingCenter couchingCenter) {
		this.couchingCenter = couchingCenter;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
