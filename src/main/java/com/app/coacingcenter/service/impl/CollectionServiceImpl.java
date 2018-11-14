package com.app.coacingcenter.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.coacingcenter.dto.CollectionDueReportDto;
import com.app.coacingcenter.entity.VwCollection;
import com.app.coacingcenter.repository.VwCollectionRepository;
import com.app.coacingcenter.service.CollectionService;

@Service
public class CollectionServiceImpl implements CollectionService {

	@Autowired
	VwCollectionRepository vwCollectionRepository;

	@Override
	public List<VwCollection> findAll() {
		return vwCollectionRepository.findAll();
	}

	@Override
	public List<VwCollection> findCollection(CollectionDueReportDto collectionReportDto) {
		List<VwCollection> data = new ArrayList<>();
		if (null != collectionReportDto.getCenterId() && null != collectionReportDto.getCounselorId()
				&& null != collectionReportDto.getFromDate() && null != collectionReportDto.getToDate()) {
			data = vwCollectionRepository.findByCenterIdAndCounselorIdAndPaymentDateBetween(
					collectionReportDto.getCenterId(), collectionReportDto.getCounselorId(),
					collectionReportDto.getFromDate(), collectionReportDto.getToDate());
		} else if (null != collectionReportDto.getCenterId() && null != collectionReportDto.getCounselorId()
				&& null != collectionReportDto.getFromDate()) {
			data = vwCollectionRepository.findByCenterIdAndCounselorIdAndPaymentDateBetween(
					collectionReportDto.getCenterId(), collectionReportDto.getCounselorId(),
					collectionReportDto.getFromDate(), new Date(Calendar.getInstance().getTime().getTime()));
		} else if (null != collectionReportDto.getCenterId() && null == collectionReportDto.getCounselorId()
				&& null != collectionReportDto.getFromDate() && null != collectionReportDto.getToDate()) {
			data = vwCollectionRepository.findByCenterIdAndPaymentDateBetween(collectionReportDto.getCenterId(),
					collectionReportDto.getFromDate(), collectionReportDto.getToDate());
		} else if (null != collectionReportDto.getCenterId() && null == collectionReportDto.getCounselorId()
				&& null != collectionReportDto.getFromDate()) {
			data = vwCollectionRepository.findByCenterIdAndPaymentDateBetween(collectionReportDto.getCenterId(),
					collectionReportDto.getFromDate(), new Date(Calendar.getInstance().getTime().getTime()));
		} else if (null != collectionReportDto.getCenterId() && null != collectionReportDto.getCounselorId()) {
			data = vwCollectionRepository.findByCenterIdAndCounselorId(collectionReportDto.getCenterId(),
					collectionReportDto.getCounselorId());
		} else if (null != collectionReportDto.getCenterId()) {
			data = vwCollectionRepository.findByCenterId(collectionReportDto.getCenterId());
		}
		return data;
	}

}