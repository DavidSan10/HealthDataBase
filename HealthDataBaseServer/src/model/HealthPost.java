package model;

import java.util.ArrayList;
import BinaryTree.BinaryTree;
import tool.Tool;

public class HealthPost {
	private String id;
	private String name;
	private City city;
	private String idCity;
	private BinaryTree<Patient> treePatient;

	public HealthPost(String id, String name, BinaryTree<Patient> treePatient, City city) {
		this.id = id;
		this.name = name;
		this.treePatient = treePatient;
		this.city = city;

	}

	public HealthPost(String id, String name, String idCity) {
		this.id = id;
		this.name = name;
		this.idCity = idCity;
	}

	public HealthPost(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public HealthPost(String id) {
		this.id = id;
	}

	public String getIdCity() {
		return idCity;
	}

	public void setIdCity(String idCity) {
		this.idCity = idCity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene el total de pacientes de un hospital
	 * 
	 * @return numero de pacientes que agregados en un determinado hospital
	 */

//	public int getTotalPatient() {
//		return listPatient.size();
//	}

	public int getTotalPatient() {
		return treePatient.getSize();
	}

	public BinaryTree<Patient> getTreePatient() {
		return treePatient;
	}

	public void setTreePatient(BinaryTree<Patient> treePatient) {
		this.treePatient = treePatient;
	}

	/**
	 * Coge el atributo Id y nombre del hospital y lo agrega a un vestor de objetos
	 * 
	 * @return Un arreglo de objetos
	 */

	public Object[] toObjectHospital() {
		return new Object[] { getId(), getName().toUpperCase() };
	}

	/**
	 * Se utiliza el metodo para poder concatenar los atributos de hospital con los
	 * de cada uno de los atributos de un paciente que esta referido o se tomo la
	 * prueba en ese hospital
	 * 
	 * @return devuelve una lista de un arreglo de objetos con el id y el nombre del
	 *         hospital y los atributos del paciente
	 */

	public ArrayList<Object[]> toObjectMatrix() {
		ArrayList<Object[]> resultList = new ArrayList<Object[]>();
		ArrayList<Patient> listPatient = treePatient.getListData();

		for (Patient pat : listPatient) {
			resultList.add(Tool.concatObjectArrays(
					new Object[] { getCity().getName(), getId(), getName().toUpperCase() }, pat.toObjectVector()));
		}
		return resultList;
	}

}
