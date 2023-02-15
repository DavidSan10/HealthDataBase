package interfaz;

import java.util.Comparator;

import model.City;

public class ComparatorCity implements Comparator<City>{

	@Override
	public int compare(City o1, City o2) {
		String idOne = o1.getId();
		String idTwo = o2.getId();
		return idOne.compareToIgnoreCase(idTwo);
	}

}
