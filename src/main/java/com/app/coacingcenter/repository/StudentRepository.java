package com.app.coacingcenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.coacingcenter.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(value = "SELECT c.student_code FROM student c ORDER BY c.student_code DESC LIMIT 1", nativeQuery = true)
	public String getLastStudentCode();

	public List<Student> findByCouchingCenterCenterSeqIdAndStudentNameLike(Integer centerSeqId, String key);

	public List<Student> findByCouchingCenterCenterSeqId(Integer centerSeq);

}
