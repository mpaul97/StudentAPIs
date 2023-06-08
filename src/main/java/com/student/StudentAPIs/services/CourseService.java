package com.student.StudentAPIs.services;

import com.student.StudentAPIs.allRepositories.CourseRepository;
import com.student.StudentAPIs.entities.Course;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    };

    public List<Course> getAllCourses() {
        return this.courseRepository.findAll();
    };

    public Course getCourseById(Integer id) {
        if (id == null) {
            return null;
        };
        return this.courseRepository.findById(id).orElse(null);
    };

    public Course addCourse(Course course) {
        return this.courseRepository.save(course);
    };

    public List<Course> getAllCoursesByStudentId(Integer studentId) {
        return this.courseRepository.findAllById(Collections.singleton(studentId));
    };

}
