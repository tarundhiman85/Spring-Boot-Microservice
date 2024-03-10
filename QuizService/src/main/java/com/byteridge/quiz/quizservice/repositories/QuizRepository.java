package com.byteridge.quiz.quizservice.repositories;

import com.byteridge.quiz.quizservice.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
