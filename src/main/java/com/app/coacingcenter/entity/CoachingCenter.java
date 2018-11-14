package com.app.coacingcenter.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.coacingcenter.utils.FieldMapper;

@Entity
@Table(name = "couching_centere")
public class CoachingCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@FieldMapper(name = "centerSeqId")
	private Integer centerSeqId;

	@Column
	@FieldMapper(name = "centerId")
	private String couchingCenterId;

	@Column
	@FieldMapper(name = "address")
	private String postalAddress;

	@Column
	@FieldMapper(name = "phone")
	private String phoneNumber;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "couchingCenter")
	private List<User> users;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "couchingCenter")
	private List<Course> courses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "couchingCenter")
	private List<PaymentDetail> payments;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "couchingCenter")
	private List<Batch> batches;

	public Integer getCenterSeqId() {
		return centerSeqId;
	}

	public void setCenterSeqId(Integer centerSeqId) {
		this.centerSeqId = centerSeqId;
	}

	public String getCouchingCenterId() {
		return couchingCenterId;
	}

	public void setCouchingCenterId(String couchingCenterId) {
		this.couchingCenterId = couchingCenterId;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<PaymentDetail> getPayments() {
		return payments;
	}

	public void setPayments(List<PaymentDetail> payments) {
		this.payments = payments;
	}

	public List<Batch> getBatches() {
		return batches;
	}

	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
