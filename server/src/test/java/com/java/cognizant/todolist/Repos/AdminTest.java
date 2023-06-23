package com.java.cognizant.todolist.Repos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.java.cognizant.todolist.Entities.User_info;
import com.java.cognizant.todolist.Functions.AdminServiceImpl;

import Exceptions.UserEmailNotFoundException;
import Exceptions.UserIdNotFoundException;
import Exceptions.UserNameNotFoundException;
import Exceptions.UserPhoneNoNotFoundException; 


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AdminTest {
	
	@Mock
	private AdminRepo adminRepo;
	
	@Mock
	private UserRepo userRepo;
	
	@InjectMocks
	private AdminServiceImpl adminService;
	
	
	@Test
    public void addUserTest() {
        User_info user1 = new User_info("jo123", "Johina", "johina@gmail.com", 9841715549L);
        User_info user2 = new User_info("jace123", "Jason", "jason@gmail.com", 9940260012L);
        User_info user3 = new User_info("aishu123", "Aishu", "aishu@gmail.com", 8056391238L);

        List<User_info> users = Arrays.asList(user1, user2, user3);

        for (User_info user : users) {
            adminService.addUser(user);
            verify(userRepo, times(1)).save(user);
        }
    }
	
	@Test
    public void deleteUserTest() throws UserIdNotFoundException {
        when(userRepo.existsById("jo123")).thenReturn(true);
        adminService.deleteUser("jo123");
        verify(userRepo, times(1)).deleteById("jo123");
    }

    @Test
    public void deleteUserNotFoundTest() {
        when(userRepo.existsById("jo123")).thenReturn(false);
        Assertions.assertThrows(UserIdNotFoundException.class, () -> {
            adminService.deleteUser("jo123");
        });
        verify(userRepo, never()).deleteById(toString());
    }
    
    @Test
    public void updateUserTest() {
        User_info existingUser = new User_info("jace123", "Jason", "jason@gmail.com", 9940260012L);
        User_info updatedUser = new User_info("jason12", "Jason Chris Zion", "jasoncz@gmail.com", 9940260012L);
        when(userRepo.findById("jason12")).thenReturn(Optional.of(existingUser));
        when(userRepo.save(any(User_info.class))).thenReturn(updatedUser);
        User_info result = adminService.updateUser("jason12", updatedUser);
        verify(userRepo, times(1)).findById("jason12");
        Assertions.assertEquals(updatedUser.getUser_name(), existingUser.getUser_name());
        Assertions.assertEquals(updatedUser.getUser_email(), existingUser.getUser_email());
        Assertions.assertEquals(updatedUser.getUser_phoneno(), existingUser.getUser_phoneno());
        verify(userRepo, times(1)).save(existingUser);
        Assertions.assertEquals(updatedUser, result);
    } 
    
    @Test
    public void getUserByIdTest() throws UserIdNotFoundException {
        User_info existingUser = new User_info("jason12", "Jason Chris Zion", "jasoncz@gmail.com", 9940260012L);
        when(userRepo.existsById("jason12")).thenReturn(true);
        when(userRepo.findById("jason12")).thenReturn(Optional.of(existingUser));
        User_info result = adminService.getUserById("jason12");
        verify(userRepo, times(1)).existsById("jason12");
        verify(userRepo, times(1)).findById("jason12");
        Assertions.assertEquals(existingUser, result);
    }
    
    @Test
    public void getUserByIdNotFoundTest() {
        when(userRepo.existsById("jason12")).thenReturn(false);
        Assertions.assertThrows(UserIdNotFoundException.class, () -> {
            adminService.getUserById("jason12");
        });
        verify(userRepo, never()).findById(toString());
    }
    
    @Test
    public void testGetUserByName() throws UserNameNotFoundException {
        User_info user1 = new User_info("jo123", "Johina", "johina@gmail.com", 9841715549L);
        User_info user2 = new User_info("jace123", "Jason", "jason@gmail.com", 9940260012L);
        User_info user3 = new User_info("aishu123", "Aishu", "aishu@gmail.com", 8056391238L);
        List<User_info> users = Arrays.asList(user1, user2, user3);
        when(userRepo.findAll()).thenReturn(users);
        List<User_info> result = adminService.getUserByName("Johina");
        assertEquals(1, result.size());
        assertEquals("Johina", result.get(0).getUser_name());
    }
    
    @Test
    public void testGetUserByName_NoMatchingUser() {
        when(userRepo.findAll()).thenReturn(new ArrayList<>());
        try {
            adminService.getUserByName("Johina");
        } catch (UserNameNotFoundException e) {
            assertEquals("User name not found", e.getMessage());
        }
    }
    
    @Test
    public void testGetUserByEmail() throws UserEmailNotFoundException {
        User_info user1 = new User_info("jo123", "Johina", "johina@gmail.com", 9841715549L);
        User_info user2 = new User_info("jace123", "Jason", "jason@gmail.com", 9940260012L);
        User_info user3 = new User_info("aishu123", "Aishu", "aishu@gmail.com", 8056391238L);
        List<User_info> users = Arrays.asList(user1, user2, user3);
        when(userRepo.findAll()).thenReturn(users);
        List<User_info> result = adminService.getUserByEmail("johina@gmail.com");
        assertEquals(1, result.size());
        assertEquals("johina@gmail.com", result.get(0).getUser_email());
    }
    
    @Test
    public void testGetUserByEmail_NoMatchingUser() {
        when(userRepo.findAll()).thenReturn(new ArrayList<User_info>());
        try {
            adminService.getUserByEmail("johina@gmail.com");
        } catch (UserEmailNotFoundException e) {
            assertEquals("User email not found", e.getMessage());
        }
    }
    
    @Test
    public void testFindByPhoneno() throws UserPhoneNoNotFoundException {
        User_info user1 = new User_info("jo123", "Johina", "johina@gmail.com", 9841715549L);
        User_info user2 = new User_info("jace123", "Jason", "jason@gmail.com", 9940260012L);
        User_info user3 = new User_info("aishu123", "Aishu", "aishu@gmail.com", 8056391238L);
        List<User_info> users = Arrays.asList(user1, user2, user3);
        when(userRepo.findAll()).thenReturn(users);
        List<User_info> result = adminService.findByPhoneno(9940260012L);
        assertEquals(1, result.size());
        assertEquals(9940260012L, result.get(0).getUser_phoneno());
    }
    
    @Test
    public void testFindByPhoneno_NoMatchingUser() {
        when(userRepo.findAll()).thenReturn(new ArrayList<User_info>());
        try {
            adminService.findByPhoneno(9940260012L);
        } catch (UserPhoneNoNotFoundException e) {
            assertEquals("User phone number not found", e.getMessage());
        }
    }
    
}               

