package exception;

public class HospitalNotFundException extends Exception{
	private static final String MESSAGE_HOSPITAL_NOT_FUND_EXCEPTION = "Hospital no encontrado";
	private static final long serialVersionUID = 1L;
	
	public HospitalNotFundException() {
		super(MESSAGE_HOSPITAL_NOT_FUND_EXCEPTION);
	}
	
}
