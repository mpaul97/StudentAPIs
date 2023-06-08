package com.student.StudentAPIs.serviceTests;

import com.student.StudentAPIs.allRepositories.StudentRepository;
import com.student.StudentAPIs.entities.Student;
import com.student.StudentAPIs.services.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class StudentServiceTests {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void getAllStudentsTest() {
        studentService.getAllStudents();
        verify(studentRepository, times(1)).findAll();
    };

    @Test
    public void getStudentByIdTest() {
        int param_id = 1;
        studentService.getStudentById(param_id);
        verify(studentRepository, times(1)).findById(param_id);
    };

    @Test
    public void addStudentTest() {
        Student student = new Student();
        student.setFirstName("Tom");
        student.setLastName("Appleseed");
        student.setGradeType("Junior");
        student.setAge(17);
        student.setGpa((float)3.4);
        student.setCourses(new ArrayList<>());
        studentService.addStudent(student);
        verify(studentRepository, times(1)).save(student);
    };

}
