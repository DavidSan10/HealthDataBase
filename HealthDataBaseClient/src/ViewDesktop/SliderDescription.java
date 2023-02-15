package ViewDesktop;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.Constants;


public class SliderDescription extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel labelDescriptionTittle;
	private JLabel lblText;
	public SliderDescription(int typeView) {
		this.setLayout(new GridBagLayout());
		this.setBackground(Constants.BLUE_LIGHT_TWO);
		initComponents(typeView);
	}
	
	private void initComponents(int option) {
		switch (option) {
		case 0:
			initComponentsViewDesktop();
			break;
		case 1:
			initComponentsViewMovil();
			break;
		default:
			break;
		}
			
		}

	private void initComponentsViewDesktop() {
		this.setPreferredSize (new Dimension (350, 350));
		GridBagConstraints gbc = new GridBagConstraints();
		labelDescriptionTittle = new JLabel();
		gbc.gridx = 0;
		gbc.gridy = 0;
		labelDescriptionTittle.setFont(new Font("arial",Font.PLAIN,25));
		labelDescriptionTittle.setText("<html><p><b>Colombia tendrá más de <br>dos millones de vacunas en los</br>próximos días</br><b></p></html>");
		labelDescriptionTittle.setForeground(Constants.BLUE_LIGHT);
		labelDescriptionTittle.setPreferredSize(new Dimension(300,150));
		labelDescriptionTittle.setHorizontalTextPosition (JLabel.RIGHT);
		labelDescriptionTittle.setVerticalTextPosition (JLabel.TOP);
		this.add(labelDescriptionTittle,gbc);
		lblText = new JLabel();
		lblText.setFont(new Font("arial",Font.PLAIN,15));
		lblText.setText("<html><p>El ministerio Fernando Ruiz Gómez detalló<br>que el talento humano en salud ya</br><br>Cuenta con primera dosis en un 95% </br></p></html>");
		lblText.setPreferredSize(new Dimension(300,150));
		lblText.setHorizontalTextPosition (JLabel.RIGHT);
		lblText.setVerticalTextPosition (JLabel.TOP);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(lblText,gbc);
	}
	
	private void initComponentsViewMovil() {
		this.setPreferredSize (new Dimension (250, 150));
		GridBagConstraints gbc = new GridBagConstraints();
		labelDescriptionTittle = new JLabel();
		labelDescriptionTittle.setPreferredSize(new Dimension(250,50));
		labelDescriptionTittle.setText("<html>Colombia tendrá mas de dos <br>millones de vacunas en los</br><br>proximos dias</br></html> ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		labelDescriptionTittle.setFont(new Font("arial",Font.BOLD,15));
		labelDescriptionTittle.setVerticalTextPosition (JLabel.TOP);
		labelDescriptionTittle.setForeground(Constants.BLUE_LIGHT);
		this.add(labelDescriptionTittle,gbc);
		lblText = new JLabel();
		lblText.setPreferredSize(new Dimension(250,50));
		lblText.setFont(new Font("arial",Font.PLAIN,10));
		lblText.setText("<html>El ministerio Fernando Ruiz Gómez detalló<br>que el talento humano en salud ya</br><br>Cuenta con primera dosis en un 95% </br></html>");
		lblText.setHorizontalTextPosition (JLabel.LEFT);
		lblText.setVerticalTextPosition (JLabel.TOP);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(lblText,gbc);
	}

	public void setLabelDescriptionTittleMessage(String tittle) {
		this.labelDescriptionTittle.setText(tittle);
	}

	public void setLblTextMessage(String text) {
		this.lblText.setText(text);
	}

}
