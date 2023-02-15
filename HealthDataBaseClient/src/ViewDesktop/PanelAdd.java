package ViewDesktop;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import constants.Constants;


public class PanelAdd extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	private JButton button1 ; 
	private JButton button2;
	private JButton button3;
	
	public  PanelAdd(ActionListener listener) {
		this.setLayout(new GridLayout(3,1));
		this.setBackground(Color.LIGHT_GRAY);
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		button1 = new JButton("Agregar Paciente");
		button1.setBackground(Color.LIGHT_GRAY);
		button1.setBorder(null);
		button1.addActionListener(listener);
		button1.setActionCommand(Constants.MESSAGE_ADD_PANELJTABLE_PATIENT);
		this.add(button1);
		button2 = new JButton("Agregar Hospital");
		button2.setBackground(Color.LIGHT_GRAY);
		button2.setBorder(null);
		button2.addActionListener(listener);
		button2.setActionCommand(Constants.MESSAGE_ADD_PANELJTABLE_HEALTHPOST);
		this.add(button2);
		button3 = new JButton("Agregar Cuidad");
		button3.setBackground(Color.LIGHT_GRAY);
		button3.setBorder(null);
		button3.addActionListener(listener);
		button3.setActionCommand(Constants.MESSAGE_ADD_PANELJTABLE_CITY);
		this.add(button3);		
	}
	
}
