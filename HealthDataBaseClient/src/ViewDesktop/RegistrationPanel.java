package ViewDesktop;

import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ToolView.*;
import constants.Constants;
import myEnum.DocumentType;;

public class RegistrationPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel lblTypeDocument;
	private Choice choiceTypeDocument;
	private JLabel lblId;
	private JTextField txtId;
	private JLabel lblFirstName;
	private JTextField txtFirstName;
	private JLabel lblLastName;
	private JTextField txtLastName;
	private JLabel lblBirthdayDate;
	private JTextField txtBirthdayDate;
	private JLabel lblUserName;
	private JTextField txtUserName;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private TextPrompt placeholder; 
	private JButton btnAdd;
	private JButton btnExit;
	
	
	public RegistrationPanel(ActionListener listener) {
		setLayout(new GridLayout(8,1));
		initComponents(listener);
	}


	private void initComponents(ActionListener listener) {
		lblTypeDocument = new JLabel("Elija su tipo de documento: ");
		this.add(lblTypeDocument);
		initChoice();
		this.add(choiceTypeDocument);
		lblId = new JLabel("Escriba su identificacion: ");
		this.add(lblId);
		txtId = new JTextField();
		this.add(txtId);
		lblFirstName = new JLabel("Escriba sus nombres: ");
		this.add(lblFirstName);
		txtFirstName = new JTextField();
		this.add(txtFirstName);
		lblLastName = new JLabel("Escriba sus apellidos: ");
		this.add(lblLastName);
		txtLastName = new JTextField();
		this.add(txtLastName);
		lblBirthdayDate = new JLabel("Su fecha de cumpleaños: ");
		this.add(lblBirthdayDate);
		txtBirthdayDate = new JTextField();
		placeholder = new TextPrompt("formato dd-mm-yyyy",txtBirthdayDate);
		this.add(txtBirthdayDate);
		lblUserName = new JLabel("Escriba su email: ");
		this.add(lblUserName);
		txtUserName = new JTextField();
		this.add(txtUserName);
		lblPassword = new JLabel("Escriba su contraseña");
		this.add(lblPassword);
		txtPassword = new JPasswordField();
		this.add(txtPassword);
		btnAdd = new JButton("Registrarse");
		btnAdd.addActionListener(listener);
		btnAdd.setActionCommand(Constants.ACCEPT_PANEL_REGISTER_MESSAGE);
		this.add(btnAdd);
		btnExit = new JButton("Cancelar");
		btnExit.addActionListener(listener);
		btnExit.setActionCommand(Constants.CANCELED_PANEL_REGISTER_MESSAGE);
		this.add(btnExit);
	}
	
	public void initChoice() {
		DocumentType[] arrayDocumentTypes = DocumentType.values();
		choiceTypeDocument = new Choice();
		for (DocumentType documentType : arrayDocumentTypes) {
			choiceTypeDocument.add(documentType.getName());
		}
	}
	
	
	public String getChoice() {
		return choiceTypeDocument.getSelectedItem();
	}
	
	
	public String getTxtId() {
		return txtId.getText();
	}


	public void setTxtId(String text) {
		this.txtId.setText(text);
	}


	public String getTxtFirstName() {
		return txtFirstName.getText();
	}


	public void setTxtFirstName(String text) {
		this.txtFirstName.setText(text);;
	}


	public String getTxtLastName() {
		return txtLastName.getText();
	}


	public void setTxtLastName(String text) {
		this.txtLastName.setText(text);;
	}


	public String getTxtBirthdayDate() {
		return txtBirthdayDate.getText();
	}


	public void setTxtBirthdayDate(String text) {
		this.txtBirthdayDate.setText(text);;
	}

	public String getTxtUserName() {
		return txtUserName.getText();
	}

	public void setTxtUserName(String text) {
		this.txtUserName.setText(text);;
	}


	public String getTxtPassword() {
		return String.valueOf(txtPassword.getPassword());
	}


	public void setTxtPassword(String text) {
		this.txtPassword.setText(text);;
	}

	
}
