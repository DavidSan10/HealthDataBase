package Presenter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

import com.google.gson.Gson;

import IObserver.IObserver;
import IObserver.ISubject;
import Persistence.Files;
import exception.IsValidExceptionId;
import exception.IsValidLastName;
import exception.IsValidName;
import exception.isRepeatEmailException;
import exception.isRepeatExceptionId;
import exception.isRepeatNameCityException;
import model.Administrator;
import model.City;
import model.Constants;
import model.HealthPost;
import model.HealthSystem;
import model.Patient;

public class HealthSystemThread extends Thread implements IObserver{

	private HealthSystem manager;
	private Socket client;
	private ISubject subject;
	private DataOutputStream output;
	private DataInputStream input;
	private static String option;
	
	public HealthSystemThread(Socket client,HealthSystem manager,ISubject subject) throws IOException {
		this.client = client;
		this.manager = manager;
		this.subject = subject;
		option = "";
		output = new DataOutputStream(client.getOutputStream());// Escribir al servidor
		input = new DataInputStream(client.getInputStream());// Leer al servidor
	
	}
	
	
	@Override
	public void run() {
		try {
			init();
		}catch(SocketException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void init() throws IOException {
		String option = input.readUTF();
		switch (option) {
		//case "listCities":
		case Constants.MESSAGE_LIST_CITIES:
			output.writeUTF(new Gson().toJson(getNameCities()));
			init();
			break;
		//case "listHealthPost":
		case Constants.MESSAGE_LIST_HEALTHPOST:
			output.writeUTF(new Gson().toJson(getHealthPost()));
			init();
			break;
		//case "createAdministrator":
		case Constants.MESSAGE_CREATE_ADMINISTRATOR:
			createAdministrator();
			init();
			break;
		//case "loginAdministrator":
		case Constants.MESSAGE_LOGIN_ADMINISTRATOR_TWO:
			loginAdministrator();
			init();
			break;
		//case "createCities":
		case Constants.MESSAGE_CREATE_CITIES:
			createCity();
			init();
			break;
		//case "createHealthPost":
		case Constants.MESSAGE_CREATE_HEALTHPOST:
			createHealthPost();
			init();
			break;
		//case "addPatient":
		case Constants.MESSAGE_ADD_PATIENT_TWO:
			 addPatient();
			 init();
			break;
		//case "uploadComboCities":
		case Constants.MESSAGE_UPLOAD_COMBOBOX_CITIES:
			getNameHealthPostForCity();
			init();
			break;
		//case "getNameCities":
		case Constants.MESSAGE_GET_NAMES_CITIES:
			output.writeUTF(new Gson().toJson(getNameCities()));
			init();
			break;
		//case "getShowMatrixHospital":
		case Constants.MESSAGE_GET_SHOW_MATRIX_HOSPITAL:
			String result = new Gson().toJson(new Hospital(manager.showMatrixHospital()));
			output.writeUTF(result);
			init();
			break;
		case Constants.MESSAGE_DELETE_PATIENT:
			deletePatient();
			init();
			break;
		//case "exit":
		case Constants.MESSAGE_PORCENTAGE:
			getPorcentage();
			init();
			break;
		case Constants.MESSAGE_EXIT:
			subject.detach(this);
			client.close();
			break;
	
		default:
			break;
		}

	}
	
	
	
	public void deletePatient() {
		try {
			output.writeUTF(new Gson().toJson(new Hospital(manager.showMatrixHospital())));
			String idPatient = input.readUTF();
			manager.deletePatient(idPatient);
			Files.writeFilesHealtPost(manager.getHealthPostTree());
			option = "updatePatient";
			subject.notifyObservers();
			option = "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void addPatient() throws IOException {
		String patient;
		String idHealthPost;
		try {
			patient = input.readUTF();
			idHealthPost = input.readUTF();
			Patient auxPatient = new Gson().fromJson(patient, Patient.class);
			String auxId = manager.searchHealthPostForName(idHealthPost);
			if(manager.addPatient(auxId, auxPatient)) {
				output.writeBoolean(true);
				Files.writeFilesHealtPost(manager.getHealthPostTree());
				option = "updatePatient";
				subject.notifyObservers();
				option = "";
			}else {
				output.writeBoolean(false);
			}
		} catch (IOException e) {
			output.writeBoolean(false);
			//e.printStackTrace();
		} catch (IsValidExceptionId e) {
			output.writeBoolean(false);
			//e.printStackTrace();
		} catch (IsValidName e) {
			output.writeBoolean(false);
			//e.printStackTrace();
		} catch (IsValidLastName e) {
			output.writeBoolean(false);
			//e.printStackTrace();
		}
		
	}
	
	private void createHealthPost() {
		String healthPost;
		
		try {
			healthPost = input.readUTF();
			HealthPost aux = new Gson().fromJson(healthPost, HealthPost.class);
			String idCity = manager.searchCityForName(aux.getIdCity());
			if(manager.createHealthPost(idCity,String.valueOf(manager.getHealthPostTree().getSize() + 1), aux.getName())) {
				output.writeBoolean(true);
				Files.writeFilesHealtPost(manager.getHealthPostTree());
				option = "updateHealthPost";
				subject.notifyObservers();
				//getHealthPost(); //aquiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii
				option = "";
			}else {
				output.writeBoolean(false);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getNameHealthPostForCity() {
		try {
			String city = input.readUTF();
			System.out.println("cuidad" + city);
			ArrayList<String> list = manager.getNameHealthPostForCity(city);
			output.writeUTF(new Gson().toJson(list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	
//	public ArrayList<String> getNamesHealthPost() {
//		ArrayList<HealthPost> listCities = manager.getHealthPostList();
//		ArrayList<String> listNamesCities = new ArrayList<String>();
//		for (int i = 0; i < listCities.size(); i++) {
//			listNamesCities.add(listCities.get(i).getName());
//			
//		}
//		return listNamesCities;
//	}

	private void createCity() {
		String city;
		try {
			city = input.readUTF();
			City aux = new Gson().fromJson(city, City.class);
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$"+aux);
			if(manager.addCity(String.valueOf(manager.getTreeCity().getSize() + 1), aux.getName())) {
				Files.writeFilesCity(manager.getTreeCity());
				output.writeBoolean(true);
				option = "updateCity";
				subject.notifyObservers();
				option = "";
			}else {
				output.writeBoolean(false);
			}
		} catch (IOException e) {
			try {
				output.writeBoolean(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (isRepeatNameCityException e) {
			try {
				output.writeBoolean(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	public ArrayList<String> getNameCities() {
		ArrayList<String> listNamesCities = new ArrayList<String>();
		ArrayList<City> listCities = manager.getListCity();
		for (int i = 0; i < listCities.size(); i++) {
			listNamesCities.add(listCities.get(i).getName());
		}
		System.out.println("Obtener nombre de cuidades" + listNamesCities);
		return listNamesCities;
	}

	public ArrayList<String> getHealthPost() {
		ArrayList<String> listCities = getNameCities();
		if(listCities.isEmpty()) {
			return new ArrayList<>();
		}
		return manager.getNameHealthPostForCity(listCities.get(0));
	}

	public void createAdministrator() {

		String administrator;
		try {
			administrator = input.readUTF();
			Administrator ad = new Gson().fromJson(administrator, Administrator.class);
			if (ad.getPassword().equals("") || ad.getFirstName().equals("") || ad.getLastName().equals("")
					|| ad.getDateOfBirth() == null || ad.getUserName().equals("") || ad.getTypeDocument() == null) {
				output.writeBoolean(false);
			} else {
				try {
					if(manager.addAdministrator(ad) == true) {
						Files.writeFileAdministrator(manager.getListAdministrator());
						output.writeBoolean(true);
					}else {
						output.writeBoolean(false);
					}
				
				} catch (IsValidExceptionId e) {
					output.writeBoolean(false);
				
				} catch (IsValidName e) {
					output.writeBoolean(false);
			
				} catch (IsValidLastName e) {
					output.writeBoolean(false);
			
				} catch (isRepeatExceptionId e) {
					output.writeBoolean(false);
				} catch (isRepeatEmailException e) {
					output.writeBoolean(false);
					
				}

			}
		} catch (IOException e) {
			try {
				output.writeBoolean(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
	
	
	public void loginAdministrator() {
		String loginAdministrator;
		try {
			loginAdministrator = input.readUTF();
			LoginAdministrator login = new Gson().fromJson(loginAdministrator, LoginAdministrator.class);
			if(manager.validateAdministratorInput(login.getEmail(),login.getPassword())) {
				output.writeBoolean(true);
				//output.writeUTF("login");
				output.writeUTF(new Gson().toJson(new Hospital(manager.showMatrixHospital())));
			}else {
				output.writeBoolean(false);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getPorcentage() {
		try {
			output.writeUTF(new Gson().toJson(manager.getPorcentage(manager.getCountPatient())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	


	@Override
	public void update() {
		try {
			switch (option) {
			case Constants.MESSAGE_UPDATE_CITY:
				output.writeUTF(Constants.MESSAGE_UPDATE_CITY);
				break;
			case Constants.MESSAGE_UPDATE_HEALTHPOST:
				output.writeUTF(Constants.MESSAGE_UPDATE_HEALTHPOST);
				//output.writeUTF(new Gson().toJson(getNamesHealthPost()));
				output.writeUTF(new Gson().toJson(getHealthPost()));
				
				break;
			case Constants.MESSAGE_UPDATE_PATIENT:
				output.writeUTF(Constants.MESSAGE_UPDATE_PATIENT);
				output.writeUTF(new Gson().toJson(new Hospital(manager.showMatrixHospital())));
				break;
			default:
				break;
			}
		} catch (IOException e) {
			//TODO Auto-generated catch block
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}

	}
	


}
