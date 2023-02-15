package Presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import ViewDesktop.DesktopView;
import constants.Constants;
import myEnum.Cormorbidities;
import myEnum.DocumentType;

public class Presenter implements ActionListener, ItemListener {

	private Socket client;
	private DataInputStream input;
	private DataOutputStream output;
	private String host = "localhost";
	private int port = 1234;
//	private String host = "186.114.217.181";
	//private int port = 23143;
	private static int count = 0;
	private DesktopView view;
	private Thread thread;
	private boolean isRunning;

	public Presenter() throws UnknownHostException, IOException {
		client = new Socket(host, port);
		input = new DataInputStream(client.getInputStream());
		output = new DataOutputStream(client.getOutputStream());
		view = new DesktopView(this, this, getListCities(), getListHealthPost(), 0);
		changeImages();
		isRunning = true;
		thread = new Thread() {
			public void run() {
				while (isRunning) {
					verify();
				}

			}
		};
		thread.start();
	}

	public ArrayList<String> getListCities() throws IOException {
		output.writeUTF("listCities");
		String message = input.readUTF();
		return getArrayList(new Gson().fromJson(message, String[].class));

	}

	public ArrayList<String> getListHealthPost() throws IOException {
		output.writeUTF("listHealthPost");
		String message = input.readUTF();
		return getArrayList(new Gson().fromJson(message, String[].class));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.LOGIN_MESSAGE:
			view.setVisibleEnteroKey(true);
			break;
		case Constants.MESSAGE_REGISTER:
			view.setVisibleRegister(true);
			break;
		case Constants.ACCEPT_PANEL_REGISTER_MESSAGE:
			createAdministrator();
			break;
		case Constants.CANCELED_PANEL_REGISTER_MESSAGE:
			view.setVisibleRegister(false);
			break;
		case Constants.MESSAGE_LOGIN_ADMINISTRATOR:
			loginAdministrator();
			break;
		case Constants.MESSAGE_CANCELED_ADMINISTRATOR:
			view.setVisibleEnteroKey(false);
			break;
		case Constants.MESSAGE_ADD_PANELJTABLE:
			view.isVisible(true);
			break;
		case Constants.MESSAGE_ADD_PANELJTABLE_PATIENT:
			view.setPanelAddPatient();
			break;
		case Constants.MESSAGE_ADD_PANELJTABLE_HEALTHPOST:
			view.setPanelHealthPost();
			break;
		case Constants.MESSAGE_ADD_PANELJTABLE_CITY:
			view.setPanelCity();
			break;
		case Constants.MESSAGE_CREATE_CITY:
			createCities();
			break;
		case Constants.MESSAGE_CANCELED_CITY:
			view.clearFieldPanelCity();
			break;
		case Constants.MESSAGE_CREATE_HEALTH_POST:
			createHealthPost();
			break;
		case Constants.MESSAGE_CANCELED_HEALTH_POST:
			view.clearFieldPanelHealthPost();
			break;
		case Constants.MESSAGE_ADD_PATIENT:
			addPatient();
			break;
		case Constants.MESSAGE_CANCELED_PATIENT:
			view.clearFieldPanelPatient();
			break;
		case Constants.MESSAGE_GET_OUT_OF_THE_SYSTEM:
			view.setSlider();
			break;
		case Constants.MESSAGE_REMOVE_PANELJTABLE:
			deletePatient();
			break;
		case Constants.MESSAGE_CONFIRMATION_CLOSE:
			exit();
			break;
		case Constants.MESSAGE_PORCENTAGE:
			getPorcentage();
		
			break;
		default:
			break;
		}

	}


	public synchronized void getPorcentage() {
		try {
			output.writeUTF("getPorcentage");
			String aux = input.readUTF();
			int[] array = new Gson().fromJson(aux, int[].class);
			view.getPorcentage(array);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public synchronized void deletePatient() {
		int row = view.getSelectRowTable();
		if (row >= 0) {
			try {
				DefaultTableModel model = new DefaultTableModel();
				model = getColumns(model);
				output.writeUTF("deletePatient");
				String matrix = input.readUTF();
				Hospital hospital = new Gson().fromJson(matrix, Hospital.class);
				model = getRows(model, hospital.getList());
				String idPatient = String.valueOf(model.getValueAt(row, 4));
				output.writeUTF(idPatient);
				view.removePatient(model, row);
			}catch(ArrayIndexOutOfBoundsException e) {
				view.getMessage(e.getMessage());
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				view.getMessage(e1.getMessage());
			}
		
		} else {
			view.getJOptionShowMessage("Seleccione una fila por favor", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void addPatient() {
		try {
			String idHealthPost = view.getComboBoxHospitalPanelPatient();
			Patient patient = verifyPatient();
			if(patient != null && !idHealthPost.equals("")) {
				output.writeUTF("addPatient");
				output.writeUTF(new Gson().toJson(patient));
				output.writeUTF(idHealthPost);
				boolean option = input.readBoolean();
				if (option) {
					verify();
					view.clearFieldPanelPatient();
					view.getJOptionShowMessage("Agregado Correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
				} else {
					view.getJOptionShowMessage("No se pudo añadir el paciente", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}else {
				//view.getJOptionShowMessage("Llene correctamente los espacios", "Incorrecto", JOptionPane.ERROR_MESSAGE);
			}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (DateTimeParseException e) {
				view.getJOptionShowMessage("Ingrese el formato correcto por favor", "Error", JOptionPane.ERROR_MESSAGE);

			}

		}
	

	private Patient verifyPatient() {
		DocumentType document = view.getTypeDocument(view.getChoiceTypeDocumentPanelPatient());
		String idPatient = view.getTxtIdPanelPatient();
		String firstName = view.getTxtFirstNamePanelPatient();
		String lastName = view.getTxtLastNamePanelPatient();
		String date = view.getTxtDateOfBirthPanelPatient();
		String dateTake = view.getTxtTakeDay();
		boolean isVacuned = view.isVacuned();
		boolean isPositive = view.hadCovid();
		Cormorbidities cormorbidities = view.getCormorbidities();
		if (dateTake.equals("") || idPatient.equals("") || firstName.equals("") || lastName.equals("")
				|| date.equals("") || document == null || cormorbidities == null) {
			view.getJOptionShowMessage("Llene correctamente los espacios", "Incorrecto", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				LocalDate dateOfBirth = LocalDate.parse(date, DateTimeFormatter.ofPattern(Constants.DATE_FORMAT));
				LocalDate takeDay = LocalDate.parse(dateTake, DateTimeFormatter.ofPattern(Constants.DATE_FORMAT));
				Patient patient = new Patient(document, idPatient, firstName, lastName, dateOfBirth, cormorbidities,
						takeDay, isVacuned, isPositive);
				return patient;

			} catch (DateTimeParseException e) {
				view.getJOptionShowMessage("Ingrese el formato correcto por favor", "Error", JOptionPane.ERROR_MESSAGE);

			}
		}
		return null;

	}

	public synchronized void refreshTable() {
		String aux;
		try {
			DefaultTableModel model = new DefaultTableModel();
			model = getColumns(model);
			aux = input.readUTF();
			Hospital hospital = new Gson().fromJson(aux, Hospital.class);
			model = getRows(model, hospital.getList());
			try {
				view.refreshTable(model);
			} catch (NullPointerException e) {
				view.getMessage("Refrescando tabla");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public DefaultTableModel getColumns(DefaultTableModel model) {
		Object[] nameColumns = Constants.HEADERS;
		for (Object object : nameColumns) {
			model.addColumn(object);
		}
		return model;
	}

	public DefaultTableModel getRows(DefaultTableModel model, ArrayList<Object[]> listHealthPost) {
		for (int i = 0; i < listHealthPost.size(); i++) {
			Object[] option = listHealthPost.get(i);
			String cuidad = String.valueOf(option[0]);
			String id = String.valueOf(option[1]);
			String nombre = String.valueOf(option[2]);
			String documento = String.valueOf(option[3]);
			String idpaciente = String.valueOf(option[4]);
			String Nombre = String.valueOf(option[5]);
			String Apellido = String.valueOf(option[6]);
			String fecha = option[7].toString();
			String cormobilidad = String.valueOf(option[8]);
			String toma = option[9].toString();
			String isVacuned = String.valueOf(option[10]);
			String isPositive = String.valueOf(option[11]);
			Object[] result = new Object[] { cuidad, id, nombre, documento, idpaciente, Nombre, Apellido, fecha,
					cormobilidad, toma, isVacuned, isPositive };
			model.addRow(result);

		}
		return model;
	}

	private void createCities() {
		String id = view.getTxtIdPanelCity();
		String name = view.getTxtNamePanelCity();
		try {
			output.writeUTF("createCities");
			if (!id.equals("") && !name.equals("")) {
				City city = new City(id, name);
				output.writeUTF(new Gson().toJson(city));
				boolean option = input.readBoolean();
				if (option) {
					verify();
					view.getJOptionShowMessage("Cuidad Añadida satisfactoriamente", "Correcto",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					view.getJOptionShowMessage("No se pudo añadir la cuidad", "Error", JOptionPane.ERROR_MESSAGE);
					view.setTxtIdPanelCity("");
					view.setTxtNamePanelCity("");
				}
			} else {
				view.getJOptionShowMessage("Llene los espacios", "Incorrecto", JOptionPane.ERROR_MESSAGE);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public synchronized void getNameCities() {
		try {
			output.writeUTF("getNameCities");
			String message = input.readUTF();
			String[] array = new Gson().fromJson(message, String[].class);
			refreshCityList(this.getArrayList(array));
			view.setTxtIdPanelCity("");
			view.setTxtNamePanelCity("");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void refreshCityList(ArrayList<String> listBoxCities) {
		view.initComboBoxCitiesPanelPatient(listBoxCities);
		view.initComboBoxCitiesPanelHealthPost(listBoxCities);
	}

	public void createAdministrator() {
		DocumentType document = view.getTypeDocument(view.getChoice());
		String id = view.getTxtId();
		String firstName = view.getTxtFirstName();
		String lastName = view.getTxtLastName();
		String date = view.getTxtBirthdayDate();
		String userName = view.getTxtUserName();
		String password = view.getTxtPassword();
		try {
			LocalDate birthday = LocalDate.parse(date, DateTimeFormatter.ofPattern(Constants.DATE_FORMAT));
			try {
				output.writeUTF("createAdministrator");
				Administrator administrator = new Administrator(document, id, firstName, lastName, birthday, userName,
						password);
				output.writeUTF(new Gson().toJson(administrator));
				boolean option = input.readBoolean();
				if (option == true) {
					view.getJOptionShowMessage("Se agrego correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
					view.setVisibleRegister(false);
				} else {
					view.getJOptionShowMessage("Incorrecto", "No se pudo añadir", JOptionPane.ERROR_MESSAGE);
				}

			} catch (IOException e1) {
				e1.fillInStackTrace();

			}
		} catch (DateTimeParseException e) {
			view.getJOptionShowMessage("Formato de fecha incorrecto", "No se pudo añadir", JOptionPane.ERROR_MESSAGE);
		}

	}

	public synchronized void loginAdministrator() {
		String email = view.getTxtEmail();
		String password = view.getTxtPasswordPanelEnteroKey();
		try {
			output.writeUTF("loginAdministrator");
			LoginAdministrator login = new LoginAdministrator(email, password);
			output.writeUTF(new Gson().toJson(login));
			boolean option = input.readBoolean();
			if (option) {
				loginAdministratorAux();
			} else {
				view.getJOptionShowMessage("Incorrecto", "Revise su correo y contraseña", JOptionPane.ERROR_MESSAGE);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public  void loginAdministratorAux() {
		try {
			String aux = "";
			view.setVisibleEnteroKey(false);
			aux = input.readUTF();
			//System.out.println("auxiliar " + aux);
			Hospital hospital = new Gson().fromJson(aux, Hospital.class);
			view.setpanelJTable(hospital.getList());
			view.clearFieldsLoginAdministrator();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void createHealthPost() {
		String nameCity = view.getNameCity();
		String idHealthPost = view.getTxtIdHealthPost();
		String nameHealthPost = view.getNameHealthPost();
		try {
			output.writeUTF("createHealthPost");
			if (!nameCity.equals("") && !idHealthPost.equals("") && !nameHealthPost.equals("")) {
				HealthPost healthPost = new HealthPost(idHealthPost, nameHealthPost, nameCity);
				output.writeUTF(new Gson().toJson(healthPost));
				boolean option = input.readBoolean();
				if (option) {
					verify();
					view.clearFieldHealthPost();
					view.getJOptionShowMessage("Hospital agregado Correctamente", "Correcto",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					view.getJOptionShowMessage("No se pudo añadir el Hospital", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				view.getJOptionShowMessage("Llene los espacios", "Incorrecto", JOptionPane.ERROR_MESSAGE);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void refreshComboBoxHospital() {
		String message;
		try {
			message = input.readUTF();
			String[] array = new Gson().fromJson(message, String[].class);
			view.initComboBoxHospitalPanelPatient(getArrayList(array));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public synchronized void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			try {
				output.writeUTF("uploadComboCities");
				String valor = view.getComboBoxCities();
				output.writeUTF(valor);
				String message = input.readUTF();
				String[] array = new Gson().fromJson(message, String[].class);
				refreshHealthPost(getArrayList(array));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public ArrayList<String> getArrayList(String[] array) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		return list;
	}

	public void refreshHealthPost(ArrayList<String> listHealthPost) {
		view.initComboBoxHospitalPanelPatient(listHealthPost);
	}

	public void changeImages() {
		int velocidad = 4 * 1000;
		Timer timer;
		TimerTask tarea;
		tarea = new TimerTask() {
			@Override
			public void run() {
				switch (count) {
				case 0:
					count = 1;
					view.setImage("/Images/tambini.jpg");
					// view.setImage("Images/tambini.jpg");
					view.setLabelDescriptionTittleMessage(
							"<html><p><b>'Necesitamos redoblar la<br>responsabilidad cuidadana:' OPS<b></p></html>");
					view.setLblTextMessage(
							"<html><p>Gina tambini, representante de la OMS<br>hizo un llamado a la cuidadanía para</br><br>fortalecer las medidas de cuidado.</br></p></html>");
					break;
				case 1:
					count = 2;
					view.setImage("/Images/marcela.jpg");
					// view.setImage("Images/marcela.jpg");
					view.setLabelDescriptionTittleMessage(
							"<html><p><b>Fortalecer el cuidado de<br>adultos es evitar el contagio de niños<b></p></html>");
					view.setLblTextMessage(
							"<html><p>La pdta de la sociedad de pediatria<br>afirmó que,en menor escala,</br><br>los niños pueden desarrollar cuadros graves</br></p></html>");
					break;
				case 2:
					count = 3;
					view.setImage("/Images/Chaskel.jpg");
					// view.setImage("Images/Chaskel.jpg");
					view.setLabelDescriptionTittleMessage(
							"<html><p><b>Resilencia clave para la<br>salud mental de niños y adolecentes<b></p></html>");
					view.setLblTextMessage(
							"<html><p>El medico Roberto Chaskel abordó la<br>importancia del cuidado de la salud <br>en los niños</br></br></p></html>");
					break;
				case 3:
					count = 0;
					view.setImage("/Images/ministro.jpg");
					// view.setImage("Images/ministro.jpg");
					view.setLabelDescriptionTittleMessage(
							"<html><p><b>Colombia tendrá más de dos<br>millones de vacunas en los</br>próximos días</br><b></p></html>");
					view.setLblTextMessage(
							"<html><p>El ministerio Fernando Ruiz Gómez detalló<br>que el talento humano en salud ya</br><br>Cuenta con primera dosis en un 95% </br></p></html>");
					break;
				}
			}

		};
		timer = new Timer();
		timer.scheduleAtFixedRate(tarea, velocidad, velocidad);
	}

	public void exit() {
		try {
			output.writeUTF("exit");
			isRunning = false;
			client.close();
			view.dispose();
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void verify() {
		try {
			if (input.available() > 0) {
				String valor = input.readUTF();
				switch (valor) {
				case Constants.MESSAGE_UPDATE_CITY:
					getNameCities();
					break;
				case Constants.MESSAGE_UPDATE_HEALTHPOST:
					refreshComboBoxHospital();
					break;
				case Constants.MESSAGE_UPDATE_PATIENT:
					refreshTable();
					break;
				default:
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		try {
			new Presenter();
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
