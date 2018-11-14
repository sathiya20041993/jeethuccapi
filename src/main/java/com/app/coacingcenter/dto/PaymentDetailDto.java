package com.app.coacingcenter.dto;

import java.sql.Date;

import com.app.coacingcenter.utils.FieldMapper;

public class PaymentDetailDto {

	@FieldMapper(name = "paymentSeq")
	private Integer paymentSeq;

	@FieldMapper(name = "totalFee")
	private double totalFee;

	@FieldMapper(name = "addon")
	private double addon;

	@FieldMapper(name = "discount")
	private double discount;

	@FieldMapper(name = "coursesFee")
	private double coursesFee;

	@FieldMapper(name = "paidAmount")
	private double paidAmount;

	@FieldMapper(name = "dueAmount")
	private double dueAmount;

	@FieldMapper(name = "paymentDate")
	private Date paymentDate;

	private Integer coachingCentreId;

	private Integer studentId;

	private Integer userSeq;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getPaymentSeq() {
		return paymentSeq;
	}

	public void setPaymentSeq(Integer paymentSeq) {
		this.paymentSeq = paymentSeq;
	}

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

	public Integer getCoachingCentreId() {
		return coachingCentreId;
	}

	public void setCoachingCentreId(Integer coachingCentreId) {
		this.coachingCentreId = coachingCentreId;
	}

	public Integer getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(Integer userSeq) {
		this.userSeq = userSeq;
	}

}
