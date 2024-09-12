package com.rest.controller.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rest.controller.restapi.entity.Course;
import com.rest.controller.restapi.repository.CourseRepo;

@Service("courseServiceImpl2")
public class CourseServiceImpl2 implements CourseService{
	
	@Autowired
	CourseRepo courseDaoImpl;

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		System.out.println("Inside getAllCourses !!"+ " className "+CourseServiceImpl2.class.getName());
		return courseDaoImpl.findAll();
	}

	@Override
	public ResponseEntity<Course> getCourseInfo(long id) {
		// TODO Auto-generated method stub
		return new ResponseEntity (courseDaoImpl.findById(id).orElse(null), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Course> createCourse(Course course) {
		// TODO Auto-generated method stub
		return  new ResponseEntity( courseDaoImpl.save(course), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Course> updateCourse(Course course) {
		// TODO Auto-generated method stub
		System.out.println("Inside update course!! ");
		 Optional<Course> opt=courseDaoImpl.findById(course.getCourseID());
		 if(opt.isPresent()) {
			Course temp= opt.get();
			temp.setCourseDesc(course.getCourseDesc());
			temp.setCourseName(course.getCourseName());
			courseDaoImpl.save(temp);
			 return new ResponseEntity(temp, HttpStatus.OK);
		 }else {
			 return new ResponseEntity(HttpStatus.NOT_FOUND);
		 }
	}

	@Override
	public ResponseEntity<Course> deleteCourse(Course course) {
		// TODO Auto-generated method stub
		Course temp= courseDaoImpl.findById(course.getCourseID()).orElse(null);
		courseDaoImpl.deleteById(course.getCourseID());
		return temp!=null? new ResponseEntity(temp, HttpStatus.ACCEPTED) : new ResponseEntity(HttpStatus.CONFLICT);
	}

	@Override
	public ResponseEntity<Course> deleteCourse(long courseID) {
		// TODO Auto-generated method stub
		Course temp= courseDaoImpl.findById(courseID).orElse(null);
		System.out.println("temp === "+temp+ " INSIDE SERVICE method for deletion");
		courseDaoImpl.deleteById(courseID);
		return temp!=null? new ResponseEntity("Course is deleted successsfully", HttpStatus.ACCEPTED) : new ResponseEntity(HttpStatus.CONFLICT);
	}
	

}
