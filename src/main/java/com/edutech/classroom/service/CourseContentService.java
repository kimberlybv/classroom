package com.edutech.classroom.service;

import com.edutech.classroom.Repository.CourseContentRepository;
import com.edutech.classroom.Repository.CourseRepository;
import com.edutech.classroom.dto.CourseContentDTO;
import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseContent;
import com.edutech.classroom.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CourseContentService {
    
    private final CourseContentRepository courseContentRepository;
    private final CourseRepository courseRepository;

    public List<CourseContentDTO> findAll(){
        return courseContentRepository.findAll().stream().map(CourseContentDTO::fromEntity).toList();
    }

    public CourseContentDTO findById(Integer id){
        return CourseContentDTO.fromEntity(courseContentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada")));
    }

    public CourseContentDTO create(CourseContentDTO dto) {
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        CourseContent entity = CourseContentDTO.toEntity(dto, course);
        CourseContent saved = courseContentRepository.save(entity);
        return CourseContentDTO.fromEntity(saved);
    }

    public CourseContentDTO update(Integer id, CourseContentDTO dto) {
        Course course = courseContentRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado")).getCourse();

        CourseContent updated = CourseContentDTO.toEntity(dto, course);
        updated.setId(id);
        CourseContent saved = courseContentRepository.save(updated);
        return CourseContentDTO.fromEntity(saved);
    }

    public void delete(Integer id) {
        courseContentRepository.delete(courseContentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Categoría no encontrada")));
    }
}