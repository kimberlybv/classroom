package com.edutech.classroom.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseContentTest {
    @Test
    void testSettersAndGetters() {
        CourseContent content = new CourseContent();
        content.setTitle("Content Title");
        content.setContentType("video");
        content.setUrl("http://test.com");
        content.setOrderIndex(1);
        assertEquals("Content Title", content.getTitle());
        assertEquals("video", content.getContentType());
        assertEquals("http://test.com", content.getUrl());
        assertEquals(1, content.getOrderIndex());
    }
}
