package com.capgemini.onlinetestmanagementsystem.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.OnlineTestManagementSystem.entity.Question;
import com.capgemini.OnlineTestManagementSystem.exception.ResourceNotFoundException;
import com.capgemini.OnlineTestManagementSystem.service.IQuestionService;

@RestController
@RequestMapping(value="/Questions")


public class QuestionController
{
	@Autowired
	private IQuestionService questionService;

	@GetMapping("/question")
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestion();
	}

	@GetMapping("/question/{serialNo}")
	public ResponseEntity<Question> getQuestionById(@PathVariable int serialNo)
	{
		return ResponseEntity.ok().body(questionService.getQuestionBySno(serialNo));
	}

    @PostMapping(path="/addQuestion" ,consumes="application/json",produces="application/json")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question )
    {
        return ResponseEntity.ok().body(this.questionService.createQuestion(question));
    }
	@PutMapping("/updateQuestion/{serialNo}")
	public ResponseEntity<Question> updateQuestion(@PathVariable(value = "serialNo") int serialNo, @RequestBody Question question)
	{     
		question.setSerialNo(serialNo);
        return ResponseEntity.ok().body(this.questionService.updateQuestion(question));
    }
	
	
	@DeleteMapping("/deleteQuestion/{serialNo}")
    public String deleteQuestion(@PathVariable int serialNo)
	{
        this.questionService.deleteQuestion(serialNo);
        return "Question details deleted successfully";
    }

}
