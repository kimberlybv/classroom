package com.edutech.classroom.service;

import com.edutech.classroom.Repository.CourseQuizQuestionRepository;
import com.edutech.classroom.Repository.CourseQuizRepository;
import com.edutech.classroom.dto.CourseQuizQuestionDTO;
import com.edutech.classroom.entity.CourseQuiz;
import com.edutech.classroom.entity.CourseQuizQuestion;
import com.edutech.classroom.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CourseQuizQuestionService {

    private final CourseQuizQuestionRepository courseQuizQuestionRepository;
    private final CourseQuizRepository courseQuizRepository;

    public List<CourseQuizQuestionDTO> findAll(){
        return courseQuizQuestionRepository.findAll().stream().map(CourseQuizQuestionDTO::fromEntity).toList();
    }

    public CourseQuizQuestionDTO findById(Integer id){
        return CourseQuizQuestionDTO.fromEntity(courseQuizQuestionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada")));
    }

    public CourseQuizQuestionDTO create(CourseQuizQuestionDTO dto) {
        CourseQuiz quiz = courseQuizRepository.findById(dto.getQuizId())
                .orElseThrow(() -> new ResourceNotFoundException("Quiz no encontrado"));

        CourseQuizQuestion entity = CourseQuizQuestionDTO.toEntity(dto, quiz);
        CourseQuizQuestion saved = courseQuizQuestionRepository.save(entity);
        return CourseQuizQuestionDTO.fromEntity(saved);
    }

    public CourseQuizQuestionDTO update(Integer id, CourseQuizQuestionDTO dto) {
        CourseQuiz quiz = courseQuizRepository.findById(dto.getQuizId())
                .orElseThrow(() -> new ResourceNotFoundException("Quiz no encontrado"));

        CourseQuizQuestion updated = CourseQuizQuestionDTO.toEntity(dto, quiz);
        updated.setId(id);

        CourseQuizQuestion saved = courseQuizQuestionRepository.save(updated);
        return CourseQuizQuestionDTO.fromEntity(saved);
    }

    public void delete(Integer id) {
        courseQuizQuestionRepository.delete(courseQuizQuestionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Categoría no encontrada")));
    }
}