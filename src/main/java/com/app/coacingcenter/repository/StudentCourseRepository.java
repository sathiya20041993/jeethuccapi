package com.app.coacingcenter.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.coacingcenter.entity.StudentCourse;

@Repository
public interface StudentCourseRepository extends PagingAndSortingRepository<StudentCourse, Integer> {

	@Query("SELECT coalesce(max(studentCourse.certificateNumberSuffix), 100001) FROM StudentCourse studentCourse")
	public Integer maxCertificateNumber();

	public List<StudentCourse> findAllByRegisteredDateGreaterThanEqualAndRegisteredDateLessThanEqual(Date startDate,
			Date endDate);

	public List<StudentCourse> findAllByStudentStudentId(Integer studentId);

	public List<StudentCourse> findAllByStudentStudentIdAndCourseCourseId(Integer studentId, Integer courseId);

	@Query("SELECT DISTINCT sc.batchName FROM StudentCourse sc WHERE sc.centerSeq= ?1 and sc.isIndentCompleted = true and sc.isCertificatePreinted = false")
	public List<String> getBatchesByCenterSeq(Integer centerSeq);

	@Query("SELECT sc FROM StudentCourse sc WHERE sc.centerSeq= ?1 and sc.batchName= ?2 and sc.isIndentCompleted = true")
	public List<StudentCourse> getStudentCoursePendingcertificateList(Integer centerSeq, String batchName);

	@Transactional
	@Modifying
	@Query("UPDATE StudentCourse sc SET sc.isCertificatePreinted = true, sc.status='COMPLETED' WHERE sc.centerSeq= ?1 and sc.batchName= ?2 and sc.isIndentCompleted = true")
	public void updateCertificatePrinted(Integer centerSeq, String batchName);

	@Query("Select sc.student.studentId FROM StudentCourse sc where sc.registeredDate between ?1 and ?2")
	public List<Integer> getStudentIds(java.sql.Date fromDate, java.sql.Date toDate);

}
