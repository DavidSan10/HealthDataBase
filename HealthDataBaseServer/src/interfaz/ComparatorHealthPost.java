package interfaz;

import java.util.Comparator;

import model.HealthPost;

public class ComparatorHealthPost implements Comparator<HealthPost>{

	@Override
	public int compare(HealthPost h1, HealthPost h2) {
		String idOne = h1.getId();
		String idTwo = h2.getId();
		return idOne.compareToIgnoreCase(idTwo);
	}

}
