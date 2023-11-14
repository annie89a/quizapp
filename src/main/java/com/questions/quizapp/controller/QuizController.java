package com.questions.quizapp.controller;

import com.questions.quizapp.model.QuestionWrapper;
import com.questions.quizapp.model.Response;
import com.questions.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create") //test it with : http://localhost:8080/quiz/create?category=Ruby&numQ=5&title=Basics
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
    {
        //wrapper class; have al the column except answer
        return quizService.getQuizQuestionsByID(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses)
    {
        //calculate\
        return quizService.calculateResult(id,responses);
    }

}
