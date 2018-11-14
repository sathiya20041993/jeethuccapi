package com.app.coacingcenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.coacingcenter.entity.VwDue;

public interface VwDueRepository extends JpaRepository<VwDue, String> {

	public List<VwDue> findByCenterId(Integer centerId);

	public List<VwDue> findByCenterIdAndCounselorId(Integer centerId, Integer counselorId);

	public List<VwDue> findByCenterIdAndStudentIdIn(Integer centerId, List<Integer> studentIds);

	public List<VwDue> findByCenterIdAndCounselorIdAndStudentIdIn(Integer centerId, Integer counselorId,
			List<Integer> studentIds);

}