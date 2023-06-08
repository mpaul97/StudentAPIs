package com.student.StudentAPIs.serviceTests;

import com.student.StudentAPIs.allRepositories.CourseRepository;
import com.student.StudentAPIs.entities.Course;
import com.student.StudentAPIs.entities.Student;
import com.student.StudentAPIs.services.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CourseServiceTests {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService;

    @Test
    public void getAllCoursesTest() {
        courseService.getAllCourses();
        verify(courseRepository, times(1)).findAll();
    };

    @Test
    public void getCourseByIdTest() {
      int param_id = 1;
      courseService.getCourseById(param_id);
      verify(courseRepository, times(1)).findById(param_id);
    };

    @Test
    public void addCourseTest() {
        Course course = new Course();
        course.setSubject("Science");
        course.setClassNum(303);
        course.setCourseNum(201);
        course.setStudent(new Student());
        courseService.addCourse(course);
        verify(courseRepository, times(1)).save(course);
    };

    @Test
    public void getAllCoursesByStudentId() {
      int param_id = 1;
      courseService.getAllCoursesByStudentId(param_id);
      verify(courseRepository, times(1)).findAllById(Collections.singleton(param_id));
    };

}
