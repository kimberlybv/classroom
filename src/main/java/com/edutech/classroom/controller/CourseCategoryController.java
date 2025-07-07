package com.edutech.classroom.controller;

import com.edutech.classroom.dto.CourseCategoryDTO;
import com.edutech.classroom.service.CourseCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import java.util.List;

@RestController
@RequestMapping("/api/course-categories")
@RequiredArgsConstructor

public class CourseCategoryController {

    private final CourseCategoryService courseCategoryService;

    @GetMapping
    public ResponseEntity<List<CourseCategoryDTO>> findAll(){
        return ResponseEntity.ok(courseCategoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<CourseCategoryDTO>> findById(@PathVariable Integer id){
        CourseCategoryDTO dto = courseCategoryService.findById(id);
        EntityModel<CourseCategoryDTO> resource = EntityModel.of(dto);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseCategoryController.class).findById(id)).withSelfRel());
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseCategoryController.class).findAll()).withRel("all-categories"));
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<CourseCategoryDTO> create(@RequestBody @Valid CourseCategoryDTO dto) {
        return ResponseEntity.ok(courseCategoryService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseCategoryDTO> update(@PathVariable Integer id, @Valid @RequestBody CourseCategoryDTO dto){
        return ResponseEntity.ok(courseCategoryService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        courseCategoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}