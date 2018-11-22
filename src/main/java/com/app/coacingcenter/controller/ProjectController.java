package com.app.coacingcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.coacingcenter.dto.ProjectDto;
import com.app.coacingcenter.dto.ProjectPaymentDto;
import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseDto list() {
		return projectService.getAllprojects();

	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseDto saveOrUpdate(@RequestBody ProjectDto project) {
		return projectService.saveOrUpdate(project);

	}
	
	@RequestMapping(value = "/getInfo", method = RequestMethod.POST)
	public ResponseDto getProjectInfo(@RequestBody ProjectDto project) {
		return projectService.getProjectInfo(project);

	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public ResponseDto addPayment(@RequestBody ProjectPaymentDto projectPaymentDto) {
		return projectService.addPayment(projectPaymentDto);

	}
}
