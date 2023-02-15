package exception;

public class UserNotFundException extends Exception {

	private static final String MESSAGE_USER_NOT_FUND_EXCEPTION = "Usuario no encontrado";
	
	private static final long serialVersionUID = 1L;

	public UserNotFundException() {
		super(MESSAGE_USER_NOT_FUND_EXCEPTION);
	}
}
