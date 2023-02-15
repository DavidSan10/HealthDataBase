package model;

import java.time.LocalDate;

public class Administrator extends Person {

	private String userName;
	private String password;

	public Administrator(DocumentType typeDocument, String idString, String firstName, String lastName,
			LocalDate dateOfBirth, String userName, String password) {
		super(typeDocument, idString, firstName, lastName, dateOfBirth);
		this.userName = userName;
		this.password = password;
	}

	public Administrator(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public Administrator(String idString) {
		super(idString);
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return super.toString() + " Administrator [userName=" + userName + ", password=" + password + "]";
	}

	public Object[] toObjectVector() {
		return new Object[] { this.getTypeDocument().getName().toUpperCase(), this.getIdString(),
				this.getFirstName().toUpperCase(), this.getLastName().toUpperCase(), this.getDateOfBirth(),
				this.getUserName() };
	}

}
