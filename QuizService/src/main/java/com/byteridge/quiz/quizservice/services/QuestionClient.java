package com.byteridge.quiz.quizservice.services;

import com.byteridge.quiz.quizservice.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//for load balancing
@FeignClient(name = "QUESTION-SERVICE")
//@FeignClient(name = "QUESTION-SERVICE", url = "localhost:8082")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionOfQuiz(@PathVariable Long quizId);

}
