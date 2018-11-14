package com.app.coacingcenter.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.app.coacingcenter.dao.StudentCoursesDao;
import com.app.coacingcenter.dto.CollectionDueReportDto;
import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.dto.StringLabelValuePair;
import com.app.coacingcenter.dto.StudentCourseDto;
import com.app.coacingcenter.entity.StudentCourse;
import com.app.coacingcenter.jdbcmodel.StudentCourseReport;
import com.app.coacingcenter.repository.StudentCourseRepository;
import com.app.coacingcenter.service.StudentCoursesService;

@Service
public class StudentCoursesServiceImpl implements StudentCoursesService {

	@Autowired
	StudentCourseRepository studentCourseRepository;

	@Autowired
	StudentCoursesDao studentCoursesDao;

	@Override
	public ResponseDto getBatches(Integer centerSeq) {
		ResponseDto response = null;
		List<String> courses = studentCourseRepository.getBatchesByCenterSeq(centerSeq);

		List<StringLabelValuePair> batches = new ArrayList<>();

		for (String batchName : courses) {
			StringLabelValuePair batch = new StringLabelValuePair();
			batch.setLabel(batchName);
			batch.setValue(batchName);
			batches.add(batch);
		}

		if (!CollectionUtils.isEmpty(batches)) {
			response = new ResponseDto(200, "success", batches);
		} else {
			response = new ResponseDto(250, "failure", null);
		}
		return response;
	}

	@Override
	public ResponseDto getStudentCoursePendingcertificateList(Integer centerSeq, String batchName) {
		ResponseDto response = null;
		List<StudentCourse> pendingCertificateList = studentCourseRepository
				.getStudentCoursePendingcertificateList(centerSeq, batchName);
		System.out.println(centerSeq + "-------" + batchName);
		List<StudentCourseDto> pendingCertificateDtoList = new ArrayList<>();

		for (StudentCourse pendingCertificate : pendingCertificateList) {
			StudentCourseDto pendingCertificateDto = new StudentCourseDto();
			pendingCertificateDto.setRegistrationId(pendingCertificate.getRegistrationId());
			pendingCertificateDto.setStudentName(pendingCertificate.getStudent().getStudentName());
			pendingCertificateDto.setCourseName(pendingCertificate.getCourse().getCourseName());
			pendingCertificateDto.setGradeObtained(pendingCertificate.getGradeObtained());
			pendingCertificateDto.setCertificateNumber(pendingCertificate.getCertificateNumber());
			pendingCertificateDto.setIsCertificatePreinted(pendingCertificate.getIsCertificatePreinted());
			pendingCertificateDto.setIsIndentCompleted(pendingCertificate.getIsIndentCompleted());

			if (pendingCertificate.getIsCertificatePreinted()) {
				pendingCertificateDto.setCertificatePrintedYesOrNo("Yes");
			} else {
				pendingCertificateDto.setCertificatePrintedYesOrNo("No");
			}
			pendingCertificateDtoList.add(pendingCertificateDto);
		}

		if (!CollectionUtils.isEmpty(pendingCertificateDtoList)) {
			response = new ResponseDto(200, "success", pendingCertificateDtoList);
		} else {
			response = new ResponseDto(250, "failure", null);
		}
		return response;
	}

	@Override
	public ResponseDto updateCertificatePrinted(Integer centerSeq, String batchName) {

		ResponseDto response = null;
		studentCourseRepository.updateCertificatePrinted(centerSeq, batchName);
		response = new ResponseDto(200, "success", null);
		return response;
	}

	@Override
	public List<StudentCourseReport> getStudentCourseReport(CollectionDueReportDto collectionReportDto) {
		return studentCoursesDao.getStudentCourseReport(collectionReportDto);

	}

}
