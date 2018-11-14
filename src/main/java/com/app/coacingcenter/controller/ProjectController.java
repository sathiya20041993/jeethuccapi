package com.app.coacingcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
