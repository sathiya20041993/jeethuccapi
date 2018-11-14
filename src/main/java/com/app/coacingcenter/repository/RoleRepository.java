package com.app.coacingcenter.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.app.coacingcenter.entity.Role;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {

}
