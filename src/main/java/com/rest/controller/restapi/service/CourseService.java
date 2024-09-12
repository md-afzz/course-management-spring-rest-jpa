package com.rest.controller.restapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rest.controller.restapi.entity.Course;

public interface CourseService {
	
	public List<Course> getAllCourses();
	
	public ResponseEntity<Course> getCourseInfo(long id);
	
	public ResponseEntity<Course> createCourse(Course course);
	
	public ResponseEntity<Course> updateCourse(Course course);
	
	public ResponseEntity<Course> deleteCourse(Course course);
	
	public ResponseEntity<Course> deleteCourse(long courseID);
	

}
