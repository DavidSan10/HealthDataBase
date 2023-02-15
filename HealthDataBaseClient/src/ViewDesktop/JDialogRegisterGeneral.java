package ViewDesktop;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class JDialogRegisterGeneral extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private PanelAddPatient panelAddPatient;
	private PanelAdd panelAdd;
	private PanelAddHealthPost panelAddHealthPost;
	private PanelAddCity panelAddCity;

	
	public JDialogRegisterGeneral(JFrame frame,ArrayList<String> listBoxCities,ArrayList<String> listNameHospital,ActionListener listener,ItemListener itemListener) {
		super(frame,"Registro de datos",true);
		this.setLayout(new BorderLayout());
		initComponents(listBoxCities,listNameHospital,listener,itemListener);
		this.setSize(600, 370);
		this.setVisible(false);
	}

	private void initComponents(ArrayList<String> listBoxCities,ArrayList<String> listNameHospital,ActionListener listener,ItemListener itemListener) {
		panelAdd = new PanelAdd(listener);
		this.add(panelAdd,BorderLayout.WEST);
		panelAddPatient = new PanelAddPatient(listBoxCities,listNameHospital,listener,itemListener);
		this.add(panelAddPatient,BorderLayout.CENTER);
		panelAddHealthPost = new PanelAddHealthPost(listBoxCities,listener);
		panelAddCity = new PanelAddCity(listener);
	}
	
	public String getComboBoxCities() {
		return panelAddPatient.getComboBoxCities();
	}

	public String getComboBoxHospital() {
		return panelAddPatient.getComboBoxHospital();
	}
	
	public void isVisible(boolean option) {
		this.setVisible(option);
	}
	
	public void setPanelAddPatient() {
		panelAddPatient.setVisible(true);
		panelAddHealthPost.setVisible(false);
		panelAddCity.setVisible(false);
		this.add(panelAddPatient,BorderLayout.CENTER);
	}
	
	public void setPanelHealthPost() {
		panelAddHealthPost.setVisible(true);
		panelAddPatient.setVisible(false);
		panelAddCity.setVisible(false);
		this.add(panelAddHealthPost,BorderLayout.CENTER);
	}
	
	public void setPanelCity() {
		panelAddCity.setVisible(true);
		panelAddPatient.setVisible(false);
		panelAddHealthPost.setVisible(false);
		this.add(panelAddCity,BorderLayout.CENTER);
	}
	
	
	/*
	 * 
	 * Get y Set del panel de cuidad
	 * */
	

	public String getTxtId() {
		return panelAddCity.getTxtId();
	}


	public void setTxtId(String text) {
		panelAddCity.setTxtId(text);;
	}


	public String getTxtName() {
		return panelAddCity.getTxtName();
	}


	public void setTxtName(String text) {
		panelAddCity.setTxtName(text);;
	}
	
	/*
	 * 
	 * Obtener JComboBox 
	 * */
	
	
	public void initComboBoxCitiesPanelPatient(ArrayList<String> listBoxCities) {
		panelAddPatient.initComboBoxCities(listBoxCities);
	}
	
	public void initComboBoxCitiesPanelHealthPost(ArrayList<String> listBoxCities) {
		panelAddHealthPost.initComboBoxCity(listBoxCities);
	}
	
	
	public void initComboBoxHospitalPanelPatient(ArrayList<String> listNameHospital) {
		panelAddPatient.initComboBoxHospital(listNameHospital);
	}
	
	
	public void clearFieldPanelCity() {
		panelAddCity.clearField();
	}
	
	public void clearFieldPanelHealthPost() {
		panelAddHealthPost.clearField();
	}
	
	public void clearFieldPanelPatient() {
		panelAddPatient.clearField();
	}
	
	/*
	 * Panel HealthPost
	 * 
	 * */
	
	public String getTxtIdHealthPost() {
		return panelAddHealthPost.getTxtId();
	}

	public String getNameHealthPost() {
		return panelAddHealthPost.getTxtName();
	}

	public String getNameCity() {
		return panelAddHealthPost.getComboBoxCity();
	}
	
	
	public String getChoiceTypeDocumentPanelPatient() {
		return  panelAddPatient.getChoiceTypeDocument();
	}
	
	public String getComboBoxHospitalPanelPatient() {
		return panelAddPatient.getComboBoxHospital();
	}

	
	public String getTxtIdPanelPatient() {
		return panelAddPatient.getTxtId();
	}

	public String getTxtFirstName() {
		return panelAddPatient.getTxtFirstName();
	}
	
	public String getTxtLastName() {
		return panelAddPatient.getTxtLastName();
	}
	
	public String getTxtDateOfBirth() {
		return panelAddPatient.getTxtDateOfBirth();
	}
	
	public String getComboBoxComorbilidities() {
		return panelAddPatient.getComboBoxComorbilidities();
	}
	
	public String getTxtTakeDay() {
		return panelAddPatient.getTxtTakeDay();
	}
	
	public boolean isVacuned() {
		return panelAddPatient.isVacuned();
	}
	
	public boolean hadCovid() {
		return panelAddPatient.hadCovid();
	}
	
	
	public void clearFieldHealthPost() {
		panelAddHealthPost.clearField();
	}
	


	
}
