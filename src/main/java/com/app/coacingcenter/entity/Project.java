package com.app.coacingcenter.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.coacingcenter.utils.FieldMapper;


@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@FieldMapper(name = "projectId")
	private Integer projectId;
	
	@Column
	@FieldMapper(name = "projectName")
	private String projectName;
	
	@Column
	@FieldMapper(name = "description")
	private String description;
	
	@Column
	@FieldMapper(name = "clientInformation")
	private String clientInformation;
	
	@Column
	@FieldMapper(name = "projectAmount")
	private double projectAmount;
	
	@Column
	@FieldMapper(name = "projectPaidAmount")
	private double projectPaidAmount;
	
	@FieldMapper(name = "projectPendingAmount")
	private double projectPendingAmount;
	
	@Column
	@FieldMapper(name = "projectStartDate")
	private Date projectStartDate;
	
	@Column
	@FieldMapper(name = "projectDurationInMonths")
	private Integer projectDurationInMonths;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
	private List<ProjectPayments> payments;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClientInformation() {
		return clientInformation;
	}

	public void setClientInformation(String clientInformation) {
		this.clientInformation = clientInformation;
	}

	public double getProjectAmount() {
		return projectAmount;
	}

	public void setProjectAmount(double projectAmount) {
		this.projectAmount = projectAmount;
	}

	public double getProjectPaidAmount() {
		return projectPaidAmount;
	}

	public void setProjectPaidAmount(double projectPaidAmount) {
		this.projectPaidAmount = projectPaidAmount;
	}

	public double getProjectPendingAmount() {
		return projectPendingAmount;
	}

	public void setProjectPendingAmount(double projectPendingAmount) {
		this.projectPendingAmount = projectPendingAmount;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Integer getProjectDurationInMonths() {
		return projectDurationInMonths;
	}

	public void setProjectDurationInMonths(Integer projectDurationInMonths) {
		this.projectDurationInMonths = projectDurationInMonths;
	}

	public List<ProjectPayments> getPayments() {
		return payments;
	}

	public void setPayments(List<ProjectPayments> payments) {
		this.payments = payments;
	}
	
	
	
}
