package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseContent;
import lombok.Data;

@Data
public class CourseContentDTO {

    private Integer id;
    private Integer courseId;
    private String title;
    private String contentType;
    private String url;
    private Integer orderIndex;

    public static CourseContentDTO fromEntity(CourseContent entity) {
        CourseContentDTO dto = new CourseContentDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourse().getId());
        dto.setTitle(entity.getTitle());
        dto.setContentType(entity.getContentType());
        dto.setUrl(entity.getUrl());
        dto.setOrderIndex(entity.getOrderIndex());
        return dto;
    }

    public static CourseContent toEntity(CourseContentDTO dto, Course course) {
        CourseContent entity = new CourseContent();
        entity.setId(dto.getId());
        entity.setCourse(course);
        entity.setTitle(dto.getTitle());
        entity.setContentType(dto.getContentType());
        entity.setUrl(dto.getUrl());
        entity.setOrderIndex(dto.getOrderIndex());
        return entity;
    }
}
