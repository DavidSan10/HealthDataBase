package Presenter;

import java.time.LocalDate;

import myEnum.DocumentType;


public class Administrator {
	
	private String firstName;
	private String lastName;
	private String idString;
	private DocumentType typeDocument;
	//private LocalDate dateOfBirth;
	private String dateOfBirth;
	private String userName;
	private String password;
	
	public Administrator(DocumentType typeDocument, String idString, String firstName, String lastName,
			LocalDate dateOfBirth,String userName,String password) {
		this.typeDocument = typeDocument;
		this.idString = idString;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth.toString();
		this.userName = userName;
		this.password = password;
	}
	
	
	

}
