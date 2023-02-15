package interfaz;

import java.util.Comparator;

import model.Administrator;

public class ComparatorAdministratorEmail implements Comparator<Administrator>{

	@Override
	public int compare(Administrator o1, Administrator o2) {
		String emailOne = o1.getUserName();
		String emailTwo = o2.getUserName();
		return emailOne.compareToIgnoreCase(emailTwo);
	}

}
