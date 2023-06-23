package Exceptions;

public class UserIdNotFoundException extends Exception{
	
	private String mesaage;
	
	public UserIdNotFoundException() {
		super();
	}

	public UserIdNotFoundException(String message) {
		super();
		this.mesaage = message;
	}

}
