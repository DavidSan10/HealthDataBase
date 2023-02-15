package exception;

public class IsValidExceptionId extends Exception{
	
	
	private static final String MESSAGE_EXCEPTION_ID = "Id es invalido";
	
	private static final long serialVersionUID = 1L;

	public IsValidExceptionId() {
		super(MESSAGE_EXCEPTION_ID);
	}

	public String getMessage() {
		return MESSAGE_EXCEPTION_ID;
	}
	
}
