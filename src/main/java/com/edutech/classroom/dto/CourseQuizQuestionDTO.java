package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseQuiz;
import com.edutech.classroom.entity.CourseQuizQuestion;
import lombok.Data;
import java.time.Instant;

@Data
public class CourseQuizQuestionDTO {

    private Integer id;
    private Integer quizId;
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String optionE;
    private String correctAnswer;
    private String correctOption;
    private Integer orderIndex;
    private Instant createdAt;

    public static CourseQuizQuestionDTO fromEntity(CourseQuizQuestion entity) {
        CourseQuizQuestionDTO dto = new CourseQuizQuestionDTO();
        dto.setId(entity.getId());
        if (entity.getQuiz() != null) {
            dto.setQuizId(entity.getQuiz().getId());
        }
        dto.setQuestionText(entity.getQuestionText());
        dto.setOptionA(entity.getOptionA());
        dto.setOptionB(entity.getOptionB());
        dto.setOptionC(entity.getOptionC());
        dto.setOptionD(entity.getOptionD());
        dto.setOptionE(entity.getOptionE());
        dto.setCorrectAnswer(entity.getCorrectAnswer());
        dto.setCorrectOption(entity.getCorrectOption());
        dto.setOrderIndex(entity.getOrderIndex());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public static CourseQuizQuestion toEntity(CourseQuizQuestionDTO dto, CourseQuiz quiz) {
        CourseQuizQuestion entity = new CourseQuizQuestion();
        entity.setId(dto.getId());
        entity.setQuiz(quiz);
        entity.setQuestionText(dto.getQuestionText());
        entity.setOptionA(dto.getOptionA());
        entity.setOptionB(dto.getOptionB());
        entity.setOptionC(dto.getOptionC());
        entity.setOptionD(dto.getOptionD());
        entity.setOptionE(dto.getOptionE());
        entity.setCorrectAnswer(dto.getCorrectAnswer());
        entity.setCorrectOption(dto.getCorrectOption());
        entity.setOrderIndex(dto.getOrderIndex());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}