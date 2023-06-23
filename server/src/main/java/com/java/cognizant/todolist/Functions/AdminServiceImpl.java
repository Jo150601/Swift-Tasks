package com.java.cognizant.todolist.Functions;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.cognizant.todolist.Entities.Admin_info;
import com.java.cognizant.todolist.Entities.User_info;
import com.java.cognizant.todolist.Repos.AdminRepo;
import com.java.cognizant.todolist.Repos.TasksRepo;
import com.java.cognizant.todolist.Repos.UserRepo;
import com.java.cognizant.todolist.Services.AdminService;
import Exceptions.UserEmailNotFoundException;
import Exceptions.UserIdNotFoundException;
import Exceptions.UserNameNotFoundException;
import Exceptions.UserPhoneNoNotFoundException;


@Service
public class AdminServiceImpl implements AdminService{
	
     @Autowired
       private AdminRepo adminRepo;
     @Autowired
       private UserRepo userRepo;
     
     
	@Override
	public User_info addUser(User_info user) {
		if(user.getUser_id()!= null || user.getUser_name()!= null || user.getUser_email()!= null || user.getUser_phoneno()!=0) {
			return userRepo.save(user);
		}
		else {
			return null;
		}
	}
	
	@Override
    public List<User_info> getAllUsers() {
        return userRepo.findAll();
    }
    
    @Override
    public List<Admin_info> getAllAdmin() {
        return adminRepo.findAll();
    }
	
	@Override
	public void deleteUser(String user_id) throws UserIdNotFoundException {
		if(userRepo.existsById(user_id)) {
			userRepo.deleteById(user_id);
		}
		else {
			throw new UserIdNotFoundException("ID is not valid");
		}
        
	}
	
	@Override
	public User_info updateUser(String user_id, User_info user) {
	    Optional<User_info> optionalUser = userRepo.findById(user_id);
	    if (optionalUser.isPresent()) {
	        User_info existingUser = optionalUser.get();
	        existingUser.setUser_id(user.getUser_id());
	        existingUser.setUser_name(user.getUser_name());
	        existingUser.setUser_email(user.getUser_email());
	        existingUser.setUser_phoneno(user.getUser_phoneno());
	        User_info updatedUser = userRepo.save(existingUser);
	        return updatedUser;
	    }
	    return null;
	}
	
	@Override
	public Admin_info getAdminById(String admin_id) {
	    return adminRepo.findById(admin_id).orElse(null);
	}



	@Override
	public User_info getUserById(String user_id) throws UserIdNotFoundException{
		if(userRepo.existsById(user_id)) {
			User_info uid = userRepo.findById(user_id).get();
			return uid;
		}
		else {
			throw new UserIdNotFoundException("ID not found");
		}
	}
	@Override
	public List<User_info> getUserByName(String user_name) throws UserNameNotFoundException{
		if(userRepo!=null){
			List<User_info> uname = userRepo.findAll();
			List<User_info> result = new ArrayList<>();
			
			uname.forEach(k->{
				if(k.getUser_name().equalsIgnoreCase(user_name)) {
					result.add(k);
				}
			});
			return result;
		}
		else {
			throw new UserNameNotFoundException();
		}
		
	}
	@Override
	public List<User_info> getUserByEmail(String user_email) throws UserEmailNotFoundException {
		if(userRepo!=null) {
			List<User_info> uemail = userRepo.findAll();
			List<User_info> resultemail = new ArrayList<>();
			
			uemail.forEach(k->{
				if(k.getUser_email().equalsIgnoreCase(user_email)) {
					resultemail.add(k);
				}
			});
			return resultemail;
		}
		else {
			throw new UserEmailNotFoundException();
		}
		
	}
	
	
	
	@Override
	public List<User_info> findByPhoneno(long user_phoneno) throws UserPhoneNoNotFoundException {
		if(userRepo!= null) {
			List<User_info> uphone = userRepo.findAll();
			List<User_info> resultphone = new ArrayList<>();
			
			uphone.forEach(k->{
				if(k.getUser_phoneno()==(user_phoneno)) {
					resultphone.add(k);
				}
			});
			return resultphone;
		}
		else {
			throw new UserPhoneNoNotFoundException();
		}

	}

	@Override
	public Admin_info addAdmin(Admin_info admin) {
		if (admin.getAdmin_id() != null && admin.getAdmin_name() != null && admin.getAdmin_email() != null && admin.getAdmin_phoneno() != 0) {
	        return adminRepo.save(admin);
	    } else {
	        return null;
	    }
	}

	@Override
	public void deleteAdmin(String admin_id) {
		if (adminRepo.existsById(admin_id)) {
	        adminRepo.deleteById(admin_id);
	    } else {
	    } 
	}

	@Override
	public Admin_info updateAdmin(String admin_id, Admin_info admin) {
		Optional<Admin_info> optionalAdmin = adminRepo.findById(admin_id);
	    if (optionalAdmin.isPresent()) {
	        Admin_info existingAdmin = optionalAdmin.get();
	        existingAdmin.setAdmin_id(admin.getAdmin_id());
	        existingAdmin.setAdmin_name(admin.getAdmin_name());
	        existingAdmin.setAdmin_email(admin.getAdmin_email());
	        existingAdmin.setAdmin_phoneno(admin.getAdmin_phoneno());
	        Admin_info updatedAdmin = adminRepo.save(existingAdmin);
	        return updatedAdmin;
	    }
	    return null;
	}
}

