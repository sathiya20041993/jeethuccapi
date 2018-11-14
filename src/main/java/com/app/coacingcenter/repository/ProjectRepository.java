package com.app.coacingcenter.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.coacingcenter.entity.Project;

public interface ProjectRepository  extends PagingAndSortingRepository<Project, Integer> {

	
	
}
