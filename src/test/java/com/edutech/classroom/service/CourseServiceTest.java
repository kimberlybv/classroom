package com.edutech.classroom.service;

import com.edutech.classroom.Repository.CourseCategoryRepository;
import com.edutech.classroom.Repository.CourseRepository;
import com.edutech.classroom.Repository.UserRepository;
import com.edutech.classroom.dto.CourseDTO;
import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseCategory;
import com.edutech.classroom.entity.User;
import com.edutech.classroom.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseServiceTest {
    @Mock
    private CourseRepository courseRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private CourseCategoryRepository courseCategoryRepository;
    @InjectMocks
    private CourseService courseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByIdThrowsExceptionIfNotFound() {
        when(courseRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> courseService.findById(1));
    }

    @Test
    void testCreateThrowsExceptionIfCategoryNotFound() {
        CourseDTO dto = new CourseDTO();
        dto.setCategoryId(1);
        when(courseCategoryRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> courseService.create(dto));
    }
}
