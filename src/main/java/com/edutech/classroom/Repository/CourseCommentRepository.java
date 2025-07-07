package com.edutech.classroom.Repository;

import com.edutech.classroom.entity.CourseComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseCommentRepository extends JpaRepository<CourseComment, Integer> {
    
}