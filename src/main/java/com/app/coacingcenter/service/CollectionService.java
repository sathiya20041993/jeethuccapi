package com.app.coacingcenter.service;

import java.util.List;

import com.app.coacingcenter.dto.CollectionDueReportDto;
import com.app.coacingcenter.entity.VwCollection;

public interface CollectionService {

	public List<VwCollection> findAll();

	public List<VwCollection> findCollection(CollectionDueReportDto collectionReportDto);
}