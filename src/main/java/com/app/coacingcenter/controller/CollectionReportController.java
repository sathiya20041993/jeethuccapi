package com.app.coacingcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.coacingcenter.dto.CollectionDueReportDto;
import com.app.coacingcenter.entity.VwCollection;
import com.app.coacingcenter.service.CollectionService;

@RestController
@RequestMapping("report/collection")
public class CollectionReportController {

	@Autowired
	CollectionService collectionService;

	@GetMapping
	public List<VwCollection> findAll() {
		return collectionService.findAll();
	}

	@PostMapping
	public List<VwCollection> searchCollection(@RequestBody CollectionDueReportDto collectionReportDto) {
		return collectionService.findCollection(collectionReportDto);
	}

}