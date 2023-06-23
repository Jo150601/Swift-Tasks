package com.java.cognizant.todolist.Repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.java.cognizant.todolist.Entities.Tasks_info;

@Repository
public interface TasksRepo extends JpaRepository<Tasks_info, Long> {
	
	
	
	@Query("Select t1 from Tasks_info t1 where t1.isdone = true")
	List<Tasks_info> findAllByIsDoneTrue();
	
	@Query("Select t1 from Tasks_info t1 where t1.isdone = false")
	List<Tasks_info> findAllByIsDoneFalse();

//	Optional<Tasks_info> findByTaskName(String task_name);

//	List<Tasks_info> findByTaskNameIn(String task_name);

//	List<Tasks_info> findByTaskNameIn(String task_name);


}
