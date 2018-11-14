package com.app.coacingcenter.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.coacingcenter.entity.VwCollection;

public interface VwCollectionRepository extends JpaRepository<VwCollection, Integer> {

	public List<VwCollection> findByCenterId(Integer centerId);

	public List<VwCollection> findByCenterIdAndCounselorId(Integer centerId, Integer counselorId);

	public List<VwCollection> findByCenterIdAndCounselorIdAndPaymentDateBetween(Integer centerId, Integer counselorId,
			Date startDate, Date endDate);

	public List<VwCollection> findByCenterIdAndPaymentDateBetween(Integer centerId, Date startDate, Date endDate);

}