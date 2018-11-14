package com.app.coacingcenter.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.app.coacingcenter.entity.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

	public Optional<User> findOneByUserIdAndPasswordAndActiveTrue(String userId, String passWord);

	public Optional<User> findOneByUserId(String userId);

}
