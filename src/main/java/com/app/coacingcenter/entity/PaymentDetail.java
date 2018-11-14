package com.app.coacingcenter.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.coacingcenter.utils.FieldMapper;

@Entity
@Table(name = "payment_details")
public class PaymentDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@FieldMapper(name = "paymentSeq")
	private Integer paymentSeq;

	@Column
	@FieldMapper(name = "totalFee")
	private double totalFee;

	@Column
	@FieldMapper(name = "addon")
	private double addon;

	@Column
	@FieldMapper(name = "discount")
	private double discount;

	@Column
	@FieldMapper(name = "coursesFee")
	private double coursesFee;

	@Column
	@FieldMapper(name = "paidAmount")
	private double paidAmount;

	@Column
	@FieldMapper(name = "dueAmount")
	private double dueAmount;

	@Column
	@FieldMapper(name = "paymentDate")
	private Date paymentDate;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "submittedBy", nullable = false)
	private User user;

	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentDetail", cascade =
	 * CascadeType.ALL) private List<PaymentHistory> paymentHistory;
	 */

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "couch_center_id", nullable = false)
	private CoachingCenter couchingCenter;

	public Integer getPaymentSeq() {
		return paymentSeq;
	}

	public void setPaymentSeq(Integer paymentSeq) {
		this.paymentSeq = paymentSeq;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public CoachingCenter getCouchingCenter() {
		return couchingCenter;
	}

	public void setCouchingCenter(CoachingCenter couchingCenter) {
		this.couchingCenter = couchingCenter;
	}
	/*
	 * public List<PaymentHistory> getPaymentHistory() { return paymentHistory; }
	 * 
	 * public void setPaymentHistory(List<PaymentHistory> paymentHistory) {
	 * this.paymentHistory = paymentHistory; }
	 */

	public double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	public double getAddon() {
		return addon;
	}

	public void setAddon(double addon) {
		this.addon = addon;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getCoursesFee() {
		return coursesFee;
	}

	public void setCoursesFee(double coursesFee) {
		this.coursesFee = coursesFee;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
