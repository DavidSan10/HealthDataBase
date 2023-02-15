package interfaz;

import java.util.Comparator;

import model.HealthPost;

public class ComparatorHealthPostName implements Comparator<HealthPost>{

	@Override
	public int compare(HealthPost o1, HealthPost o2) {
		String nameOne = o1.getName();
		String nameTwo = o2.getName();
		return nameOne.compareToIgnoreCase(nameTwo);
	}

}
