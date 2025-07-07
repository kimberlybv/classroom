package com.edutech.classroom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-user", url = "http://localhost:9005/api/users")
public interface UserClient {
    @GetMapping("/{id}")
    Object getUserById(@PathVariable("id") String id);
}
