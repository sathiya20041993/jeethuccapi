package com.app.coacingcenter.jdbcmodel;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BatcheWithPendingCertificate implements RowMapper<BatcheWithPendingCertificate> {

	private String batchName;

	private String centerId;

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	@Override
	public BatcheWithPendingCertificate mapRow(ResultSet rs, int arg1) throws SQLException {

		BatcheWithPendingCertificate batch = new BatcheWithPendingCertificate();

		batch.setBatchName(rs.getString("batchName"));
		batch.setCenterId(rs.getString("centerId"));
		return batch;
	}

	@Override
	public String toString() {
		return "BatcheWithPendingCertificate [batchName=" + batchName + ", centerId=" + centerId + "]";
	}

}
