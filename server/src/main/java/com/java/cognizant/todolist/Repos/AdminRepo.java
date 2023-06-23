package com.java.cognizant.todolist.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.java.cognizant.todolist.Entities.*;

@Repository
public interface AdminRepo extends JpaRepository<Admin_info, String> {

}