package com.app.coacingcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.coacingcenter.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
