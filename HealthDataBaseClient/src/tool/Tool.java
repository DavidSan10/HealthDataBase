package tool;

public class Tool {
	
	/**
	 * Metodo estatico que valida con expresiones regulares el id del paciente  administrador
	 * @param id
	 * @return retorna un booleano si cumple con el patron de la expresion regular
	 */
	
	public static boolean validateId(String id) {
		return id.matches("[^0]([0-9]{7,10})$");
	}
	
	
	/**
	 * Metodo estatico que valida con expresiones regulares el correo del administrador
	 * @param id
	 * @return retorna un booleano si cumple con el patron de la expresion regular
	 */
	
	
	
	public static boolean validEmail(String email) {
		return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		
	}
	
	/**
	 * Metodo estatico que valida con expresiones regulares el nombre y el apellido
	 * @param name
	 * @return retorna un booleano si cumple con el patron de la expresion regular
	 */
	public static boolean validNameOrLastName(String name) {
		return name.matches("^([a-z|A-Z]+[ ]?){1,3}$");
	}
	
	/**
	 * Metodo estatico que sirve para concatenar dos arreglos de objetos accediendo a su contenido
	 * @param vect1
	 * @param vect2
	 * @return un arreglo de objetos que tiene los atributos de los dos arreglos de objetos
	 */
	public static Object[] concatObjectArrays(Object[] vect1, Object[] vect2) {
		Object[] fusionArray = new Object[vect1.length + vect2.length];
		for (int i = 0; i < fusionArray.length; i++) {
			if (i < vect1.length) 
				fusionArray[i] = vect1[i];			
			else {
				fusionArray[i] = vect2[i - vect1.length];
			}
		}
		return fusionArray;
	}
	
	/**
	 * Obtiene las primeras tres letras de un String
	 * @param name
	 * @return retorna un String con la tres primeras letras en mayuscula
	 */
	public static String nameGrafics(String name) {
		String result = "";
		if(name.length() > 3) {
			for (int i = 0; i < 3; i++) {
				result += name.toUpperCase().charAt(i);
			}
		}else {
			result = name.toUpperCase();
		}
		return result;
	}
	
	
	
	/**
	 * Valida el id del hospital y la cuidad 
	 * @param id
	 * @return retorna un booleano si el patron se cumple
	 */
	
	public static boolean validIdCityOrHospital(String id) {
		return id.matches("[^0]([0-9]{0,4})$");
	}
	

	
	

}
