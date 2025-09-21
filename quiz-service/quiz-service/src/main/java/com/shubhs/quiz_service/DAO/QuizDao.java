package com.shubhs.quiz_service.DAO;


import com.shubhs.quiz_service.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {


}
