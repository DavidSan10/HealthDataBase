package model;

import java.time.LocalDate;

/**
 * 
 * 
 * @author David Alejandro Chaparro Galvis
 * @author Juan Camilo Cepeda Carrenio
 * @version 2.0
 * 
 * 
 */

public class Person {

	private String firstName;
	private String lastName;
	private String idString;
	private DocumentType typeDocument;
	private String dateOfBirth;

	public Person(DocumentType typeDocument, String idString, String firstName, String lastName,
			LocalDate dateOfBirth) {
		this.idString = idString;
		this.typeDocument = typeDocument;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth.toString();
	}

	public Person(String idString) {
		this.idString = idString;
	}

	public Person() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdString() {
		return idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public LocalDate getDateOfBirth() {
		return LocalDate.parse(dateOfBirth);
	}

	public String getDateOfBirthString() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth.toString();
	}

	public DocumentType getTypeDocument() {
		return typeDocument;
	}

	public void setTypeDocument(DocumentType typeDocument) {
		this.typeDocument = typeDocument;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", idString=" + idString
				+ ", typeDocument=" + typeDocument + ", dateOfBirth=" + getDateOfBirthString() + "]";
	}

}
