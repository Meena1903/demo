package com.example.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quiz.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

    List<Question> findByCategory(String catagory);
}
