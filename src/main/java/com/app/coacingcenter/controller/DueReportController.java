package com.app.coacingcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.coacingcenter.dto.CollectionDueReportDto;
import com.app.coacingcenter.entity.VwDue;
import com.app.coacingcenter.service.DueService;

@RestController
@RequestMapping("report/due")
public class DueReportController {

	@Autowired
	DueService dueService;

	@GetMapping
	public List<VwDue> findAll() {
		return dueService.findAll();
	}

	@PostMapping
	public List<VwDue> searchDues(@RequestBody CollectionDueReportDto collectionReportDto) {
		return dueService.searchDues(collectionReportDto);
	}

}