package com.app.coacingcenter.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.coacingcenter.dto.ProjectDto;
import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.entity.Project;
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
		
		List<Project> projectDtos = new ArrayList<>();
		
		List<Project> projects = (List<Project>)projectRepository.findAll();
		
		for(Project project : projects) {
			ProjectDto dto = fieldMapperService.populateDataToNewInstance(project, ProjectDto.class);
			projectDtos.add(project);
		
		}
		return new ResponseDto(200, "success" , projectDtos);
	}

}
