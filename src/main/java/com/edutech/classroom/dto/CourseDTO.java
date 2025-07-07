package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseCategory;
import com.edutech.classroom.entity.User;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data

public class CourseDTO {
    private Integer id;
    private String title;
    private String description;
    private Integer categoryId;
    private Integer managerId;
    private Integer instructorId;
    private LocalDate publishDate;
    private BigDecimal price;
    private String image;
    private String status;

    public static CourseDTO fromEntity(Course entity) {
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setCategoryId(entity.getCategory().getId());
        dto.setManagerId(entity.getManager().getId());
        dto.setInstructorId(entity.getInstructor().getId());
        dto.setPublishDate(entity.getPublishDate());
        dto.setPrice(entity.getPrice());
        dto.setImage(entity.getImage());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static Course toEntity(CourseDTO dto, CourseCategory courseCategory, User manager, User instructor) {
        Course entity = new Course();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setCategory(courseCategory);
        entity.setManager(manager);
        entity.setInstructor(instructor);
        entity.setPublishDate(dto.getPublishDate());
        entity.setPrice(dto.getPrice());
        entity.setImage(dto.getImage());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
