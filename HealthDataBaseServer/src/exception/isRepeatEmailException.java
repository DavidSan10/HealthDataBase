package exception;

public class isRepeatEmailException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String MESSAGE_EXCEPTION_EMAIL_REPEAT = "El email ya registrado";
	
	public isRepeatEmailException() {
		super(MESSAGE_EXCEPTION_EMAIL_REPEAT);
	}


}
