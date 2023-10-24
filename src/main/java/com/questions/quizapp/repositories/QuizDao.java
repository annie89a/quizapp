package com.questions.quizapp.repositories;

import com.questions.quizapp.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> { //type of table and type of quiz

}
