package com.java.cognizant.todolist.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.java.cognizant.todolist.Entities.Admin_info;
import com.java.cognizant.todolist.Entities.User_info;
import com.java.cognizant.todolist.Services.AdminService;
import Exceptions.UserEmailNotFoundException;
import Exceptions.UserIdNotFoundException;
import Exceptions.UserNameNotFoundException;
import Exceptions.UserPhoneNoNotFoundException;

@CrossOrigin("http://localhost:3000")
@RestController
	@RequestMapping("/admin")
	public class AdminController {
	
		Logger logger = LoggerFactory.getLogger(AdminController.class);

	    @Autowired
	    public AdminService adminService;
	  
	    
	    @PostMapping("/addUser")
	    public User_info addUser(@RequestBody User_info user){
	    	logger.debug("Successfully added the user");
			return adminService.addUser(user);	    	
	    }
	    
	    @PostMapping("/addAdmin")
	    public Admin_info addAdmin(@RequestBody Admin_info admin) {
	        return adminService.addAdmin(admin);
	    }
	    
	    @GetMapping("/viewallusers")
	    public List<User_info> getAllUsers() {
	        return adminService.getAllUsers();
	    }
	    
	    @GetMapping("/viewalladmin")
	    public List<Admin_info> getAllAdmin() {
	        return adminService.getAllAdmin();
	    }
	    
	    @DeleteMapping("/deleteUser/{user_id}")
	    public void deleteUser(@PathVariable String user_id) throws UserIdNotFoundException{
	    	logger.debug("Successfully deleted the user");
	    	adminService.deleteUser(user_id);	    	
	    }
	    
	    @DeleteMapping("/delete/{admin_id}")
	    public ResponseEntity<String> deleteAdmin(@PathVariable("admin_id") String adminId) {
	        adminService.deleteAdmin(adminId);
	        return ResponseEntity.ok("Admin deleted successfully");
	    }
	    
	    @PostMapping("/updateUser/{user_id}")
	    public ResponseEntity<?> updateUser(@PathVariable("user_id") String user_id, @RequestBody User_info user) {
	        try {
	            User_info updatedUser = adminService.updateUser(user_id, user);
	            if (updatedUser != null) {
	                return ResponseEntity.ok(updatedUser);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }
	    }
	    
	    @PostMapping("/update/{admin_id}")
	    public ResponseEntity<Admin_info> updateAdmin(@PathVariable("admin_id") String admin_id, @RequestBody Admin_info admin) {
	        Admin_info updatedAdmin = adminService.updateAdmin(admin_id, admin);
	        if (updatedAdmin != null) {
	            return ResponseEntity.ok(updatedAdmin);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }	    
	    
	    @GetMapping("/getAdminById/{admin_id}")
	    public ResponseEntity<Admin_info> getAdminById(@PathVariable("admin_id") String admin_id) {
	        try {
	            Admin_info admin = adminService.getAdminById(admin_id);
	            return ResponseEntity.ok(admin);
	        } catch (UserIdNotFoundException e) {
	            // Handle the exception, e.g., return an error response
	            return ResponseEntity.notFound().build();
	        }
	    }

	    
	    @GetMapping("/getUserById/{user_id}")
	    public User_info getUserById(@PathVariable ("user_id") String user_id) throws UserIdNotFoundException{
			return adminService.getUserById(user_id);
	    }
	    
	    @GetMapping("/getUserByName/{user_name}")
	    public List<User_info> getUserByName(@PathVariable ("user_name")String user_name) throws UserNameNotFoundException {
	    	return adminService.getUserByName(user_name);
	    }
	    
	    @GetMapping("/getUserByEmail/{user_email}")
	    public List<User_info> getUserByEmail(@PathVariable ("user_email")String user_email) throws UserEmailNotFoundException{
			return adminService.getUserByEmail(user_email);	    	
	    }
	    
	    @GetMapping("/getUserByPhoneNo/{user_phoneno}")
	    public List<User_info> findByPhoneno(@PathVariable ("user_phoneno") Long user_phoneno) throws UserPhoneNoNotFoundException  {
	    	return adminService.findByPhoneno(user_phoneno);	
	    }
}