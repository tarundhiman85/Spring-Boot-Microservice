package com.byteridge.quiz.quizservice.services.impl;

import com.byteridge.quiz.quizservice.entities.Quiz;
import com.byteridge.quiz.quizservice.repositories.QuizRepository;
import com.byteridge.quiz.quizservice.services.QuestionClient;
import com.byteridge.quiz.quizservice.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

        private QuizRepository quizRepository;
        private QuestionClient questionClient;

        public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
            this.quizRepository = quizRepository;
            this.questionClient = questionClient;
        }

        @Override
        public Quiz add(Quiz quiz) {
            return quizRepository.save(quiz);
        }

        @Override
        public List<Quiz> get() {
            List<Quiz> quizzes = quizRepository.findAll();
            //Getting question from different microservice
            List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
                quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
                return quiz;
            }).collect(Collectors.toList());

            return newQuizList;
        }

        @Override
        public Quiz get(Long id) {
            Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }
    }
