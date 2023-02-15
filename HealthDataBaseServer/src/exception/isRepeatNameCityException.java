package exception;

public class isRepeatNameCityException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE_IS_REPEAT_NAME_CITY_EXCEPTION = "Nombre de la cuidad ya agregado";


	public isRepeatNameCityException() {
		super(MESSAGE_IS_REPEAT_NAME_CITY_EXCEPTION);
	}
}
