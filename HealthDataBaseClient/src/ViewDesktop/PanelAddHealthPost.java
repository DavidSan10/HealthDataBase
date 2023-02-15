package ViewDesktop;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants;


public class PanelAddHealthPost extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblId;
	private JTextField txtId;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblJComboBox;
	private JComboBox<String> comboBoxCity;
	private JButton btnAdd;
	private JButton btnExit;
	
	
	public PanelAddHealthPost(ArrayList<String> listBoxCities,ActionListener listener) {
		this.setLayout(new GridLayout(4,1));
		initComponents(listBoxCities,listener);
	}

	private void initComponents(ArrayList<String> listBoxCities,ActionListener listener) {
		lblId = new JLabel("Ingrese la id del hospital:");
		this.add(lblId);
		txtId = new JTextField();
		this.add(txtId);
		
		lblName = new JLabel("Ingrese el nombre del hospital:");
		this.add(lblName);
		txtName = new JTextField();
		this.add(txtName);
		
		lblJComboBox = new JLabel("Elija la cuidad");
		this.add(lblJComboBox);
		comboBoxCity = new JComboBox(listBoxCities.toArray( ) );
		this.add(comboBoxCity);
		
		btnAdd = new JButton("Añadir");
		btnAdd.addActionListener(listener);
		btnAdd.setActionCommand(Constants.MESSAGE_CREATE_HEALTH_POST);
		this.add(btnAdd);
		
		btnExit = new JButton("Cancelar");
		btnExit.addActionListener(listener);	
		btnExit.setActionCommand(Constants.MESSAGE_CANCELED_HEALTH_POST);
		this.add(btnExit);
		
		
	}
	
	
	public void initComboBoxCity(ArrayList<String> listBoxCities) {
		comboBoxCity.removeAllItems();
		for (int i = 0; i < listBoxCities.size(); i++) {
			comboBoxCity.addItem(listBoxCities.get(i));
		}
	}
	
	public void clearField() {
		setTxtId("");
		setTxtName("");
	}

	public String getTxtId() {
		return txtId.getText();
	}

	public void setTxtId(String text) {
		this.txtId.setText(text);
	}

	public String getTxtName() {
		return txtName.getText();
	}

	public void setTxtName(String text) {
		this.txtName.setText(text);
	}

	public String getComboBoxCity() {
		return String.valueOf(comboBoxCity.getSelectedItem());
	}
	
}
