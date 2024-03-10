package com.byteridge.quiz.quizservice.services;

import com.byteridge.quiz.quizservice.entities.Quiz;

import java.util.List;

public interface QuizService {
    Quiz add(Quiz quiz);

    List<Quiz> get();

    Quiz get(Long id);
}
