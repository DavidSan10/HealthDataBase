package ViewDesktop;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.Constants;

public class PanelGraficsMenu extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel lblTittle;
	private JLabel lblDescription;
	private JButton btnPatientVacunedForCity;
	private JButton btnPatientPositiveCasesbyAge;
	private JButton btnTestTakenPerMonth;
	private JButton btnCormobidities;
	private JButton btnDocumentType;
	private JLabel lblComboBoxCity;
	private JLabel lblComboBoxHealthPost;
	private JComboBox<String> comboBoxCity;
	private JComboBox<String> comboBoxHospital;
	
	
	public PanelGraficsMenu(ArrayList<String> listBoxCities,ArrayList<String> listHealthPost,ItemListener itemListener,ActionListener listener) {
		this.setLayout(new GridBagLayout());
		initComponents(listBoxCities,listHealthPost,itemListener,listener);
	}


	private void initComponents(ArrayList<String> listBoxCities,ArrayList<String> listHealthPost,ItemListener itemListener,ActionListener listener) {
		GridBagConstraints gbc = new GridBagConstraints();
		lblTittle = new JLabel("Graficos de Barras" );
		lblTittle.setFont(new Font("Tahoma", Font.BOLD, 25));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(0,0,15,0);
		this.add(lblTittle,gbc);
		lblDescription = new JLabel("Los determinados graficos tienen que ser elegidos por una cuidad y un determinado hospital ");
		lblDescription.setForeground(Color.DARK_GRAY);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(lblDescription,gbc);
		lblComboBoxCity = new JLabel("Cuidad");
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(lblComboBoxCity,gbc);
		comboBoxCity = new JComboBox<String>();
		initComboBoxCity(listBoxCities);
		comboBoxCity.addItemListener(itemListener);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(comboBoxCity,gbc);
		lblComboBoxHealthPost = new JLabel("Hospital");
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(lblComboBoxHealthPost,gbc);
		comboBoxHospital = new JComboBox<String>();
		initComboBoxHospital(listHealthPost);
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(comboBoxHospital,gbc);
		btnPatientVacunedForCity = new JButton("Hospital de una cuidad");
		gbc.gridx = 0;
		gbc.gridy = 4;
		btnPatientVacunedForCity.addActionListener(listener);
		btnPatientVacunedForCity.setActionCommand( Constants.MESSAGE_SHOW_GRAPICHS_BAR_PATIENT_VACUNED_FOR_CITY);
		this.add(btnPatientVacunedForCity,gbc);
		btnPatientPositiveCasesbyAge = new JButton("Por edad");
		gbc.gridx = 1;
		gbc.gridy = 4;
		btnPatientPositiveCasesbyAge.addActionListener(listener);
		btnPatientPositiveCasesbyAge.setActionCommand( Constants.MESSAGE_SHOW_GRAPICHS_BAR_PATIENT_POSITIVE);
		this.add(btnPatientPositiveCasesbyAge,gbc);
		btnTestTakenPerMonth = new JButton("Por mes");
		gbc.gridx = 2;
		gbc.gridy = 4;
		btnTestTakenPerMonth.addActionListener(listener);
		btnTestTakenPerMonth.setActionCommand( Constants.MESSAGE_SHOW_GRAPICHS_BAR_PATIENT_TEST_TAKE_PER_MONTH);
		this.add(btnTestTakenPerMonth,gbc);
		btnDocumentType = new JButton("Por Tipo de documento");
		gbc.gridx = 3;
		gbc.gridy = 4;
		btnDocumentType.addActionListener(listener);
		btnDocumentType.setActionCommand(Constants.MESSAGE_SHOW_GRAPICHS_BAR_FOR_DOCUMENT_TYPE);
		this.add(btnDocumentType,gbc);
		btnCormobidities = new JButton("Cormobilidades");
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		btnCormobidities.addActionListener(listener);
		btnCormobidities.setActionCommand(Constants.MESSAGE_SHOW_GRAPICHS_BAR_PATIENT_FOR_CORMOBIDITIES);
		this.add(btnCormobidities,gbc);
	}
	
	
	public void initComboBoxCity(ArrayList<String> listBoxCities) {
		comboBoxCity.removeAllItems();
		for (int i = 0; i < listBoxCities.size(); i++) {
			comboBoxCity.addItem(listBoxCities.get(i));
		}
	}

	public void initComboBoxHospital(ArrayList<String> listNameHospital) {
		comboBoxHospital.removeAllItems();
		for (int i = 0; i < listNameHospital.size(); i++) {
			comboBoxHospital.addItem(listNameHospital.get(i));
		}
	}

	public String getComboBoxCity() {
		return String.valueOf(comboBoxCity.getSelectedItem());
	}
	
	public String getComboBoxHealthPost() {
		return String.valueOf(comboBoxHospital.getSelectedItem());
	}
	
}
