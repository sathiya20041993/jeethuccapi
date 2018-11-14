package com.app.coacingcenter.service;

import java.util.List;

import com.app.coacingcenter.dto.CollectionDueReportDto;
import com.app.coacingcenter.entity.VwDue;

public interface DueService {

	public List<VwDue> findAll();

	public List<VwDue> searchDues(CollectionDueReportDto collectionReportDto);

}