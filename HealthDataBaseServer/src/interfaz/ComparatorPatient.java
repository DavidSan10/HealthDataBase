package interfaz;

import java.util.Comparator;

import model.Patient;

public class ComparatorPatient implements Comparator<Patient>{

	@Override
	public int compare(Patient p1, Patient p2) {
		String idOne = p1.getIdString();
		String idTwo = p2.getIdString();
		return idOne.compareToIgnoreCase(idTwo);
	}

}
