package com.shubhs.quiz_service.Service;

import com.shubhs.quiz_service.DAO.QuizDao;
import com.shubhs.quiz_service.feign.QuizInterface;
import com.shubhs.quiz_service.model.QuestionWrapper;
import com.shubhs.quiz_service.model.Quiz;
import com.shubhs.quiz_service.model.Response;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer> questions = quizInterface.getQuestionForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
      Quiz quiz = quizDao.findById(id).get();

      List<Integer> questionsIds = quiz.getQuestionIds();

      ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionFromIds(questionsIds);
       return  questions;

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

       ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }
}


