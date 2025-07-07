package com.edutech.classroom.controller;

import com.edutech.classroom.dto.CourseContentDTO;
import com.edutech.classroom.service.CourseContentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import java.util.List;

@RestController
@RequestMapping("/api/course-contents")
@RequiredArgsConstructor

public class CourseContentController {

    private final CourseContentService courseContentService;

    @GetMapping
    public ResponseEntity<List<CourseContentDTO>> findAll() {
        return ResponseEntity.ok(courseContentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<CourseContentDTO>> findById(@PathVariable Integer id) {
        CourseContentDTO dto = courseContentService.findById(id);
        EntityModel<CourseContentDTO> resource = EntityModel.of(dto);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseContentController.class).findById(id)).withSelfRel());
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseContentController.class).findAll()).withRel("all-contents"));
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<CourseContentDTO> create(@RequestBody @Valid CourseContentDTO dto) {
        return ResponseEntity.ok(courseContentService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseContentDTO> update(@PathVariable Integer id,
                                                   @RequestBody @Valid CourseContentDTO dto) {
        return ResponseEntity.ok(courseContentService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        courseContentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
