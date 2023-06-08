package com.student.StudentAPIs.allRepositories;

import com.student.StudentAPIs.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    public Course getCourseById(Integer id);

}
