package com.app.coacingcenter.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.coacingcenter.dto.ProjectDto;
import com.app.coacingcenter.dto.ProjectPaymentDto;
import com.app.coacingcenter.dto.ProjectPaymentsDto;
import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.entity.Project;
import com.app.coacingcenter.entity.ProjectPayments;
import com.app.coacingcenter.repository.ProjectRepository;
import com.app.coacingcenter.service.ProjectService;
import com.app.coacingcenter.utils.FieldMapperService;


@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	FieldMapperService fieldMapperService;

	@Override
	public ResponseDto getAllprojects() {
		
		List<ProjectDto> projectDtos = new ArrayList<>();
		
		List<Project> projects = (List<Project>)projectRepository.findAll();
		
		for(Project project : projects) {
			ProjectDto dto = fieldMapperService.populateDataToNewInstance(project, ProjectDto.class);
			projectDtos.add(dto);
		
		}
		return new ResponseDto(200, "Success" , projectDtos);
	}

	@Override
	public ResponseDto saveOrUpdate(ProjectDto projectDto) {
		
		Project project = fieldMapperService.populateDataToNewInstance(projectDto, Project.class);
		project.setProjectStartDate(projectDto.getProjectStartDate());
		
		if(projectDto.getProjectId()==null) {
			project.setProjectPendingAmount(projectDto.getProjectAmount());
		}
		projectRepository.save(project);
		
		return new ResponseDto(200, "Success" , null);
	}

	@Override
	@Transactional
	public ResponseDto getProjectInfo(ProjectDto projectDto) {
		Optional<Project> optnalProject = projectRepository.findById(projectDto.getProjectId());
		Project project = optnalProject.get();
		ProjectDto info = fieldMapperService.populateDataToNewInstance(project, ProjectDto.class);
		info.setProjectStartDate(project.getProjectStartDate());
		
		
		List<ProjectPaymentsDto> paymentsDtos = new ArrayList<>();
		List<ProjectPayments> payments = project.getPayments();
		
		for(ProjectPayments pay : payments) {
			ProjectPaymentsDto dto = new ProjectPaymentsDto();
			dto.setPaidAmount(pay.getPaidAmount());
			dto.setPaymentDate(pay.getPaymentdate());
			paymentsDtos.add(dto);
		}
		info.setPayments(paymentsDtos);
		return new ResponseDto(200, "Success" , info);
		
	}

	@Override
	public ResponseDto addPayment(ProjectPaymentDto projectPaymentDto) {
		Optional<Project> optnalProject = projectRepository.findById(projectPaymentDto.getProjectId());
		Project project = optnalProject.get();
		
		double previousPaidAmount = project.getProjectPaidAmount();
		double previousPendingAmount = project.getProjectPendingAmount();
		double currentPaidAmount = previousPaidAmount + projectPaymentDto.getReceivedAmount();
		double currentPendingAmount = previousPendingAmount - projectPaymentDto.getReceivedAmount();
		
		project.setProjectPaidAmount(currentPaidAmount);
		project.setProjectPendingAmount(currentPendingAmount);
		
		ProjectPayments payment = new ProjectPayments();
		payment.setPaymentdate(new Date());
		payment.setPaidAmount(projectPaymentDto.getReceivedAmount());
		payment.setProject(project);
		List<ProjectPayments> payments = project.getPayments();
		
		if(payments==null) {
			payments = new ArrayList<>();
		}
		payments.add(payment);
		project.setPayments(payments);
		projectRepository.save(project);
		return new ResponseDto(200, "Success" , null);
	}

}
