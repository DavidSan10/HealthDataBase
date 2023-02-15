package exception;

public class IsValidLastName extends Exception{


	private static final String MESSAGE_EXCEPTION_LAST_NAME = "Apellidos invalidos";
	private static final long serialVersionUID = 1L;
	
	
	public IsValidLastName() {
		super(MESSAGE_EXCEPTION_LAST_NAME);
	}
	

}
