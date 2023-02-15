package ViewDesktop;


import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ToolView.ToolView;
import constants.Constants;


public class Banner extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton button;
	private ToolView tool;
	
	
	
	
	public Banner(ActionListener listener) {
		tool = new ToolView();
		initComponents(listener);
	}




	private void initComponents(ActionListener listener) {
		button = new JButton();
		button.setBorder(null);
		button.setSize(1082, 220);
		button.addActionListener(listener);
		button.setActionCommand(Constants.GET_MESSAGE_INFORMATION_COVID);
		tool.initializedJButtonComplete(button,"/Images/banner.jpg");
		this.add(button);	
	}
	
	
	
	
	

}
