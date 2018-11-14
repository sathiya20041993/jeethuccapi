package com.app.coacingcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.coacingcenter.entity.PaymentDetail;

public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Integer> {

	@Query(value = "SELECT c.payment_seq FROM payment_details c WHERE c.student_student_id = :studentId AND c.couch_center_id = :centerId ORDER BY c.payment_seq DESC LIMIT 1", nativeQuery = true)
	public Integer getLastPaySeq(@Param("studentId") Integer studentId, @Param("centerId") Integer centerId);

}
