package com.edutech.classroom.service;

import com.edutech.classroom.Repository.CourseCategoryRepository;
import com.edutech.classroom.dto.CourseCategoryDTO;
import com.edutech.classroom.entity.CourseCategory;
import com.edutech.classroom.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseCategoryServiceTest {
    @Mock
    private CourseCategoryRepository courseCategoryRepository;
    @InjectMocks
    private CourseCategoryService courseCategoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByIdThrowsExceptionIfNotFound() {
        when(courseCategoryRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> courseCategoryService.findById(1));
    }

    @Test
    void testCreateCategory() {
        CourseCategoryDTO dto = new CourseCategoryDTO();
        dto.setName("Programming");
        dto.setDescription("Programming courses");
        CourseCategory category = new CourseCategory();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        when(courseCategoryRepository.save(any(CourseCategory.class))).thenReturn(category);
        CourseCategoryDTO result = courseCategoryService.create(dto);
        assertEquals(dto.getName(), result.getName());
        assertEquals(dto.getDescription(), result.getDescription());
    }
}
