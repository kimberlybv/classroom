package com.edutech.classroom.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseCategoryTest {
    @Test
    void testSettersAndGetters() {
        CourseCategory category = new CourseCategory();
        category.setName("Programming");
        category.setDescription("Programming courses");
        assertEquals("Programming", category.getName());
        assertEquals("Programming courses", category.getDescription());
    }
}
