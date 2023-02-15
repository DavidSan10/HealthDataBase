package exception;

public class IsValidName extends Exception{



	private static final long serialVersionUID = 1L;
	private static final String MESSAGE_VALID_NAME = "Nombres invalidos ";
	
	public IsValidName() {
		super(MESSAGE_VALID_NAME);
	}

	public String getMessage() {
		return MESSAGE_VALID_NAME;	
	}
	
	
}
