package com.app.coacingcenter.entity;

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
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@FieldMapper(name = "sequenceId")
	private Integer userSeq;

	@Column(unique = true)
	@FieldMapper(name = "userId")
	private String userId;

	@Column
	@FieldMapper(name = "userName")
	private String userName;

	@Column
	@FieldMapper(name = "phone")
	private String phone;

	@Column
	@FieldMapper(name = "password")
	private String password;

	@Column
	@FieldMapper(name = "isActive", type = "boolean")
	private boolean active;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "couch_center_id", nullable = false)
	private CoachingCenter couchingCenter;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<UserRoles> userRoles;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<PaymentDetail> paymentDetails;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<StudentCourse> studentsCourses;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public CoachingCenter getCouchingCenter() {
		return couchingCenter;
	}

	public void setCouchingCenter(CoachingCenter couchingCenter) {
		this.couchingCenter = couchingCenter;
	}

	public List<UserRoles> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

	public Integer getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(Integer userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean getIsActive() {
		return active;
	}

	public List<PaymentDetail> getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(List<PaymentDetail> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public void setIsActive(boolean active) {
		this.active = active;
	}

	public List<StudentCourse> getStudentsCourses() {
		return studentsCourses;
	}

	public void setStudentsCourses(List<StudentCourse> studentsCourses) {
		this.studentsCourses = studentsCourses;
	}

}
