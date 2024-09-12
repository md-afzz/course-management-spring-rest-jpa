package com.rest.controller.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.controller.restapi.entity.Course;


public interface CourseRepo extends JpaRepository<Course, Long>{

}
