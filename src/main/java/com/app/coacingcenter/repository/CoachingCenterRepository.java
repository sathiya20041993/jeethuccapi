package com.app.coacingcenter.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.coacingcenter.entity.CoachingCenter;

public interface CoachingCenterRepository extends PagingAndSortingRepository<CoachingCenter, Integer> {

	public CoachingCenter findByCouchingCenterId(String centerId);
}
