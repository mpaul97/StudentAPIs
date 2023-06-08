package com.student.StudentAPIs.controllers;

import com.student.StudentAPIs.entities.Course;
import com.student.StudentAPIs.entities.Student;
import com.student.StudentAPIs.services.CourseService;
import com.student.StudentAPIs.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("courses")
public class CourseController {

    private CourseService courseService;
    private StudentService studentService;

    public CourseController(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    };

    @GetMapping("all")
    public List<Course> getAllCourses() {
        return this.courseService.getAllCourses();
    };

    @GetMapping("allByStudentId")
    public ResponseEntity<String> getAllCoursesByStudentId(@RequestParam Integer id) {
        Student foundStudent = this.studentService.getStudentById(id);
        HttpStatus status;
        if (foundStudent == null) {
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity("Student not found", status);
        }
        List<Course> allCourses = foundStudent.getCourses();
        status = HttpStatus.OK;
        return new ResponseEntity(allCourses, status);
    };

    @PostMapping("add")
    public ResponseEntity<String> postCourse(@RequestBody Course course, @RequestParam Integer id) {
        Student foundStudent = this.studentService.getStudentById(id);
        HttpStatus status;
        if (foundStudent == null) {
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity("student not found", status);
        };
        course.setStudent(foundStudent);
        this.courseService.addCourse(course);
        status = HttpStatus.OK;
        return new ResponseEntity(course, status);
    }


}
