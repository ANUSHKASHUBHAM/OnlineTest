package com.capgemini.onlinetestmanagementsystem.serviceImpl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.OnlineTestManagementSystem.dao.IQuestionDao;
import com.capgemini.OnlineTestManagementSystem.entity.Question;
import com.capgemini.OnlineTestManagementSystem.exception.ResourceNotFoundException;


@Service
public class QuestionServiceImpl implements IQuestionService
{

	@Autowired
	IQuestionDao questionDao;
	@Override
	public Question createQuestion(Question question)
	{
		return questionDao.save(question);
	}

	@Override
	public List<Question> getAllQuestion() 
	{
		return questionDao.findAll();
	}

	@Override
	 public void deleteQuestion(int serialNo)
	{
		
		Optional<Question> questionDb =questionDao.findById(serialNo);

	        if (questionDb.isPresent())
	        {
	        	this.questionDao.delete(questionDb.get());
	        }
	            
	        else
	             {
	              throw new ResourceNotFoundException("Record not found with id : " + serialNo);
	            }
	}
	@Override
	public Question getQuestionBySno(int serialNo)
	{
	 Optional < Question > questionDb = this.questionDao.findById(serialNo);
	 if (questionDb.isPresent())
		{
     return questionDb.get();
		}
	 throw new ResourceNotFoundException("Record not found with id : " +serialNo );
    }
	@Override
	public Question save(Question question)
	{
		return questionDao.save(question);
	}


	@Override
	public Question updateQuestion(Question question) 
	{
		 Optional < Question > questionDb = this.questionDao.findById(question.getSerialNo());
	if (questionDb.isPresent())
	{
        Question questionUpdate = questionDb.get();
        questionUpdate.setQuestionValue(question.getQuestionDomain());
        questionUpdate.setQuestionMarks(question.getQuestionMarks());
        questionUpdate.setQuestionDomain(question.getQuestionValue());
        questionUpdate.setCorrectOption(question.getCorrectOption());
        questionUpdate.setOption1(question.getOption1());
        questionUpdate.setOption2(question.getOption2());
        questionUpdate.setOption3(question.getOption3());
        questionUpdate.setOption4(question.getOption4());
        return questionUpdate;
	}
	  throw new ResourceNotFoundException("Record not found with id : " + question.getSerialNo());

	}
	    
}
