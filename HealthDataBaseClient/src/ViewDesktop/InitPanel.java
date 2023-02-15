package ViewDesktop;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import constants.Constants;

public class InitPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton enterButton;
	private JButton registryButton;
	private JButton btnSafeExit;
	
	
	public InitPanel(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.LIGHT_GRAY);
		initComponents(listener);
	}


	private void initComponents(ActionListener listener) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		enterButton = new JButton("Ingresar");
		enterButton.addActionListener(listener);
		enterButton.setActionCommand(Constants.LOGIN_MESSAGE);
		modifyButton(enterButton);
		this.add(enterButton,gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		registryButton = new JButton("Registrar");
		registryButton.addActionListener(listener);
		registryButton.setActionCommand(Constants.MESSAGE_REGISTER);
		modifyButton(registryButton);
		this.add(registryButton,gbc);
		btnSafeExit = new JButton("Salir");
		gbc.gridx = 2;
		gbc.gridy = 0;
		btnSafeExit.addActionListener(listener);
		btnSafeExit.setActionCommand(Constants.MESSAGE_CONFIRMATION_CLOSE);
		modifyButton(btnSafeExit);
		this.add(btnSafeExit,gbc);
		
		
		
	}
	
	

	public void modifyButton(JButton button) {
		//button.setBorder(null);
		button.setBackground(Color.LIGHT_GRAY);
	}
	
	
	

}
