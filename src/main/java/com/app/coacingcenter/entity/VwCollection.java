package com.app.coacingcenter.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_collection")
public class VwCollection implements Serializable {

	private static final long serialVersionUID = 1l;

	@Column
	@Id
	Integer payment_seq;

	@Column(name = "center_id")
	private Integer centerId;

	@Column
	private String center;

	@Column(name = "counselor_id")
	private Integer counselorId;

	@Column
	private String counselor;

	@Column
	private Double collection;

	@Column(name = "payment_date")
	private Date paymentDate;

	public Integer getPayment_seq() {
		return this.payment_seq;
	}

	public void setPayment_seq(Integer value) {
		this.payment_seq = value;
	}

	/**
	 * Gets the center_id
	 */
	public Integer getCenterId() {
		return this.centerId;
	}

	/**
	 * Sets the center_id
	 */
	public void setCenterId(Integer value) {
		this.centerId = value;
	}

	/**
	 * Gets the center
	 */
	public String getCenter() {
		return this.center;
	}

	/**
	 * Sets the center
	 */
	public void setCenter(String value) {
		this.center = value;
	}

	/**
	 * Gets the counselor_id
	 */
	public Integer getCounselorId() {
		return this.counselorId;
	}

	/**
	 * Sets the counselor_id
	 */
	public void setCounselorId(Integer value) {
		this.counselorId = value;
	}

	/**
	 * Gets the counselor
	 */
	public String getCounselor() {
		return this.counselor;
	}

	/**
	 * Sets the counselor
	 */
	public void setCounselor(String value) {
		this.counselor = value;
	}

	/**
	 * Gets the collection
	 */
	public Double getCollection() {
		return this.collection;
	}

	/**
	 * Sets the collection
	 */
	public void setCollection(Double value) {
		this.collection = value;
	}

	/**
	 * Gets the payment_date
	 */
	public Date getPaymentDate() {
		return this.paymentDate;
	}

	/**
	 * Sets the payment_date
	 */
	public void setPaymentDate(Date value) {
		this.paymentDate = value;
	}

}
