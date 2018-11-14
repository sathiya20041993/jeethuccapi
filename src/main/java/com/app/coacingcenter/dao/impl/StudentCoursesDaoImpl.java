package com.app.coacingcenter.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.coacingcenter.dao.StudentCoursesDao;
import com.app.coacingcenter.dto.CollectionDueReportDto;
import com.app.coacingcenter.jdbcmodel.BatcheWithPendingCertificate;
import com.app.coacingcenter.jdbcmodel.StudentCourseReport;

@Repository
public class StudentCoursesDaoImpl implements StudentCoursesDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<BatcheWithPendingCertificate> getCenterPendingCertificateBatchesReport(String centerId) {

		String query = "SELECT distinct(sc.batch_name) as batchName , c.couching_center_id as centerId FROM student_course sc left outer join couching_centere c on sc.center_seq = c.center_seq_id  where sc.center_seq = ? and sc.is_indent_completed = true and (sc.is_certificate_preinted = false or sc.is_certificate_preinted=null)";

		Object[] args = new Object[] { centerId };

		List<BatcheWithPendingCertificate> batches = jdbcTemplate.query(query, args,
				new BatcheWithPendingCertificate());

		return batches;

	}

	@Override
	public List<StudentCourseReport> getStudentCourseReport(CollectionDueReportDto collectionReportDto) {
		List<StudentCourseReport> data = new ArrayList<>();

		String baseQuery = "SELECT cc.center_seq_id as centerId ,cc.couching_center_id as center, u.user_id as counselor , s.student_name as student , s.student_code as studentId , s.student_id as studentSeq , c.course_name as courseName , sc.registered_date as joinDate  FROM student_course sc "
				+ " inner join student s on sc.student_id = s.student_id  "
				+ " inner join user u on sc.added_by = u.user_seq  "
				+ " inner join course c on sc.course_id = c.course_id  "
				+ " inner join couching_centere cc on sc.center_seq = cc.center_seq_id ";

		if (null != collectionReportDto.getCenterId() && null != collectionReportDto.getCounselorId()
				&& null != collectionReportDto.getFromDate() && null != collectionReportDto.getToDate()) {

			String query = baseQuery
					+ " where sc.center_seq = ?  and sc.added_by = ? and (sc.registered_date BETWEEN ? AND ?)";

			Object[] args = new Object[] { collectionReportDto.getCenterId(), collectionReportDto.getCounselorId(),
					collectionReportDto.getFromDate(), collectionReportDto.getToDate() };

			data = jdbcTemplate.query(query, args, new StudentCourseReport());

		} else if (null != collectionReportDto.getCenterId() && null != collectionReportDto.getCounselorId()
				&& null != collectionReportDto.getFromDate()) {

			String query = baseQuery
					+ " where sc.center_seq = ?  and sc.added_by = ? and (sc.registered_date BETWEEN ? AND ?)";

			Object[] args = new Object[] { collectionReportDto.getCenterId(), collectionReportDto.getCounselorId(),
					collectionReportDto.getFromDate(), new Date(Calendar.getInstance().getTime().getTime()) };

			data = jdbcTemplate.query(query, args, new StudentCourseReport());

		} else if (null != collectionReportDto.getCenterId() && null == collectionReportDto.getCounselorId()
				&& null != collectionReportDto.getFromDate() && null != collectionReportDto.getToDate()) {
			String query = baseQuery + " where sc.center_seq = ? and (sc.registered_date BETWEEN ? AND ?)";

			Object[] args = new Object[] { collectionReportDto.getCenterId(), collectionReportDto.getFromDate(),
					collectionReportDto.getToDate() };

			data = jdbcTemplate.query(query, args, new StudentCourseReport());
		} else if (null != collectionReportDto.getCenterId() && null == collectionReportDto.getCounselorId()
				&& null != collectionReportDto.getFromDate()) {
			String query = baseQuery + " where sc.center_seq = ? and (sc.registered_date BETWEEN ? AND ?)";

			Object[] args = new Object[] { collectionReportDto.getCenterId(), collectionReportDto.getFromDate(),
					new Date(Calendar.getInstance().getTime().getTime()) };
			data = jdbcTemplate.query(query, args, new StudentCourseReport());
		} else if (null != collectionReportDto.getCenterId() && null != collectionReportDto.getCounselorId()) {
			String query = baseQuery + " where sc.center_seq = ?  and sc.added_by = ? ";

			Object[] args = new Object[] { collectionReportDto.getCenterId(), collectionReportDto.getCounselorId() };
			data = jdbcTemplate.query(query, args, new StudentCourseReport());
		} else if (null != collectionReportDto.getCenterId()) {
			String query = baseQuery + " where sc.center_seq = ? ";
			Object[] args = new Object[] { collectionReportDto.getCenterId() };
			data = jdbcTemplate.query(query, args, new StudentCourseReport());
		}
		return data;
	}

}
