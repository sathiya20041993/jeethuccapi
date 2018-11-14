package com.app.coacingcenter.dto;

import java.util.List;
import java.util.Map;

public class StudentIndentDto {

	private String batchName;

	private List<Map<String, Object>> studentIndents;

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public List<Map<String, Object>> getStudentIndents() {
		return studentIndents;
	}

	public void setStudentIndents(List<Map<String, Object>> studentIndents) {
		this.studentIndents = studentIndents;
	}

}
