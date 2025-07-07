package com.edutech.classroom.Repository;

import com.edutech.classroom.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer>{
    
}