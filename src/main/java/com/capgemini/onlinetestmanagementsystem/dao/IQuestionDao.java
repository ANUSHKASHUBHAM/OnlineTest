package com.capgemini.onlinetestmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.OnlineTestManagementSystem.entity.Question;


public interface IQuestionDao extends JpaRepository<Question,Integer>
{

}
