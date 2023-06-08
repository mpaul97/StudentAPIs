package com.student.StudentAPIs.entities;

import javax.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.student.StudentAPIs.entities.Student;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String subject;
    private Integer classNum;
    private Integer courseNum;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Student getStudent() {
        return this.student;
    };

    public void setStudent(Student student) {
        this.student = student;
    }

//    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
//    private Teacher teacher;
//
//    public Teacher getTeacher() {
//        return teacher;
//    };
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//
//    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
//    private List<Student> students;
//
//    public List<Student> getStudents() {
//        return students;
//    };
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    };

    public Course() {};

    public Course(Integer id, String subject, Integer classNum, Integer courseNum) {
        this.id = id;
        this.subject = subject;
        this.classNum = classNum;
        this.courseNum = courseNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    public Integer getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(Integer courseNum) {
        this.courseNum = courseNum;
    }
}
