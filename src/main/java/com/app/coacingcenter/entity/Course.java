package com.app.coacingcenter.entity;

import javax.persistence.Column;
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
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@FieldMapper(name = "courseSeq")
	private Integer courseId;

	@Column
	@FieldMapper(name = "courseName")
	private String courseName;

	@Column
	@FieldMapper(name = "fees", type = "double")
	private double feesAmount;

	@FieldMapper(name = "isEbookAvailable", type = "boolean")
	private boolean isEbookAvailable;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "couch_center_id", nullable = false)
	private CoachingCenter couchingCenter;

	@Column
	@FieldMapper(name = "isActive", type = "boolean")
	private boolean isActive;

	@Column
	@FieldMapper(name = "fileName")
	private String fileName;

	@Column
	@FieldMapper(name = "downloadLink")
	private String downloadLink;

	@Column
	@FieldMapper(name = "certificateSeriesPrefix")
	private String certificateSeriesPrefix;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public CoachingCenter getCouchingCenter() {
		return couchingCenter;
	}

	public void setCouchingCenter(CoachingCenter couchingCenter) {
		this.couchingCenter = couchingCenter;
	}

	public boolean getIsEbookAvailable() {
		return isEbookAvailable;
	}

	public void setIsEbookAvailable(boolean isEbookAvailable) {
		this.isEbookAvailable = isEbookAvailable;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
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

	public double getFeesAmount() {
		return feesAmount;
	}

	public void setFeesAmount(double feesAmount) {
		this.feesAmount = feesAmount;

	}

	public String getCertificateSeriesPrefix() {
		return certificateSeriesPrefix;
	}

	public void setCertificateSeriesPrefix(String certificateSeriesPrefix) {
		this.certificateSeriesPrefix = certificateSeriesPrefix;
	}

}
