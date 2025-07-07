package com.edutech.classroom.controller;

import com.edutech.classroom.dto.CourseCommentDTO;
import com.edutech.classroom.service.CourseCommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import java.util.List;

@RestController
@RequestMapping("/api/course-comments")
@RequiredArgsConstructor

public class CourseCommentController {

    private final CourseCommentService courseCommentService;

    @GetMapping
    public ResponseEntity<List<CourseCommentDTO>> findAll() {
        return ResponseEntity.ok(courseCommentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<CourseCommentDTO>> findById(@PathVariable Integer id) {
        CourseCommentDTO dto = courseCommentService.findById(id);
        EntityModel<CourseCommentDTO> resource = EntityModel.of(dto);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseCommentController.class).findById(id)).withSelfRel());
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseCommentController.class).findAll()).withRel("all-comments"));
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<CourseCommentDTO> create(@RequestBody @Valid CourseCommentDTO dto) {
        return ResponseEntity.ok(courseCommentService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseCommentDTO> update(@PathVariable Integer id,
                                                   @Valid @RequestBody CourseCommentDTO dto) {
        return ResponseEntity.ok(courseCommentService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        courseCommentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}