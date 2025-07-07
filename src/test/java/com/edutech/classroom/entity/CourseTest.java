package com.edutech.classroom.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.time.LocalDate;

class CourseTest {
    @Test
    void testSettersAndGetters() {
        Course course = new Course();
        course.setTitle("Test Course");
        course.setDescription("Description");
        course.setPrice(new BigDecimal("10.00"));
        course.setPublishDate(LocalDate.now());
        course.setImage("image.png");
        assertEquals("Test Course", course.getTitle());
        assertEquals("Description", course.getDescription());
        assertEquals(new BigDecimal("10.00"), course.getPrice());
        assertEquals("image.png", course.getImage());
    }
}
