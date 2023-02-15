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


}
