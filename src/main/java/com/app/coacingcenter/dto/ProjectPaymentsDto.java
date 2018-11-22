package com.app.coacingcenter.dto;

import java.util.Date;

import com.app.coacingcenter.utils.FieldMapper;

public class ProjectPaymentsDto {

	@FieldMapper(name = "paymentId")
	private Integer paymentId;
	
	
	@FieldMapper(name = "paymentDate")
	private Date paymentDate;
	
	
	@FieldMapper(name = "paidAmount")
	private double paidAmount;


	public Integer getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	public double getPaidAmount() {
		return paidAmount;
	}


	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}
	
	
	
	
}
