package com.rest.controller.restapi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.controller.restapi.entity.Course;
import com.rest.controller.restapi.service.CourseService;

//  providing any routes , here, controller level
@RestController
@RequestMapping("/api/")
public class RestControllerDemo {
	
	@Autowired
	@Qualifier("courseServiceImpl2")
	CourseService courseServiceImpl;
	
	
//	@RequestMapping(path = "/home", method=RequestMethod.GET)
	@GetMapping("/home")
	public String homePage() {
		System.out.println("Inside homepage method!!");
		return "This is home page";
	}
	
	@GetMapping("/courses")
	public ResponseEntity<Course> getAllCourses() {
		List<Course> courses= this.courseServiceImpl.getAllCourses();
		return new ResponseEntity(courses, HttpStatus.OK);
	}
	

	@GetMapping("/courses/{courseID}")
	public ResponseEntity<Course> getCourseById(@PathVariable("courseID") long courseID) {
		return this.courseServiceImpl.getCourseInfo(courseID);
	}
	
	@PostMapping(path = "/courses"/* ,consumes={"application/json","applcation/xml"}, produces= {"text/html"} */)
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		return this.courseServiceImpl.createCourse(course);
	}
	
	@PutMapping("/courses")
	public ResponseEntity<Course> updateCourseInfo(@RequestBody Course course) {
		return this.courseServiceImpl.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseID}")
	public ResponseEntity<Course> deleteCourse(@PathVariable("courseID") long courseID){
		return this.courseServiceImpl.deleteCourse(courseID);

	}
	
	@DeleteMapping("/courses")
	public ResponseEntity<Course> deleteCourse(@RequestBody Course course){
		return this.courseServiceImpl.deleteCourse(course);
	}
	
}
