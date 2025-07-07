package com.edutech.classroom.Repository;

import com.edutech.classroom.entity.CourseContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseContentRepository extends JpaRepository<CourseContent, Integer>{
    
}