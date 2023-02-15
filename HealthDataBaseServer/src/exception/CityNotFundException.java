package exception;

public class CityNotFundException extends Exception{
	private static final String MESSAGE_CITY_NOT_FUND_EXCEPTION = "Cuidad no encontrada";
	private static final long serialVersionUID = 1L;
	
	public CityNotFundException() {
		super(MESSAGE_CITY_NOT_FUND_EXCEPTION);
	}
}
