package com.java.cognizant.todolist.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.cognizant.todolist.Entities.*;
@Repository
public interface UserRepo extends JpaRepository<User_info, String> 
{

	

	
            
}

