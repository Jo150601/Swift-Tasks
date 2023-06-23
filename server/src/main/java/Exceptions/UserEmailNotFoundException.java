package Exceptions;

public class UserEmailNotFoundException extends Exception {
	
	private String message;

	public UserEmailNotFoundException() {
		super();
	}

	public UserEmailNotFoundException(String message) {
		super();
		this.message = message;
	}

}
