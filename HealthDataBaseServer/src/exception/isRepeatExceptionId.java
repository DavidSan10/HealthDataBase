package exception;

public class isRepeatExceptionId extends Exception {
	

	private static final String MESSAGE_EXCEPTION_ID_REPEAT = "El id esta repetido";
	
	private static final long serialVersionUID = 1L;

	public isRepeatExceptionId() {
		super(MESSAGE_EXCEPTION_ID_REPEAT);
	}

}
