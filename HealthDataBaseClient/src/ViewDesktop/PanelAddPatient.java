package ViewDesktop;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ToolView.TextPrompt;
import constants.Constants;
import myEnum.Cormorbidities;
import myEnum.DocumentType;

public class PanelAddPatient extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel lblComboBoxCities;
	private JComboBox<String> comboBoxCities;
	private JLabel lblComboBoxHospital;
	private JComboBox<String> comboBoxHospital;
	private JLabel lblChoiceTypeDocument;
	private JComboBox<String> comboBoxTypeDocument;
	private JLabel lblId;
	private JTextField txtId;
	private JLabel lblFirstName;
	private JTextField txtFirstName;
	private JLabel lblLastName;
	private JTextField txtLastName;
	private JLabel lblDateOfBirth;
	private JTextField txtDateOfBirth;
	private JLabel lblcomboBoxComorbilidities;
	private JComboBox<String> comboBoxComorbilidities;
	private JLabel lblTakeDay;
	private JTextField txtTakeDay;
	private JLabel lblIsVacuned;
	private JLabel lblHadCovid;
	private ButtonGroup groupRadio;
	private ButtonGroup groupRadioHadCovid;
	private JRadioButton checkAffirmativeVacuned;
	private JRadioButton checkNegativeVacuned;
	private JRadioButton checkAffirmativeHadCovid;
	private JRadioButton checkNegativeHadCovid;
	private JButton btnAdd;
	private JButton btnExit;
	private TextPrompt placeholder;
	
	public PanelAddPatient(ArrayList<String> listBoxCities,ArrayList<String> listNameHospital,ActionListener listener, ItemListener itemListener) {
		this.setLayout(new GridLayout(12,1));
		initComponents(listBoxCities,listNameHospital,listener,itemListener);
	}


	private void initComponents(ArrayList<String> listBoxCities,ArrayList<String> listNameHospital,ActionListener listener, ItemListener itemListener) {
		lblComboBoxCities = new JLabel("Elija la cuidad: ");
		this.add(lblComboBoxCities);
		
		comboBoxCities = new JComboBox(listBoxCities.toArray());
		comboBoxCities.addItemListener(itemListener);
		//initComboBoxCities(listBoxCities);
		this.add(comboBoxCities);
		
		
		lblComboBoxHospital = new JLabel("Elija el hospital: ");
		this.add(lblComboBoxHospital);
		comboBoxHospital = new JComboBox(listNameHospital.toArray());
		//initComboBoxHospital(listNameHospital);
		this.add(comboBoxHospital);
		
		
		lblChoiceTypeDocument = new JLabel("Elija su tipo de documento: ");
		this.add(lblChoiceTypeDocument);
	
		initComboBoxDocumentType();
		this.add(comboBoxTypeDocument);
		
		
		
		lblId = new JLabel("Ingrese su id");
		this.add(lblId);
		txtId = new JTextField();
		this.add(txtId);
		
		
		lblFirstName = new JLabel("Ingrese sus nombres: ");
		this.add(lblFirstName);
		txtFirstName = new JTextField();
		this.add(txtFirstName);
		
		
		lblLastName = new JLabel("Ingrese sus apellidos: ");
		this.add(lblLastName);
		txtLastName = new JTextField();
		this.add(txtLastName);
		
		lblDateOfBirth = new JLabel("Ingrese su fecha de nacimiento: ");
	
		this.add(lblDateOfBirth);
		txtDateOfBirth = new JTextField();
		placeholder = new TextPrompt("formato dd-mm-yyyy",txtDateOfBirth);
		this.add(txtDateOfBirth);
		
		
		lblcomboBoxComorbilidities = new JLabel("Elija comorbilidad: ");
		this.add(lblcomboBoxComorbilidities);
		
		initComboBoxCormobilities();
		this.add(comboBoxComorbilidities);
		
		
		lblTakeDay = new JLabel("Fecha de toma: ");
		this.add(lblTakeDay);
		txtTakeDay = new JTextField();
		placeholder = new TextPrompt("formato dd-mm-yyyy",txtTakeDay);
		this.add(txtTakeDay);
		
		
		lblIsVacuned = new JLabel("¿Esta vacunado?");
		this.add(lblIsVacuned);
		
		initializedJRadioButtonMenuItem();
		JPanel panelAux = new JPanel();
		panelAux.add(checkAffirmativeVacuned);
		panelAux.add(checkNegativeVacuned);
		this.add(panelAux);

		lblHadCovid = new JLabel("Ha tenido Covid");
		this.add(lblHadCovid);
		
		
		initializedJRadioButtonMenuItemHadCovid();
		JPanel panelAuxHadCovid = new JPanel();
		panelAuxHadCovid.add(checkAffirmativeHadCovid);
		panelAuxHadCovid.add(checkNegativeHadCovid);
		this.add(panelAuxHadCovid);
		
		
		btnAdd = new JButton("Añadir");
		btnAdd.addActionListener(listener);
		btnAdd.setActionCommand(Constants.MESSAGE_ADD_PATIENT);
		this.add(btnAdd);
		
		btnExit = new JButton("Cancelar");
		btnExit.addActionListener(listener);
		btnExit.setActionCommand(Constants.MESSAGE_CANCELED_PATIENT);
		this.add(btnExit);
		
	}
	
	
	
	
	
	
	public void initComboBoxCities(ArrayList<String> listBoxCities) {
		comboBoxCities.removeAllItems();
		for (int i = 0; i < listBoxCities.size(); i++) {
			comboBoxCities.addItem(listBoxCities.get(i));
		}

	}
	
	
	public void initComboBoxHospital(ArrayList<String> listNameHospital) {
		comboBoxHospital.removeAllItems();
		for (int i = 0; i < listNameHospital.size(); i++) {
			comboBoxHospital.addItem(listNameHospital.get(i));
		}
	}
	
	public void initComboBoxDocumentType() {
		comboBoxTypeDocument = new JComboBox<String>();
		DocumentType[] arrayDocumentTypes = DocumentType.values();
		for (DocumentType documentType : arrayDocumentTypes) {
			comboBoxTypeDocument.addItem(documentType.getName());
		}
	}	
	
	
	public void initComboBoxCormobilities() {
		comboBoxComorbilidities = new JComboBox<String>();
		Cormorbidities[] arrayDocumentTypes = Cormorbidities.values();
		for (Cormorbidities cormorbidities : arrayDocumentTypes) {
			comboBoxComorbilidities.addItem(cormorbidities.getName());
		}
	}	
	
	public void initializedJRadioButtonMenuItem() {
		checkAffirmativeVacuned = new JRadioButton("Si");
		checkNegativeVacuned = new JRadioButton("No");
		groupRadio = new ButtonGroup();
		groupRadio.add(checkAffirmativeVacuned);
		groupRadio.add(checkNegativeVacuned);
	}
	
	
	
	public void initializedJRadioButtonMenuItemHadCovid() {
		checkAffirmativeHadCovid = new JRadioButton("Si");
		checkNegativeHadCovid = new JRadioButton("No");
		groupRadioHadCovid = new ButtonGroup();
		groupRadioHadCovid.add(checkAffirmativeHadCovid);
		groupRadioHadCovid.add(checkNegativeHadCovid);
	}
	
	
	
	/*
	 * Metodos para obtener los datos
	 * */
	
	public String getComboBoxCities() {
		return String.valueOf(comboBoxCities.getSelectedItem());
	}

	public String getComboBoxHospital() {
		System.out.println("Hospital: "+String.valueOf(comboBoxHospital.getSelectedItem()));
		return String.valueOf(comboBoxHospital.getSelectedItem());
	}

	public String getChoiceTypeDocument() {
		return String.valueOf(comboBoxTypeDocument.getSelectedItem());
	}
	
	public String getTxtId() {
		return txtId.getText();
	}

	public void setTxtId(String text) {
		txtId.setText(text);;
	}

	public String getTxtFirstName() {
		return txtFirstName.getText();
	}

	public void setTxtFirstName(String text) {
		this.txtFirstName.setText(text);
	}

	public String getTxtLastName() {
		return txtLastName.getText();
	}

	public void setTxtLastName(String text) {
		this.txtLastName.setText(text);
	}

	public String getTxtDateOfBirth() {
		return txtDateOfBirth.getText();
	}

	public void setTxtDateOfBirth(String text) {
		this.txtDateOfBirth.setText(text);;
	}

	public String getComboBoxComorbilidities() {
		return String.valueOf(comboBoxComorbilidities.getSelectedItem());
	}
	
	public void clearField() {
		setTxtId("");
		setTxtFirstName("");
		setTxtLastName("");
		setTxtDateOfBirth("");
		setTextTakeDay("");
		
	}
	
	
	public String getTxtTakeDay() {
		return txtTakeDay.getText();
	}
	
	public void setTextTakeDay(String text) {
		txtTakeDay.setText(text);
	}
	
	public boolean isVacuned() {
		boolean result = false;
		if(checkAffirmativeVacuned.isSelected()) {
			result = true;
		}else if(checkNegativeVacuned.isSelected()) {
			result = false;
		}
		return result;
	}
	
	public boolean hadCovid() {
		boolean result = false;
		if(checkAffirmativeHadCovid.isSelected()) {
			result = true;
		}else if(checkNegativeHadCovid.isSelected()) {
			result = false;
		}
		return result;
	}
	

	
//	
//	public JComboBox<String> getComboBoxCity() {
//		return comboBoxCities;
//	}
		
}
