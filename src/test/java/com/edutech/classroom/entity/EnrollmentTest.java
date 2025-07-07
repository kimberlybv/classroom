package com.edutech.classroom.entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class EnrollmentTest {
    @Test
    void testEnrollmentConstructorAndGetters() {
        Course course = new Course();
        Long userId = 1L;
        LocalDateTime now = LocalDateTime.now();
        Enrollment enrollment = new Enrollment(course, userId, now);
        assertEquals(course, enrollment.getCourse());
        assertEquals(userId, enrollment.getUserId());
        assertEquals(now, enrollment.getEnrollmentDate());
    }
}
