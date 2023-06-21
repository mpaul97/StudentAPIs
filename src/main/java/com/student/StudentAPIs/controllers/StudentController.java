package com.student.StudentAPIs.controllers;

import com.student.StudentAPIs.entities.Student;
import com.student.StudentAPIs.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    };

    @GetMapping("all")
    public List<Student> getAllStudents() {
        return this.studentService.getAllStudents();
    };

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Student foundStudent = this.studentService.getStudentById(id);
        HttpStatus status;
        if (foundStudent == null) {
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity("Student not found", status);
        };
        status = HttpStatus.OK;
        return new ResponseEntity(foundStudent, status);
    };

    @PostMapping("add")
    public Student postStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

    @DeleteMapping("deleteAll")
    public String deleteAllStudents() {
        this.studentService.deleteAllStudents();
        return "Deleted all students.";
    }

}
