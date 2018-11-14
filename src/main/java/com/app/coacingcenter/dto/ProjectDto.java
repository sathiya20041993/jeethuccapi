package com.app.coacingcenter.dto;

import java.util.Date;

import com.app.coacingcenter.utils.FieldMapper;

public class ProjectDto {
	
	@FieldMapper(name = "projectId")
	private Integer projectId;
	
	@FieldMapper(name = "projectName")
	private String projectName;
	
	@FieldMapper(name = "description")
	private String description;
	
	@FieldMapper(name = "clientInformation")
	private String clientInformation;
	
	@FieldMapper(name = "projectAmount")
	private double projectAmount;
	
	@FieldMapper(name = "projectPaidAmount")
	private double projectPaidAmount;
	
	@FieldMapper(name = "projectPendingAmount")
	private double projectPendingAmount;
	
	@FieldMapper(name = "projectStartDate")
	private Date projectStartDate;
	
	@FieldMapper(name = "projectDurationInMonths")
	private Integer projectDurationInMonths;

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
	
}
