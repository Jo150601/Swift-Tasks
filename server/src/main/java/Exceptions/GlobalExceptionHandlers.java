package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlers {
	
	@ExceptionHandler(value=UserEmailNotFoundException.class)
	public ResponseEntity useremailnotfoundexception(UserEmailNotFoundException ex) 
	{
		return new ResponseEntity("Email ID Not Found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=UserIdNotFoundException.class)
	public ResponseEntity useridnotfoundexception(UserIdNotFoundException ex) 
	{
		return new ResponseEntity("User ID Not Found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=UserNameNotFoundException.class)
	public ResponseEntity usernamenotfoundexception(UserNameNotFoundException ex) 
	{
		return new ResponseEntity("User Name Not Found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=UserPhoneNoNotFoundException.class)
	public ResponseEntity userphonenoexception(UserPhoneNoNotFoundException ex) 
	{
		return new ResponseEntity("User Phone Number Not Found",HttpStatus.NOT_FOUND);
	}
}








