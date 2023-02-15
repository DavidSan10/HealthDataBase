package ViewDesktop;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JDialogRegisterAministrator extends JDialog{

	private static final long serialVersionUID = 1L;

	private RegistrationPanel registrationPanel;
	private JLabel lblTittle;
	
	
	public JDialogRegisterAministrator(JFrame frame,ActionListener listener) {
		super(frame,"Registrar administrador",true);
		this.setLayout(new GridBagLayout());
		this.setSize(400,280);
		this.setLocationRelativeTo(this);
		initComponents(listener);
		this.setVisible(false);
	}


	private void initComponents(ActionListener listener) {
		GridBagConstraints gbc = new GridBagConstraints();
		lblTittle = new JLabel("Registrese Administrador");
		lblTittle.setFont(new Font("Tahoma", Font.BOLD, 15));
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(lblTittle,gbc);
		registrationPanel = new RegistrationPanel(listener);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(registrationPanel,gbc);	
	}
	

	public String getChoice() {
		return registrationPanel.getChoice();
	}
	
	
	public String getTxtId() {
		return registrationPanel.getTxtId();
	}


	public void setTxtId(String text) {
		registrationPanel.setTxtId(text);
	}


	public String getTxtFirstName() {
		return registrationPanel.getTxtFirstName();
	}


	public void setTxtFirstName(String text) {
		registrationPanel.setTxtFirstName(text);;
	}


	public String getTxtLastName() {
		return registrationPanel.getTxtLastName();
	}


	public void setTxtLastName(String text) {
		registrationPanel.setTxtLastName(text);;
	}


	public String getTxtBirthdayDate() {
		return registrationPanel.getTxtBirthdayDate();
	}


	public void setTxtBirthdayDate(String text) {
		registrationPanel.setTxtBirthdayDate(text);;
	}


	public String getTxtUserName() {
		return registrationPanel.getTxtUserName();
	}


	public void setTxtUserName(String text) {
		registrationPanel.setTxtUserName(text);
	}
	
	public String getTxtPassword() {
		return registrationPanel.getTxtPassword();
	}


	public void setTxtPassword(String text) {
		registrationPanel.setTxtPassword(text);
	}
	
	
}
