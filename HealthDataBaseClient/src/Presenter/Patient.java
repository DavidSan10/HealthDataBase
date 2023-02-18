package Presenter;

import java.time.LocalDate;

import myEnum.Cormorbidities;
import myEnum.DocumentType;

public class Patient{
	private String firstName;
	private String lastName;
	private String idString;
	private DocumentType typeDocument;
//	private LocalDate dateOfBirth;
//	private LocalDate takeDay;
	private String dateOfBirth;
	private String takeDay;
	private boolean isVacuned;
	private Cormorbidities typeComobidities;
	private boolean isPositive;

	public Patient(DocumentType typeDocument, String idString, String firstName, String lastName, LocalDate dateOfBirth,
			Cormorbidities typeComobidities, LocalDate takeDay, boolean isVacuned, boolean isPositive) {
		this.idString = idString;
		this.typeDocument = typeDocument;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth.toString();
		this.typeComobidities = typeComobidities;
		this.takeDay = takeDay.toString();
		this.isVacuned = isVacuned;
		this.isPositive = isPositive;
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

	public DocumentType getTypeDocument() {
		return typeDocument;
	}

	public void setTypeDocument(DocumentType typeDocument) {
		this.typeDocument = typeDocument;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getTakeDay() {
		return takeDay;
	}

	public void setTakeDay(String takeDay) {
		this.takeDay = takeDay;
	}

	public boolean isVacuned() {
		return isVacuned;
	}

	public void setVacuned(boolean isVacuned) {
		this.isVacuned = isVacuned;
	}

	public Cormorbidities getTypeComobidities() {
		return typeComobidities;
	}

	public void setTypeComobidities(Cormorbidities typeComobidities) {
		this.typeComobidities = typeComobidities;
	}

	public boolean isPositive() {
		return isPositive;
	}

	public void setPositive(boolean isPositive) {
		this.isPositive = isPositive;
	}

	
	
	

}
