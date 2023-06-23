package com.java.cognizant.todolist.Services;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import com.java.cognizant.todolist.Entities.*;


public interface UserService {
	
	public List<Tasks_info> getAllTasksByUserId(String user_id) ;
	
	public Tasks_info addTasks(Tasks_info task);
	
//	public Tasks_info updateTasks(Tasks_info tasks);
	
	public void deleteTask(Long taskId);
	
	List<Tasks_info> findTasksByName(String task_name);
	
	List<Tasks_info> getAllFinishedTasks(String user_id);
	
	List<Tasks_info> getAllNotFinishedTasks(String user_id);
	
	public Tasks_info doneTask(Long task_id);
	
	public List<Tasks_info> getTasksSortedByDueDate(String task_end_date);

	public Tasks_info updateTask(Long taskId, Tasks_info updatedTask);
	
	
	
 
  
    

}