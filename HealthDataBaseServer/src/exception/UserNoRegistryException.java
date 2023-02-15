package exception;

public class UserNoRegistryException extends Exception{
	

	private static final String MESSAGE_EXCEPTION_USER_NO_REGISTRY = "Usuario no registrado";
	private static final long serialVersionUID = 1L;

	public UserNoRegistryException() {
		super(MESSAGE_EXCEPTION_USER_NO_REGISTRY);
	
	}
	
	
	

}
