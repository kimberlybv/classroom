package com.edutech.classroom.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Instant;

class CourseCommentTest {
    @Test
    void testSettersAndGetters() {
        CourseComment comment = new CourseComment();
        comment.setCommentText("Great course!");
        comment.setRating(5);
        Instant now = Instant.now();
        comment.setCreatedAt(now);
        assertEquals("Great course!", comment.getCommentText());
        assertEquals(5, comment.getRating());
        assertEquals(now, comment.getCreatedAt());
    }
}
