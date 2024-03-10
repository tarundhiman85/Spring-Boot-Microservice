package com.byteridge.question.questionservice.services;

import com.byteridge.question.questionservice.entities.Question;

import java.util.List;

public interface QuestionService {

    Question create(Question question);
    List<Question> get();
    Question getOne(Long id);
    List<Question> getQuestionsOfQuiz(Long quizId);
}