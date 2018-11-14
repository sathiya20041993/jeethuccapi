package com.app.coacingcenter.dto;

import javax.persistence.Column;

import com.app.coacingcenter.utils.FieldMapper;

public class CoursesDto {

	@FieldMapper(name = "courseSeq")
	private Integer courseSeq;

	@FieldMapper(name = "courseName")
	private String courseName;

	@FieldMapper(name = "isEbookAvailable", type = "boolean")
	private boolean isEbookAvailable;

	@FieldMapper(name = "fees", type = "double")
	private double fees;

	@FieldMapper(name = "isActive", type = "boolean")
	private boolean isActive;

	@FieldMapper(name = "fileName")
	private String fileName;

	@FieldMapper(name = "downloadLink")
	private String downloadLink;

	@Column
	@FieldMapper(name = "certificateSeriesPrefix")
	private String certificateSeriesPrefix;

	public Integer getCourseId() {
		return courseSeq;
	}

	public void setCourseId(Integer courseSeq) {
		this.courseSeq = courseSeq;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public boolean getIsEbookAvailable() {
		return isEbookAvailable;
	}

	public void setIsEbookAvailable(boolean isEbookAvailable) {
		this.isEbookAvailable = isEbookAvailable;
	}

	public Integer getCourseSeq() {
		return courseSeq;
	}

	public void setCourseSeq(Integer courseSeq) {
		this.courseSeq = courseSeq;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDownloadLink() {
		return downloadLink;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}

	public String getCertificateSeriesPrefix() {
		return certificateSeriesPrefix;
	}

	public void setCertificateSeriesPrefix(String certificateSeriesPrefix) {
		this.certificateSeriesPrefix = certificateSeriesPrefix;
	}

}
