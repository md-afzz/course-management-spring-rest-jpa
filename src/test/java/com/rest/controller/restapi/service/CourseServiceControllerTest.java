package com.rest.controller.restapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.controller.restapi.RestApiApplicationTests;
import com.rest.controller.restapi.entity.Course;

public class CourseServiceControllerTest extends RestApiApplicationTests {
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	/*
	 * @Test public void getCoursesList() throws Exception {
	 * System.out.println("Inside getCoursesList TEST CASE"); String uri =
	 * "/api/courses"; MvcResult mvcResult =
	 * mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.
	 * APPLICATION_JSON_VALUE)) .andReturn();
	 * 
	 * int status = mvcResult.getResponse().getStatus();
	 * System.out.println("GET ALL COURSES " + status); assertEquals(200, status);
	 * String content = mvcResult.getResponse().getContentAsString();
	 * System.out.println("content:: " + content); // Course[] productlist =
	 * super.mapFromJson(content, Course[].class); //
	 * System.out.println("Course list "+productlist); //
	 * assertTrue(productlist.length > 0); assertTrue(content.startsWith("[{\"")); }
	 * 
	 * @Test public void createCourse() throws Exception { String uri =
	 * "/api/courses"; Course course = new Course(); course.setHidden("Transient");
	 * course.setCourseDesc("Design Pattern"); course.setCourseName("Java");
	 * System.out.println("INSIDE CREATE COURSE TEST CASE"); String inputJson =
	 * super.mapToJson(course); System.out.println("INPUT JSON , CREATE TEST CASE "
	 * + inputJson); MvcResult mvcResult = mvc.perform(
	 * MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE
	 * ).content(inputJson)) .andReturn();
	 * 
	 * int status = mvcResult.getResponse().getStatus();
	 * System.out.println("CREATE STATUS CODE " + status); assertEquals(201,
	 * status); // String content = mvcResult.getResponse().getContentAsString(); //
	 * System.out.println("Content "+content); // assertEquals(content,
	 * "Course is created successfully"); }
	 * 
	 * @Test public void updateCourse() throws Exception { String uri =
	 * "/api/courses"; Course course = new Course(); course.setCourseID(102L);
	 * course.setHidden("Transient"); course.setCourseDesc("System Design");
	 * course.setCourseName("Java");
	 * System.out.println("INSIDE UPDATE COURSE TEST CASE"); String inputJson =
	 * super.mapToJson(course); MvcResult mvcResult = mvc.perform(
	 * MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
	 * .content(inputJson)) .andReturn();
	 * 
	 * int status = mvcResult.getResponse().getStatus();
	 * System.out.println("Inside updateCourseTest !!" + status); assertEquals(200,
	 * status); // String content = mvcResult.getResponse().getContentAsString(); //
	 * assertEquals(content, "Course is updated successsfully"); }
	 */

	@Test
	public void deleteCourse() throws Exception {
		String uri = "/api/courses/452";
		System.out.println("INSIDE DELETE COURSE TEST CASE");
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		System.out.println("DELETION STATUS CODE " + status);
//		assertEquals(202, status);
		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Course is deleted successsfully");
		System.out.println(content+" INSIDE DELEtion test case");
		assertEquals(content, "Course is deleted successsfully");
	}

}