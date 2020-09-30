package com.capgemini.onlinetestmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.capgemini.OnlineTestManagementSystem.entity.Question;


@Service
public interface IQuestionService 
{
	public Question createQuestion(Question question);
    public List<Question> getAllQuestion();
    public void deleteQuestion(int Sno);
	public Question save(Question question);
    public Question getQuestionBySno(int Sno);
    public Question updateQuestion(Question question);

}
