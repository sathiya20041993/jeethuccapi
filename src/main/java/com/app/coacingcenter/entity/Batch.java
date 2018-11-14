package com.app.coacingcenter.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "batch")
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer batchId;

	@Column
	private String batchName;

	@Column
	private String batchTiming;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "couch_center_id", nullable = false)
	private CoachingCenter couchingCenter;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "couchingCenter")
	private List<Student> students;

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getBatchTiming() {
		return batchTiming;
	}

	public void setBatchTiming(String batchTiming) {
		this.batchTiming = batchTiming;
	}

	public CoachingCenter getCouchingCenter() {
		return couchingCenter;
	}

	public void setCouchingCenter(CoachingCenter couchingCenter) {
		this.couchingCenter = couchingCenter;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
