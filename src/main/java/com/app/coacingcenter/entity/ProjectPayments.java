package com.app.coacingcenter.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.coacingcenter.utils.FieldMapper;


@Entity
@Table(name = "projectpayments")
public class ProjectPayments {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@FieldMapper(name = "paymentId")
	private Integer paymentId;
	
	
	@FieldMapper(name = "paymentDate")
	private Date paymentDate;
	
	
	@FieldMapper(name = "paidAmount")
	private double paidAmount;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projectId", nullable = false)
	private Project project;

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Date getPaymentdate() {
		return paymentDate;
	}

	public void setPaymentdate(Date paymentdate) {
		this.paymentDate = paymentdate;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	
	
	

}
