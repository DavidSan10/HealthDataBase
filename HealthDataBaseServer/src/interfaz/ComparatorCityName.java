package interfaz;

import java.util.Comparator;

import model.City;

public class ComparatorCityName implements Comparator<City>{

	@Override
	public int compare(City o1, City o2) {
		String nameOne = o1.getName();
		//System.out.println("comparador 1" + nameOne);
		String nameTwo = o2.getName();
		//System.out.println("comparador 2" + nameTwo);
		int valor = nameOne.compareToIgnoreCase(nameTwo);
		//System.out.println("valor: "+valor);
		return valor;
	}

}
