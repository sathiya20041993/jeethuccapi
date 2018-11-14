package com.app.coacingcenter.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Due view
 */
@Entity
@Table(name = "vw_due")
public class VwDue implements Serializable {

	private static final long serialVersionUID = 1l;

	@Column
	@Id
	Integer payment_seq;

	/** Property center_id */
	@Column(name = "center_id")
	Integer centerId;

	/** Property center */
	@Column
	String center;

	/** Property counselor_id */
	@Column(name = "counselor_id")
	Integer counselorId;

	/** Property counselor */
	@Column
	String counselor;

	/** Property student */
	@Column
	String student;

	@Column(name = "student_id")
	Integer studentId;

	/** Property due */
	@Column
	Double due;

	/** Property join_date */
	@Column
	Date join_date;

	/**
	 * Constructor
	 */
	public VwDue() {
	}

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
	 * Gets the student
	 */
	public String getStudent() {
		return this.student;
	}

	/**
	 * Sets the student
	 */
	public void setStudent(String value) {
		this.student = value;
	}

	/**
	 * Gets the due
	 */
	public Double getDue() {
		return this.due;
	}

	/**
	 * Sets the due
	 */
	public void setDue(Double value) {
		this.due = value;
	}

	/**
	 * Gets the join_date
	 */
	public Date getJoin_date() {
		return this.join_date;
	}

	/**
	 * Sets the join_date
	 */
	public void setJoin_date(Date value) {
		this.join_date = value;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

}