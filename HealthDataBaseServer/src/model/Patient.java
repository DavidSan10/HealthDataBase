package model;

import java.time.LocalDate;

public class Patient extends Person {
	private String takeDay;
	private boolean isVacuned;
	private Cormorbidities typeComobidities;
	private boolean isPositive;

	public Patient(DocumentType typeDocument, String idString, String firstName, String lastName, LocalDate dateOfBirth,
			Cormorbidities typeComobidities, LocalDate takeDay, boolean isVacuned, boolean isPositive) {
		super(typeDocument, idString, firstName, lastName, dateOfBirth);
		this.typeComobidities = typeComobidities;
		this.takeDay = takeDay.toString();
		this.isVacuned = isVacuned;
		this.isPositive = isPositive;
	}

	public Patient(String id) {
		super(id);
	}

	public Cormorbidities getTypeComobidities() {
		return typeComobidities;
	}

	public void setTypeComobidities(Cormorbidities typeComobidities) {
		this.typeComobidities = typeComobidities;
	}

	public String getTakeDay() {
		return takeDay;
	}

	public void setTakeDay(LocalDate takeDay) {
		this.takeDay = takeDay.toString();
	}

	public boolean isVacuned() {
		return isVacuned;
	}

	public String hadCovid() {
		String result = "";
		if (this.isPositive) {
			result = "Si";
		} else {
			result = "No";
		}
		return result;
	}

	public String isVacunedPatient() {
		String result = "";
		if (this.isVacuned) {
			result = "Si";
		} else {
			result = "No";
		}
		return result;
	}

	public Object[] toObjectVector() {
		return new Object[] { this.getTypeDocument().getName().toUpperCase(), this.getIdString(),
				this.getFirstName().toUpperCase(), this.getLastName().toUpperCase(), this.getDateOfBirthString(),
				this.getTypeComobidities().getName().toUpperCase(), getTakeDay(), isVacunedPatient(), hadCovid() };
	}

	public boolean isPositive() {
		return isPositive;
	}
}
