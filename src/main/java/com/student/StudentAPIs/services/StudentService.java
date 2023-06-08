package com.student.StudentAPIs.services;

import com.student.StudentAPIs.entities.Student;
import com.student.StudentAPIs.allRepositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    };

    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    };

    public Student getStudentById(Integer id) {
        if (id == null) {
            return null;
        };
        return this.studentRepository.findById(id).orElse(null);
    };

    public Student addStudent(Student student) {
        return this.studentRepository.save(student);
    };

}
