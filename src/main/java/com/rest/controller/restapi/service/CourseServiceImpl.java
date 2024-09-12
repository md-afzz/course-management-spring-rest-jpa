package com.rest.controller.restapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rest.controller.restapi.entity.Course;


@Primary
@Service("courseServiceImpl1")
public class CourseServiceImpl implements CourseService {
	List<Course> courseList;
	
	

	public CourseServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		courseList=new ArrayList<Course>();
//		courseList.add(new Course(101,"Java","Core Java"));
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseList;
	}

	@Override
	public ResponseEntity<Course> getCourseInfo(long id) {
		// TODO Auto-generated method stub
		Course temp= courseList.stream().filter(x->x.getCourseID()==id).collect(Collectors.toList()).get(0);
		return new ResponseEntity(temp, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Course> createCourse(Course course) {
		// TODO Auto-generated method stub
		courseList.add(course);
		return new ResponseEntity(courseList, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Course> updateCourse(Course course) {
		// TODO Auto-generated method stub
		Course courseBeforeUpdation=courseList.stream().filter(x->x.getCourseID()==course.getCourseID()).collect(Collectors.toList()).get(0);
		boolean isremoved=courseList.remove(courseBeforeUpdation);
		if(isremoved) {
			courseList.add(course);
		}
		return new ResponseEntity(course, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Course> deleteCourse(Course course) {
		// TODO Auto-generated method stub
		boolean isRemoved=false;
		for(Course c:courseList) {
			if(c.getCourseID()==course.getCourseID()) {
				isRemoved=courseList.remove(course);
				break;
			}
		}
		if(isRemoved) {
			return new ResponseEntity<>(course, HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<>(course, HttpStatusCode.valueOf(404));
		}
	}

	@Override
	public ResponseEntity<Course> deleteCourse(long courseID) {
		// TODO Auto-generated method stub
		boolean isDeleted=false;
		for(Course c:courseList) {
			if(c.getCourseID()==courseID) {
				courseList.remove(c);
				isDeleted=true;
			}
		}
		if(isDeleted) {
			return new ResponseEntity<>( HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
