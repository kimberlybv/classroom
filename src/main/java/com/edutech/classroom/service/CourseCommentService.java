package com.edutech.classroom.service;

import com.edutech.classroom.Repository.CourseCommentRepository;
import com.edutech.classroom.Repository.CourseRepository;
import com.edutech.classroom.Repository.UserRepository;
import com.edutech.classroom.dto.CourseCommentDTO;
import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseComment;
import com.edutech.classroom.entity.User;
import com.edutech.classroom.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CourseCommentService {

    private final CourseCommentRepository repo;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public List<CourseCommentDTO> findAll(){
        return repo.findAll().stream().map(CourseCommentDTO::fromEntity).toList();
    }

    public CourseCommentDTO findById(Integer id){
        return CourseCommentDTO.fromEntity(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada")));
    }

    public CourseCommentDTO create(CourseCommentDTO dto) {
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        CourseComment comment = CourseCommentDTO.toEntity(dto, course, user);
        return CourseCommentDTO.fromEntity(repo.save(comment));
    }

    public CourseCommentDTO update(Integer id, CourseCommentDTO dto) {

        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        CourseComment entity = CourseCommentDTO.toEntity(dto, course, user);
        entity.setId(id);
        return CourseCommentDTO.fromEntity(repo.save(entity));
    }

    public void delete(Integer id) {
        repo.delete(repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Categoría no encontrada")));
    }
}