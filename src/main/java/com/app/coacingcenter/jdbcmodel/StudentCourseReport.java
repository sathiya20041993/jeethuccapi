package com.app.coacingcenter.jdbcmodel;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentCourseReport implements RowMapper<StudentCourseReport> {

	Integer centerId;

	String center;

	Integer counselorId;

	String counselor;

	String student;

	String studentId;

	Integer studentSeq;

	String courseName;

	Date joinDate;

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public Integer getCounselorId() {
		return counselorId;
	}

	public void setCounselorId(Integer counselorId) {
		this.counselorId = counselorId;
	}

	public String getCounselor() {
		return counselor;
	}

	public void setCounselor(String counselor) {
		this.counselor = counselor;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Integer getStudentSeq() {
		return studentSeq;
	}

	public void setStudentSeq(Integer studentSeq) {
		this.studentSeq = studentSeq;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public StudentCourseReport mapRow(ResultSet rs, int arg1) throws SQLException {

		StudentCourseReport studentCourseReport = new StudentCourseReport();
		studentCourseReport.setStudentId(rs.getString("studentId"));
		studentCourseReport.setStudentSeq(rs.getInt("studentSeq"));
		studentCourseReport.setJoinDate(rs.getDate("joinDate"));
		studentCourseReport.setCenter(rs.getString("center"));
		studentCourseReport.setCourseName(rs.getString("courseName"));
		studentCourseReport.setStudent(rs.getString("student"));
		studentCourseReport.setCounselor(rs.getString("counselor"));
		return studentCourseReport;
	}

}
