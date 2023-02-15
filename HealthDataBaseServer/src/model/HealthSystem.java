package model;

import java.util.ArrayList;
import BinaryTree.BinaryTree;
import exception.*;
import interfaz.ComparatorAdministrator;
import interfaz.ComparatorCityName;
import interfaz.ComparatorHealthPost;
import interfaz.ComparatorPatient;
import tool.Tool;

public class HealthSystem {

	private BinaryTree<HealthPost> healthPostTree;
	private BinaryTree<City> cityTree;
	private BinaryTree<Administrator> administratorTree;

	public HealthSystem(BinaryTree<Administrator> administratorTree, BinaryTree<HealthPost> healthPostTree,
			BinaryTree<City> cityTree) {
		this.healthPostTree = healthPostTree;
		this.cityTree = cityTree;
		this.administratorTree = administratorTree;

	}

	/* Correcto */

	public boolean isRepeatHospital(String id) {
		if (healthPostTree.isExist(new HealthPost(id), new ComparatorHealthPost())) {
			return true;
		}
		return false;
	}

	/* Correcto */

	public boolean isNameRepeat(String name) throws isRepeatNameCityException {
		City aux = new City("", name);
		City city = cityTree.isExistData(aux, new ComparatorCityName());
		if (city != null) {
			throw new isRepeatNameCityException();
		}
		return false;
	}

	/* Correcto */
	public boolean isRepeatCity(String id) {
		ArrayList<City> listAux = cityTree.getListData();
		for (int i = 0; i < listAux.size(); i++) {
			if (listAux.get(i).getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Cuidad agregada por nombre
	 */

	public synchronized boolean addCity(String id, String name) throws isRepeatNameCityException {
		if (!isRepeatCity(id) && Tool.validIdCityOrHospital(id)) {
			if (!isNameRepeat(name)) {
				cityTree.insert(new City(id, name), new ComparatorCityName());
				return true;
			}

		}
		return false;
	}

	/*
	 * Puesto de salud agregado por codigo
	 */

	public synchronized boolean createHealthPost(String idCity, String idHealthPost, String nameHospital) {
		if (isRepeatCity(idCity) && !isRepeatHospital(idHealthPost) && Tool.validIdCityOrHospital(idHealthPost)) {
			BinaryTree<Patient> aux = new BinaryTree<Patient>();
			City city = searchCity(idCity);
			healthPostTree.insert(new HealthPost(idHealthPost, nameHospital, aux, city), new ComparatorHealthPost());
			return true;
		}
		return false;
	}

	/**
	 * Se utiliza para validar los atributos del pacientes su nombre, apellido y id
	 * si no cumple lanza una excepcion dependiendo a lo que incumpla
	 * 
	 * @param patient
	 * @return retorna un booleano verdadero si cumple
	 * @throws IsValidExceptionId
	 * @throws IsValidName
	 * @throws IsValidLastName
	 */
	public boolean isValidPerson(Person person) throws IsValidExceptionId, IsValidName, IsValidLastName {
		if (Tool.validateId(person.getIdString())) {
			if (Tool.validNameOrLastName(person.getFirstName())) {
				if (Tool.validNameOrLastName(person.getLastName())) {
					return true;
				} else {
					throw new IsValidLastName();
				}
			} else {
				throw new IsValidName();
			}
		} else {
			throw new IsValidExceptionId();
		}
	}

	public synchronized boolean addPatient(String idHealthPost, Patient patient)
			throws IsValidExceptionId, IsValidName, IsValidLastName {
		if (isValidPerson(patient) && !isRepeatIdPatient(patient.getIdString())) {
			for (int i = 0; i < healthPostTree.getListData().size(); i++) {
				if (healthPostTree.getListData().get(i).getId().equalsIgnoreCase(idHealthPost)) {
					healthPostTree.getListData().get(i).getTreePatient().insert(patient, new ComparatorPatient());
					return true;
				}

			}
		}
		return false;
	}

	public synchronized boolean addAdministrator(Administrator administrator)
			throws IsValidExceptionId, IsValidName, IsValidLastName, isRepeatExceptionId, isRepeatEmailException {
		if (isValidPerson(administrator) && Tool.validEmail(administrator.getUserName())) {
			if (!isRepeatIdAdministrator(administrator.getIdString())) {
				if (!isRepeatEmailAdministrator(administrator.getUserName())) {
					administratorTree.insert(administrator, new ComparatorAdministrator());
					return true;
				}
			}

		}
		return false;
	}

	public boolean validateAdministratorInput(String email, String password) {
		if (Tool.validEmail(email)) {
			if (loginAdministrator(email, password)) {
				return true;
			}
		}
		return false;
	}

	public boolean isRepeatIdAdministrator(String id) throws isRepeatExceptionId {
		Administrator administrator = administratorTree.isExistData(new Administrator(id),
				new ComparatorAdministrator());
		if (administrator != null) {
			throw new isRepeatExceptionId();
		}
		return false;
	}

	public boolean isRepeatEmailAdministrator(String email) throws isRepeatEmailException {
		ArrayList<Administrator> administratorList = administratorTree.getListData();
		for (int i = 0; i < administratorList.size(); i++) {
			if (administratorList.get(i).getUserName().equalsIgnoreCase(email)) {
				throw new isRepeatEmailException();
			}
		}
		return false;
	}

	public boolean isRepeatIdPatient(String id) {
		ArrayList<HealthPost> healthPostList = healthPostTree.getListData();
		for (int i = 0; i < healthPostList.size(); i++) {
			ArrayList<Patient> patientList = healthPostList.get(i).getTreePatient().getListData();
			for (int j = 0; j < patientList.size(); j++) {
				if (patientList.get(j).getIdString().equalsIgnoreCase(id)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean loginAdministrator(String email, String password) {
		ArrayList<Administrator> administratorList = administratorTree.getListData();
		for (int i = 0; i < administratorList.size(); i++) {
			if (administratorList.get(i).getUserName().equalsIgnoreCase(email)) {
				if (administratorList.get(i).getPassword().equalsIgnoreCase(password)) {
					return true;
				}

			}
		}

		return false;
	}

	public BinaryTree<Administrator> getListAdministrator() {
		return administratorTree;
	}

	/*
	 * Correcto
	 */

	public ArrayList<String> getNameHealthPostForCity(String nameCity) {
		ArrayList<HealthPost> listHealthPostAux = healthPostTree.getListData();
		ArrayList<String> listHealthPost = new ArrayList<String>();
		for (int i = 0; i < listHealthPostAux.size(); i++) {
			if (listHealthPostAux.get(i).getCity().getName().equalsIgnoreCase(nameCity)) {
				listHealthPost.add(listHealthPostAux.get(i).getName());
			}

		}

		return listHealthPost;

	}

	public ArrayList<City> getListCity() {
		//ArrayList<City> list = cityTree.getListData();
		return  cityTree.getListData();
	}

	public BinaryTree<City> getTreeCity() {
		return cityTree;
	}

	/*
	 * Busca por codigo esta correcto
	 */

	public City searchCity(String id) {
		ArrayList<City> list = cityTree.getListData();
		if (Tool.validIdCityOrHospital(id)) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getId().equalsIgnoreCase(id)) {
					return list.get(i);
				}
			}
		}
		return null;
	}

	/*
	 * Buscado por nombre esta correcto
	 */
	public String searchCityForName(String name) {
		City city = cityTree.isExistData(new City("", name), new ComparatorCityName());
		if (city != null) {
			return city.getId();
		}
		return "";
	}

	/*
	 * Correcto
	 * 
	 */

	public String searchHealthPostForName(String name) {
		ArrayList<HealthPost> listHealth = healthPostTree.getListData();
		for (int i = 0; i < listHealth.size(); i++) {
			if (listHealth.get(i).getName().equalsIgnoreCase(name)) {
				return listHealth.get(i).getId();
			}
		}
		return "";
	}

	public ArrayList<HealthPost> getHealthPostList() {
		return healthPostTree.getListData();
	}

	public BinaryTree<HealthPost> getHealthPostTree() {
		return healthPostTree;
	}

	public ArrayList<Object[]> showMatrixHospital() {
		ArrayList<Object[]> dataMatrix = new ArrayList<Object[]>();
		ArrayList<HealthPost> healthPostList = healthPostTree.getListData();
		for (HealthPost hospital : healthPostList) {
			ArrayList<Object[]> auxList = hospital.toObjectMatrix();
			for (Object[] objects : auxList) {
				dataMatrix.add(objects);
			}
		}
		return dataMatrix;
	}

	public void deletePatient(String idPatient) {
		for (int i = 0; i < healthPostTree.getListData().size(); i++) {
			for (int j = 0; j < healthPostTree.getListData().get(i).getTreePatient().getListData().size(); j++) {
				if (healthPostTree.getListData().get(i).getTreePatient().getListData().get(j).getIdString()
						.equals(idPatient)) {
					healthPostTree.getListData().get(i).getTreePatient().remove(new Patient(idPatient),
							new ComparatorPatient());
				}
			}

		}
	}
	
	
	public synchronized int[] getCountPatient() {
		int[] array = new int[2];
		ArrayList<HealthPost> getListPatient = healthPostTree.getListData();
		for (int i = 0; i < getListPatient.size(); i++) {
			ArrayList<Patient> listPatientAux = getListPatient.get(i).getTreePatient().getListData();
			for (int j = 0; j < listPatientAux.size(); j++) {
				if(listPatientAux.get(j).isVacuned() == true) {
					System.out.println("entro  vacunado");
					array[0]++;
				}else {
					System.out.println("entro no vacunado");
					array[1]++;
				}
			}
		}
		return array;
	}
	
	
	public int getTotal(int[] count) {
		int result = 0;
		for (int i = 0; i < count.length; i++) {
			result +=  count[i];
		}
		return result;
	}
	
	
	public synchronized int[] getPorcentage(int[] count) {
		int total = getTotal(count);
		System.out.println("total de pacientes" + total);
		int[] porcentage = new int[count.length];
		for (int i = 0; i < count.length && total != 0; i++) {
			porcentage[i] = (count[i] * 100) / total;
		}
		return porcentage;
	}

	

}
