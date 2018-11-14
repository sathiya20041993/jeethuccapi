package com.app.coacingcenter.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.coacingcenter.dto.CollectionDueReportDto;
import com.app.coacingcenter.entity.VwDue;
import com.app.coacingcenter.repository.StudentCourseRepository;
import com.app.coacingcenter.repository.VwDueRepository;
import com.app.coacingcenter.service.DueService;

@Service
public class DueServiceImpl implements DueService {

	@Autowired
	VwDueRepository vwDueRepository;

	@Autowired
	StudentCourseRepository studentCourseRepository;

	@Override
	public List<VwDue> findAll() {
		return vwDueRepository.findAll();
	}

	@Override
	public List<VwDue> searchDues(CollectionDueReportDto collectionReportDto) {
		List<VwDue> data = new ArrayList<>();
		List<Integer> studentIds = null;
		if (null != collectionReportDto.getCenterId() && null != collectionReportDto.getCounselorId()
				&& null != collectionReportDto.getFromDate() && null != collectionReportDto.getToDate()) {
			studentIds = studentCourseRepository.getStudentIds(collectionReportDto.getFromDate(),
					collectionReportDto.getToDate());
			data = vwDueRepository.findByCenterIdAndCounselorIdAndStudentIdIn(collectionReportDto.getCenterId(),
					collectionReportDto.getCounselorId(), studentIds);
		} else if (null != collectionReportDto.getCenterId() && null != collectionReportDto.getCounselorId()
				&& null != collectionReportDto.getFromDate()) {
			studentIds = studentCourseRepository.getStudentIds(collectionReportDto.getFromDate(),
					new Date(Calendar.getInstance().getTimeInMillis()));
			data = vwDueRepository.findByCenterIdAndCounselorIdAndStudentIdIn(collectionReportDto.getCenterId(),
					collectionReportDto.getCounselorId(), studentIds);
		} else if (null != collectionReportDto.getCenterId() && null == collectionReportDto.getCounselorId()
				&& null != collectionReportDto.getFromDate() && null != collectionReportDto.getToDate()) {
			studentIds = studentCourseRepository.getStudentIds(collectionReportDto.getFromDate(),
					collectionReportDto.getToDate());
			data = vwDueRepository.findByCenterIdAndStudentIdIn(collectionReportDto.getCenterId(), studentIds);
		} else if (null != collectionReportDto.getCenterId() && null == collectionReportDto.getCounselorId()
				&& null != collectionReportDto.getFromDate()) {
			studentIds = studentCourseRepository.getStudentIds(collectionReportDto.getFromDate(),
					new Date(Calendar.getInstance().getTimeInMillis()));
			data = vwDueRepository.findByCenterIdAndStudentIdIn(collectionReportDto.getCenterId(), studentIds);
		} else if (null != collectionReportDto.getCenterId() && null != collectionReportDto.getCounselorId()) {
			data = vwDueRepository.findByCenterIdAndCounselorId(collectionReportDto.getCenterId(),
					collectionReportDto.getCounselorId());
		} else if (null != collectionReportDto.getCenterId()) {
			data = vwDueRepository.findByCenterId(collectionReportDto.getCenterId());
		}
		return data;
	}

}