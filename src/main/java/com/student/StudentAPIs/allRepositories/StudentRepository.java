package com.student.StudentAPIs.allRepositories;

import com.student.StudentAPIs.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Student getStudentById(Integer id);

    public Student getStudentByLastName(String lastName);

}
