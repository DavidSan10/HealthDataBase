package ViewDesktop;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants;

public class PanelAddCity extends JPanel{
	
	private JLabel lblId;
	private JTextField txtId;
	private JLabel lblName;
	private JTextField txtName;
	private JButton btnAdd;
	private JButton canceledButton;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public PanelAddCity(ActionListener listener) {
		this.setLayout(new GridLayout(3,1));
		initComponents(listener);
	}


	private void initComponents(ActionListener listener) {
		lblId = new JLabel("Ingrese el id de la cuidad:");
		this.add(lblId);
		txtId = new JTextField();
		this.add(txtId);
		
		lblName = new JLabel("Ingrese el nombre de la cuidad:");
		this.add(lblName);
		txtName = new JTextField();
		this.add(txtName);
		
		btnAdd = new JButton("Añadir");
		btnAdd.addActionListener(listener);
		btnAdd.setActionCommand(Constants.MESSAGE_CREATE_CITY);
		this.add(btnAdd);
		canceledButton = new JButton("Cancelar");
		canceledButton.addActionListener(listener);
		canceledButton.setActionCommand(Constants.MESSAGE_CANCELED_CITY);
		this.add(canceledButton);
		
	}


	public String getTxtId() {
		return txtId.getText();
	}


	public void setTxtId(String text) {
		this.txtId.setText(text);;
	}


	public String getTxtName() {
		return txtName.getText();
	}


	public void setTxtName(String text) {
		this.txtName.setText(text);;
	}
	
	public void clearField() {
		setTxtId("");
		setTxtName("");
	}
	

}
