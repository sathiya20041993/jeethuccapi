package com.app.coacingcenter.entity;

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
@Table(name = "payment_history")
public class PaymentHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentHistorySeq;

	@Column
	private double paidAmount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_id", nullable = false)
	private PaymentDetail paymentDetail;

	@Column
	private Date paymentTime;

	public Integer getPaymentHistorySeq() {
		return paymentHistorySeq;
	}

	public void setPaymentHistorySeq(Integer paymentHistorySeq) {
		this.paymentHistorySeq = paymentHistorySeq;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public PaymentDetail getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetail paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

}
