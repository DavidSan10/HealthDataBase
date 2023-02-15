package ViewDesktop;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JDialogEnteroKey extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelEnteroKay panelEnteroKey;
	private JLabel lblTittle;
	
	
	public JDialogEnteroKey(JFrame frame,ActionListener listener) {
		super(frame,"Ingrese administrador",true);
		this.setLayout(new GridBagLayout());
		this.setLocationRelativeTo(frame);
		this.setSize(400,280);
		this.setLocationRelativeTo(this);
		initComponents(listener);
		this.setVisible(false);
	}


	private void initComponents(ActionListener listener) {
		GridBagConstraints gbc = new GridBagConstraints();
		lblTittle = new JLabel("Ingrese Administrador");
		lblTittle.setFont(new Font("Tahoma", Font.BOLD, 15));
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(lblTittle,gbc);
		panelEnteroKey = new PanelEnteroKay(listener);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(panelEnteroKey,gbc);	
	}
	

	public String getTxtEmail() {
		return panelEnteroKey.getTxtEmail();
	}


	public void setTxtEmail(String txtEmail) {
		this.panelEnteroKey.setTxtEmail(txtEmail);
	}


	public String getTxtPassword() {
		return panelEnteroKey.getTxtPassword();
	}


	public void setTxtPassword(String txtPassword) {
		this.panelEnteroKey.setTxtPassword(txtPassword);;
	}
	
	
	public void clearFieldsLoginAdministrator() {
		setTxtEmail(""); 
		setTxtPassword("");
	}
	
}
