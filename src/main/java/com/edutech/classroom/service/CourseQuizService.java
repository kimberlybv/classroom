package com.edutech.classroom.service;

import com.edutech.classroom.Repository.CourseQuizRepository;
import com.edutech.classroom.Repository.CourseRepository;
import com.edutech.classroom.dto.CourseQuizDTO;
import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseQuiz;
import com.edutech.classroom.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CourseQuizService {
    
    private final CourseQuizRepository courseQuizRepository;
    private final CourseRepository courseRepository;

    public List<CourseQuizDTO> findAll(){
        return courseQuizRepository.findAll().stream().map(CourseQuizDTO::fromEntity).toList();
    }

    public CourseQuizDTO findById(Integer id){
        return CourseQuizDTO.fromEntity(courseQuizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada")));
    }

    public CourseQuizDTO create(CourseQuizDTO dto) {
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        CourseQuiz quiz = CourseQuizDTO.toEntity(dto, course);
        CourseQuiz saved = courseQuizRepository.save(quiz);
        return CourseQuizDTO.fromEntity(saved);
    }

    public CourseQuizDTO update(Integer id, CourseQuizDTO dto) {
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        CourseQuiz updated = CourseQuizDTO.toEntity(dto, course);
        updated.setId(id);

        CourseQuiz saved;
        saved = courseQuizRepository.save(updated);
        return CourseQuizDTO.fromEntity(saved);
    }

    public void delete(Integer id) {
        courseQuizRepository.delete(courseQuizRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Quiz no encontrado")));
    }
}