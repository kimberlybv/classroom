package com.edutech.classroom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edutech.classroom.entity.CourseQuizQuestion;

public interface CourseQuizQuestionRepository extends JpaRepository<CourseQuizQuestion, Integer> {
    
}