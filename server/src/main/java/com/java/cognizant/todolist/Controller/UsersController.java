package com.java.cognizant.todolist.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.cognizant.todolist.Entities.Tasks_info;
import com.java.cognizant.todolist.Services.UserService;


@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UsersController {
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private UserService userService;

    
//    @RestController
////    @RequestMapping("/tasks")
//    public class TasksController
//    {   
    	
    	
    	@GetMapping("/alltasks/{user_id}")
    	public ResponseEntity<List<Tasks_info>> getAllTasksByUserId(@PathVariable String user_id) {
    	    try {
    	        List<Tasks_info> tasks = userService.getAllTasksByUserId(user_id);
    	        if (!tasks.isEmpty()) {
    	            return ResponseEntity.ok(tasks);
    	        } else {
    	            return ResponseEntity.noContent().build();
    	        }
    	    } catch (Exception e) {
    	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	    }
    	}
    	
    	@PostMapping("/addtask")
    	public ResponseEntity<Tasks_info> addTask(@RequestBody Tasks_info task){
    		System.out.println(task);
    		try {
    			userService.addTasks(task);
    			return ResponseEntity.status(HttpStatus.CREATED).body(task);
    		}catch (Exception e){
    			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    		}
    	}


//    @PostMapping("/addTask")
//    public void addTasks(@RequestBody Tasks_info task) {
//        userService.addTasks(task);
//        
//    }
    
//    @PostMapping("/updateTask")
//    public ResponseEntity<?> updateTasks(@RequestBody Tasks_info task) {
//        try {
//            Tasks_info update = userService.updateTasks(task);
//            logger.debug("Task updated successfully! : {}",update);
//           return ResponseEntity.ok(update);
//            
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
    	
//    	@PostMapping("/updateTask")
//    	public ResponseEntity<?> updateTasks(@RequestBody Tasks_info task) {
//    	    try {
//    	        Tasks_info updatedTask = userService.updateTasks(task);
//    	        if (updatedTask != null) {
//    	            logger.debug("Task updated successfully: {}", updatedTask);
//    	            return ResponseEntity.ok(updatedTask);
//    	        } else {
//    	            return ResponseEntity.notFound().build();
//    	        }
//    	    } catch (Exception e) {
//    	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//    	    }
//    	}
    	
    	 @PutMapping("/updatetasks/{taskId}")
    	    public ResponseEntity<?> updateTask(@PathVariable Long taskId, @RequestBody Tasks_info updatedTask) {
    	        try {
    	            Tasks_info task = userService.updateTask(taskId, updatedTask);
    	            if (task != null) {
    	                return ResponseEntity.ok(task);
    	            } else {
    	                return ResponseEntity.notFound().build();
    	            }
    	        } catch (Exception e) {
    	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    	        }
    	    }
    	 
    	 @DeleteMapping("/deleteTask/{taskId}")
    	 public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {
    	     try {
    	         userService.deleteTask(taskId);
    	         logger.debug("Task with ID {} deleted successfully!", taskId);
    	         return ResponseEntity.ok().build();
    	     } catch (Exception e) {
    	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    	     }
    	 }

    
//    @PostMapping("/deleteTask")
//    public void deleteTasks(@RequestBody Long task_id){
//    	logger.debug("Task deleted successfully!");
//        userService.deleteTasks(task_id);
//    }

    
    @GetMapping("/findtasksbyname/{taskname}")
    public ResponseEntity<?> findTasksByName(@PathVariable("taskname") String task_name) {
        try {
            List<Tasks_info> tasks = userService.findTasksByName(task_name);
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    
    @GetMapping("/getfinishedtasks/{user_id}")
    public ResponseEntity<?> getAllFinishedTasks(@PathVariable("user_id") String userId) {
        try {
            List<Tasks_info> finishedtasks = userService.getAllFinishedTasks(userId);
            return ResponseEntity.ok(finishedtasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/getnotfinishedtasks/{user_id}")
    public ResponseEntity<?> getAllNotFinishedTasks(@PathVariable("user_id") String userId) {
        try {
            List<Tasks_info> notfinishedtasks = userService.getAllNotFinishedTasks(userId);
            return ResponseEntity.ok(notfinishedtasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/gettasksortedbyduedate/{user_id}")
    public ResponseEntity<?> getTasksSortedByDueDate(@PathVariable("user_id") String userId) {
        try {
            List<Tasks_info> sort = userService.getTasksSortedByDueDate(userId);
            return ResponseEntity.ok(sort);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    
    @PostMapping("/doneTask/{task_id}")
    public ResponseEntity<?> doneTask(@PathVariable("task_id") Long task_id) {
        try {
            userService.doneTask(task_id);
            return ResponseEntity.ok("Task with ID " + task_id + " marked as done.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to mark task as done.");
        }
    }
    
    }

   
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
