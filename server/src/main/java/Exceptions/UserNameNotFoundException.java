package Exceptions;

public class UserNameNotFoundException extends Exception{
	
	private String message;

	public UserNameNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserNameNotFoundException(String message) {
		super();
		this.message = message;
	}

}
