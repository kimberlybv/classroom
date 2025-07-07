package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseComment;
import com.edutech.classroom.entity.User;
import lombok.Data;
import java.time.Instant;

@Data
public class CourseCommentDTO {

    private Integer id;
    private Integer courseId;
    private Integer userId;
    private String commentText;
    private Integer rating;
    private Instant createdAt;

    public static CourseCommentDTO fromEntity(CourseComment entity) {
        CourseCommentDTO dto = new CourseCommentDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourse().getId());
        dto.setUserId(entity.getUser().getId());
        dto.setCommentText(entity.getCommentText());
        dto.setRating(entity.getRating());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public static CourseComment toEntity(CourseCommentDTO dto, Course course, User user) {
        CourseComment entity = new CourseComment();
        entity.setId(dto.getId());
        entity.setCourse(course);
        entity.setUser(user);
        entity.setCommentText(dto.getCommentText());
        entity.setRating(dto.getRating());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}
