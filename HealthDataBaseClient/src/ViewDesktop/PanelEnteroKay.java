package ViewDesktop;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import constants.Constants;

public class PanelEnteroKay extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton enterButton;
	private JButton canceledButton;;
	private JLabel lbEmail;
	private JTextField txtEmail;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	
	
	public PanelEnteroKay(ActionListener listener) {
		this.setLayout(new GridLayout(4,1));
		initComponents(listener);
	}


	private void initComponents(ActionListener listener) {
		lbEmail = new JLabel("Ingrese su email: ");
		this.add(lbEmail);
		txtEmail = new JTextField();
		this.add(txtEmail);
		
		lblPassword = new JLabel("Ingrese su contraseña: ");
		this.add(lblPassword);
		txtPassword = new JPasswordField();
		this.add(txtPassword);
		
		
		enterButton = new JButton("Ingresar");
		enterButton.addActionListener(listener);
		enterButton.setActionCommand(Constants.MESSAGE_LOGIN_ADMINISTRATOR);
		this.add(enterButton);
		
		canceledButton = new JButton("Cancelar");
		canceledButton.addActionListener(listener);
		canceledButton.setActionCommand(Constants.MESSAGE_CANCELED_ADMINISTRATOR);
		this.add(canceledButton);
	
	}


	public String getTxtEmail() {
		return txtEmail.getText();
	}


	public void setTxtEmail(String txtEmail) {
		this.txtEmail.setText(txtEmail);
	}


	public String getTxtPassword() {
		return String.valueOf(txtPassword.getPassword());
	}


	public void setTxtPassword(String txtPassword) {
		this.txtPassword.setText(txtPassword);;
	}
	
	

}
