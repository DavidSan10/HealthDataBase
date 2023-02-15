package interfaz;

import java.util.Comparator;

import model.Administrator;


public class ComparatorAdministrator implements Comparator<Administrator>{

	@Override
	public int compare(Administrator o1, Administrator o2) {
		String idOne = o1.getIdString();
		String idTwo = o2.getIdString();
		return idOne.compareToIgnoreCase(idTwo);
	}

	

}
