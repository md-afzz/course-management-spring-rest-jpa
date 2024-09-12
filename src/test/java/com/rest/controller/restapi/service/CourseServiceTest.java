
  package com.rest.controller.restapi.service;
  
  import static org.assertj.core.api.Assertions.assertThat; import static
  org.mockito.BDDMockito.given; import static org.mockito.BDDMockito.verify;
  
  import java.util.List;
  
  import org.junit.jupiter.api.Test; import
  org.junit.jupiter.api.extension.ExtendWith; import org.mockito.InjectMocks;
  import org.mockito.Mock; import org.mockito.junit.jupiter.MockitoExtension;
  
  import com.rest.controller.restapi.entity.Course; import
  com.rest.controller.restapi.repository.CourseRepo;
  
  @ExtendWith(MockitoExtension.class)
  
  public class CourseServiceTest {
  
  @Mock private CourseRepo courseRepo;
  
  @InjectMocks private CourseServiceImpl2 courseService;
  
  @Test void getAllCourse() {
  System.out.println("Inside getAllCourse test case !!"); Course course1=
  Course.builder().courseDesc("Complete Reference").courseName("Java").courseID
  (52L).build(); Course course2= new Course(102L, "Complete Ref", "Java",
  "transient");
  
  given(courseRepo.findAll()) .willReturn(List.of(course1, course2));
  
  System.out.println("AfterGiven method!!");
  
  List<Course> courseList= courseService.getAllCourses();
  
  System.out.println("courseList  "+courseList);
  
  assertThat(courseList).isNotNull();
  assertThat(courseList.size()).isEqualTo(2);
  
  
  }
  
  
  
  }
 