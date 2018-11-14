package com.app.coacingcenter.dto;

public class FeeReceiptModel {

	private String reciptantname;
	private String paidAmount;
	private String courseName;
	private String otherCharges;
	private String grandTotal;
	private String postalAddress;
	private String date;
	private String receiptNo;
	private Integer centerSeq;
	private Integer studentId;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getCenterSeq() {
		return centerSeq;
	}

	public void setCenterSeq(Integer centerSeq) {
		this.centerSeq = centerSeq;
	}

	public String getReciptantname() {
		return reciptantname;
	}

	public void setReciptantname(String reciptantname) {
		this.reciptantname = reciptantname;
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getOtherCharges() {
		return otherCharges;
	}

	public void setOtherCharges(String otherCharges) {
		this.otherCharges = otherCharges;
	}

	public String getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

}
