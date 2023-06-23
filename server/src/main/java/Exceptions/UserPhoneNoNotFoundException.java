package Exceptions;

public class UserPhoneNoNotFoundException extends Exception{
	
	private String message;

	public UserPhoneNoNotFoundException() {
		super();
	}

	public UserPhoneNoNotFoundException(String message) {
		super();
		this.message = message;
	}

}
