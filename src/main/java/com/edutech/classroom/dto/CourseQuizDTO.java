package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseQuiz;
import lombok.Data;
import java.time.Instant;

@Data
public class CourseQuizDTO {

    private Integer id;
    private Integer courseId;
    private String title;
    private String description;
    private String quizType;
    private Instant createdAt;

    public static CourseQuizDTO fromEntity(CourseQuiz entity) {
        CourseQuizDTO dto = new CourseQuizDTO();
        dto.setId(entity.getId());
        if (entity.getCourse() != null) {
            dto.setCourseId(entity.getCourse().getId());
        }
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setQuizType(entity.getQuizType());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public static CourseQuiz toEntity(CourseQuizDTO dto, Course course) {
        CourseQuiz entity = new CourseQuiz();
        entity.setId(dto.getId());
        entity.setCourse(course);
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setQuizType(dto.getQuizType());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}
