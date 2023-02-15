package exception;

public class isTotalEmpty extends Exception{
	private static final String MESSAGE_TOTAL_EMPTY_EXCEPTION = "No hay datos para mostrar";
	private static final long serialVersionUID = 1L;
	
	
	public isTotalEmpty() {
		super(MESSAGE_TOTAL_EMPTY_EXCEPTION);
	}
	

}
