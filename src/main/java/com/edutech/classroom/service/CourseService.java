package com.edutech.classroom.service;

import com.edutech.classroom.Repository.CourseCategoryRepository;
import com.edutech.classroom.Repository.CourseRepository;
import com.edutech.classroom.Repository.UserRepository;
import com.edutech.classroom.dto.CourseDTO;
import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseCategory;
import com.edutech.classroom.entity.User;
import com.edutech.classroom.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CourseCategoryRepository repo;

    public List<CourseDTO> findAll(){
        return courseRepository.findAll().stream().map(CourseDTO::fromEntity).toList();
    }

    public CourseDTO findById(Integer id){
        return CourseDTO.fromEntity(courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada")));
    }

    public CourseDTO create(CourseDTO dto) {
        CourseCategory category = repo.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada"));

        User manager = userRepository.findById(dto.getManagerId())
                .orElseThrow(() -> new ResourceNotFoundException("Manager no encontrado"));

        User instructor = userRepository.findById(dto.getInstructorId())
                .orElseThrow(() -> new ResourceNotFoundException("Instructor no encontrado"));

        Course entity = CourseDTO.toEntity(dto, category, manager, instructor);
        Course saved = courseRepository.save(entity);
        return CourseDTO.fromEntity(saved);
    }

    public CourseDTO update(Integer id, CourseDTO dto) {
        courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        CourseCategory category = repo.findById(dto.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada"));

        User manager = userRepository.findById(dto.getManagerId()).orElseThrow(() -> new ResourceNotFoundException("Manager no encontrado"));

        User instructor = userRepository.findById(dto.getInstructorId()).orElseThrow(() -> new ResourceNotFoundException("Instructor no encontrado"));

        Course entity = CourseDTO.toEntity(dto, category, manager, instructor);
        entity.setId(id);
        Course updated = courseRepository.save(entity);
        return CourseDTO.fromEntity(updated);
    }

    public void delete(Integer id) {
        courseRepository.delete(courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Categoría no encontrada")));
    }
    
}