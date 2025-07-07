package com.edutech.classroom.Repository;

import com.edutech.classroom.entity.CourseQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseQuizRepository extends JpaRepository<CourseQuiz, Integer>{
    
}