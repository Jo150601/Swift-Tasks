package com.java.cognizant.todolist.Functions;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.java.cognizant.todolist.Entities.Tasks_info;
import com.java.cognizant.todolist.Entities.User_info;
import com.java.cognizant.todolist.Repos.*;
import com.java.cognizant.todolist.Services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
    private AdminRepo adminRepo;
	@Autowired
    private UserRepo userRepo;
	@Autowired
     private TasksRepo tasksRepo;
     
	@Override
	public List<Tasks_info> getAllTasksByUserId(String user_id) {
	    List<Tasks_info> allTasks = tasksRepo.findAll();
	    List<Tasks_info> tasks = new ArrayList<>();

	    for (Tasks_info i : allTasks) {
	        if (i.getUser_id().getUser_id().equals(user_id)) {
	            tasks.add(i);
	        }
	    }

	    return tasks;
	}





	@Override
	public Tasks_info addTasks(Tasks_info task) {
		return tasksRepo.save(task);
	}



//	@Override
//	public Tasks_info updateTasks(Tasks_info tasks) {
//		// Retrieve the Tasks entity from the database
//		
//		        
//       // If the Tasks entity exists, update its properties and save it to the database
//       if (tasksRepo.existsById(tasks.getTask_id())) {
//       
//               
//       // Update the properties of the existing Tasks entity
//       tasks.setTask_id(tasks.getTask_id());
//       tasks.setTask_name(tasks.getTask_name());
//       tasks.setTask_start_date(tasks.getTask_start_date());
//       tasks.setTask_end_date(tasks.getTask_end_date());
//       tasks.setTask_category(tasks.getTask_category());
//       // Set other properties as needed          
//      // Save the updated Tasks entity to the database
//	   Tasks_info savedTasksEntity = tasksRepo.save(tasks);	            
//	   // Create a new Tasks_info object from the saved Tasks entity
//       Tasks_info savedTasks = new Tasks_info();
//       savedTasks.setTask_id(savedTasksEntity.getTask_id());
//       savedTasks.setTask_name(savedTasksEntity.getTask_name());
//       savedTasks.setTask_start_date(savedTasksEntity.getTask_start_date());
//       savedTasks.setTask_end_date(savedTasksEntity.getTask_end_date());
//       savedTasks.setTask_category(savedTasksEntity.getTask_category());
//       
//	   return savedTasks;
//	  }
//		return null;
// }
	
//	@Override
//	public Tasks_info updateTasks(Tasks_info tasks) {
//	    if (tasksRepo.existsById(tasks.getTask_id())) {
//	        Tasks_info savedTask = tasksRepo.save(tasks);
//	        return savedTask;
//	    }
//	    return null;
//	}
	
	public Tasks_info updateTask(Long taskId, Tasks_info updatedTask) {
        Optional<Tasks_info> existingTaskOptional = tasksRepo.findById(taskId);
        if (existingTaskOptional.isPresent()) {
            Tasks_info existingTask = existingTaskOptional.get();
            existingTask.setTask_name(updatedTask.getTask_name());
            existingTask.setTask_start_date(updatedTask.getTask_start_date());
            existingTask.setTask_end_date(updatedTask.getTask_end_date());
            existingTask.setTask_category(updatedTask.getTask_category());
            existingTask.setIsdone(updatedTask.getIsdone());
            Tasks_info savedTask = tasksRepo.save(existingTask);
            return savedTask;
        }
        return null;
    }
	
	public void deleteTask(Long taskId) {
	    Optional<Tasks_info> taskOptional = tasksRepo.findById(taskId);
	    if (taskOptional.isPresent()) {
	        Tasks_info task = taskOptional.get();
	        tasksRepo.delete(task);
	        System.out.println("Task with ID " + taskId + " deleted successfully.");
	    } else {
	        System.out.println("Task with ID " + taskId + " not found.");
	    }
	}





//	public void deleteTasks(Long task_id) {
//	    Optional<Tasks_info> taskOptional = tasksRepo.findById(task_id);
//	    if (taskOptional.isPresent()) {
//	        Tasks_info task = taskOptional.get();
//	        tasksRepo.delete(task);
//	        System.out.println("Task with ID " + task_id + " deleted successfully.");
//	    } else {
//	        System.out.println("Task with ID " + task_id + " not found.");
//	    }
//	}
//	@Override
//	public void deleteTask(String task_name) {
//	    List<Tasks_info> tasks = tasksRepo.findByTaskNameIn(task_name);
//	    if (!tasks.isEmpty()) {
//	        tasksRepo.deleteAll(tasks);
//	        System.out.println("Tasks with name '" + task_name + "' deleted successfully.");
//	    } else {
//	        System.out.println("No tasks found with name '" + task_name + "'.");
//	    }
//	}









	@Override
	public List<Tasks_info> findTasksByName(String task_name) {        
	    List<Tasks_info> tasks = tasksRepo.findAll().stream()
	            .filter(k -> k.getTask_name().equalsIgnoreCase(task_name))
	            .collect(Collectors.toList());

	    return tasks;
	}




	@Override
	public List<Tasks_info> getAllFinishedTasks(String userId) {
		 return tasksRepo.findAllByIsDoneTrue();
	}



	@Override
	public List<Tasks_info> getAllNotFinishedTasks(String userId) {
		 return tasksRepo.findAllByIsDoneFalse();
	}



	@Override
	public Tasks_info doneTask(Long task_id) {
		Tasks_info t = tasksRepo.findById(task_id).get();
		 t.setIsdone(!t.getIsdone());
		return tasksRepo.save(t);
		
	}



	@Override
	public List<Tasks_info> getTasksSortedByDueDate(String task_end_date) {
	    List<Tasks_info> tasks = tasksRepo.findAll(); // Retrieve the tasks from the repository or data source

	    Collections.sort(tasks, new Comparator<Tasks_info>() {
	        @Override
	        public int compare(Tasks_info task1, Tasks_info task2) {
	            return task1.getTask_end_date().compareTo(task2.getTask_end_date());
	        }
	    });

	    return tasks;
	}





//	@Override
//	public Tasks_info updateTasks(Tasks_info tasks) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	  
 
    
    
    
	/*@Override
	public List<Train_info> searchTrains(String destination) 
	{
	        List<Train_info> trains = new ArrayList<Train_info>();
	        
	        List<Train_info> Obj = trainRepo.findAll();
			Obj.forEach(k -> {
				if (k.getDestination().equalsIgnoreCase(destination)) {
					trains.add(k);
				}
			});
			return trains;
		//return trainRepo.findByDestination(destination);
	        
	}
	@Override
	public int getAvailableSeats(String classType) {
	    int total = 0;
	    int booked = 0;
	    int availableseats = 0;

	    if (classType.equalsIgnoreCase("first")) {
	        total = traininfo.getFirst_seat_availability();
	        booked = traininfo.getFirstbookedtickets();
	    } else if (classType.equalsIgnoreCase("second")) {
	        total = traininfo.getSecond_seat_availability();
	        booked = traininfo.getSecondbookedtickets();
	    } else if (classType.equalsIgnoreCase("third")) {
	        total = traininfo.getThird_class_seat();
	        booked = traininfo.getThirdbookedtickets();
	    } else if (classType.equalsIgnoreCase("fourth")) {
	        total = traininfo.getFourth_class_seat();
	        booked = traininfo.getFourthbookedtickets();
	    }

	    return availableseats =  total - booked;
	}*/

	/*@Override
	public void cancelTicket(String ticket_Id) 
	{
	   reserRepo.deleteById(ticket_Id);
	}
	
	
	
	@Override
	public void bookTicket(Reservation_info reser, String source, String destination, String trainDate, String classType, int num_seats_booked) throws Exception {
	    Train_info train = null;
	    List<Train_info> trainList = new ArrayList<>();
	    for (Train_info t : trainList) {
	        if (t.getSource().equalsIgnoreCase(source) && t.getDestination().equalsIgnoreCase(destination)) {
	            train = t;
	            break;
	        }
	    }
	    if (train == null) {
	        throw new Exception("No train found for the given source, destination, and date.");
	    }

	    int availableSeats = 0;
	    if (classType.equalsIgnoreCase("first")) {
	        availableSeats = train.getFirst_seat_availability() - train.getFirstbookedtickets();
	    } else if (classType.equalsIgnoreCase("second")) {
	        availableSeats = train.getSecond_seat_availability() - train.getSecondbookedtickets();
	    } else if (classType.equalsIgnoreCase("third")) {
	        availableSeats = train.getThird_class_seat() - train.getThirdbookedtickets();
	    } else if (classType.equalsIgnoreCase("fourth")) {
	        availableSeats = train.getFourth_class_seat() - train.getFourthbookedtickets();
	    } else {
	        throw new Exception("Invalid class type.");
	    }

	    if (availableSeats < num_seats_booked) {
	        throw new Exception("Not enough available seats for the chosen class type.");
	    }

	    reser.setTrain_id(train.getTrain_id());
	    reser.setClassType(classType);
	    reser.setNum_seats_booked(num_seats_booked);

	    // Update train's booked tickets count
	    if (classType.equalsIgnoreCase("first")) {
	        train.setFirstbookedtickets(train.getFirstbookedtickets() + num_seats_booked);
	    } else if (classType.equalsIgnoreCase("second")) {
	        train.setSecondbookedtickets(train.getSecondbookedtickets() + num_seats_booked);
	    } else if (classType.equalsIgnoreCase("third")) {
	        train.setThirdbookedtickets(train.getThirdbookedtickets() + num_seats_booked);
	    } else if (classType.equalsIgnoreCase("fourth")) {
	        train.setFourthbookedtickets(train.getFourthbookedtickets() + num_seats_booked);
	    }

	    // Add reservation to the list
	    reserRepo.save(reser);
	}

	@Override
	public List<Train_info> viewAllTrains() {
		 List<Train_info> trains = trainRepo.findAll();
	     return trains;
	
	}
	
	 @Override
	  public List<Reservation_info> viewMyBooking(String user_id) {
		  List<Reservation_info> reservations = new ArrayList<>();
		    List<Reservation_info> allReservations = reserRepo.findAll();
		    for (Reservation_info reservation : allReservations) {
		      if (reservation.getUser_id().equals(user_id)) {
		        reservations.add(reservation);
		      }
		    }
		    return reservations;
	  }*/

}