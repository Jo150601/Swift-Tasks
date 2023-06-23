package com.java.cognizant.todolist.Services;

import java.util.List;

import com.java.cognizant.todolist.Entities.*;

import Exceptions.UserEmailNotFoundException;
import Exceptions.UserIdNotFoundException;
import Exceptions.UserNameNotFoundException;
import Exceptions.UserPhoneNoNotFoundException;

public interface AdminService {
    
    
	public User_info addUser(User_info user);
	
	public List<User_info> getAllUsers();
	
	public void deleteUser(String user_id) throws UserIdNotFoundException;
    
	public User_info updateUser(String user_id, User_info user);
    
	public User_info getUserById(String user_id) throws UserIdNotFoundException;
	
	public Admin_info getAdminById(String admin_id) throws UserIdNotFoundException;
    
	public List<User_info> getUserByName(String user_name) throws UserNameNotFoundException;
    
	public List<User_info> getUserByEmail(String user_email) throws UserEmailNotFoundException;
    
	public List<User_info> findByPhoneno(long user_phoneno) throws UserPhoneNoNotFoundException ;
       
	public Admin_info addAdmin(Admin_info admin);
	
	public void deleteAdmin(String admin_id);
	
	public Admin_info updateAdmin(String admin_id, Admin_info admin);
	
	public List<Admin_info> getAllAdmin();
    
    	
}
