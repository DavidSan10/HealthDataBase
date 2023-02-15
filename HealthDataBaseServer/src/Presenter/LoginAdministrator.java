package Presenter;

public class LoginAdministrator {

	private String email;
	private String password;
	
	public LoginAdministrator(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}



	@Override
	public String toString() {
		return "LoginAdministrator [email=" + email + ", password=" + password + "]";
	}
	
	
}
