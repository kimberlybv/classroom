package com.edutech.classroom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-course-content", url = "http://localhost:9009/api/course-contents")
public interface CoursecontentClient {
    @GetMapping("/{id}")
    Object getCourseContentById(@PathVariable("id") String id);
}
