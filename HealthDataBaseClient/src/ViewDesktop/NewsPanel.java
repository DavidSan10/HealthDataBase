package ViewDesktop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ToolView.ComboBox;
import constants.Constants;

public class NewsPanel extends JPanel {
	private JLabel lblPromotion;
	private JComboBox<String> comboPromotion;
	private JComboBox<String> comboServiceChannels;
	private JButton btnEnteroKay;
	private JButton btnRegister;
	private JButton btnIncrease;
	private JButton btnDisminish;
	private static final long serialVersionUID = 1L;

	public NewsPanel(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		initComponents(listener);
		this.setBackground(new Color(219, 219, 219));
	}

	private void initComponents(ActionListener listener) {
		GridBagConstraints gbc = new GridBagConstraints();
		lblPromotion = new JLabel("Promocion y Prevencion");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 20, 20);
		this.add(lblPromotion, gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 0;
		fillJComboBox();
		this.add(comboPromotion, gbc);
		fillJComboBoxServiceChannels();
		gbc.gridx = 3;
		gbc.gridy = 0;

		this.add(comboServiceChannels, gbc);
		btnEnteroKay = new JButton("Eventos");
		btnEnteroKay.setForeground(Color.white);
		btnEnteroKay.setBorderPainted(false);
		btnEnteroKay.setBackground(Constants.BLUE_LIGHT);
		btnEnteroKay.setPreferredSize(new Dimension(90, 20));
		btnEnteroKay.addActionListener(listener);
		btnEnteroKay.setActionCommand(Constants.GET_EVENTS_COVID_19);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		this.add(btnEnteroKay, gbc);
		btnRegister = new JButton("Noticias ");
		btnRegister.setForeground(Color.white);
		btnRegister.setBackground(Constants.BLUE_LIGHT);
		btnRegister.addActionListener(listener);
		btnRegister.setActionCommand(Constants.GET_NOTICE_COVID_19);
		btnRegister.setBorderPainted(false);
		btnRegister.setPreferredSize(new Dimension(90, 20));
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(btnRegister, gbc);
		btnIncrease = new JButton("A+");
		btnIncrease.setBackground(new Color(219, 219, 219));
		btnIncrease.setBorder(null);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(btnIncrease, gbc);
		btnDisminish = new JButton("A-");
		btnDisminish.setBackground(new Color(219, 219, 219));
		btnDisminish.setBorder(null);
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(btnDisminish, gbc);

	}

	public void fillJComboBox() {
		comboPromotion = new JComboBox<String>();
		comboPromotion.setBackground(new Color(219, 219, 219));
		comboPromotion.setUI(new ComboBox());
		String[] option = new String[] { "Somos NUEVA EPS", "Qui�nes Somos", "Sedes Administrativas",
				"Estructura Organizacional", "Nuestros Accionistas y Socios", "Sala de Prensa" };
		for (String string : option) {
			comboPromotion.addItem(string);
		}

	}

	public void fillJComboBoxServiceChannels() {
		comboServiceChannels = new JComboBox<String>();
		comboServiceChannels.setBackground(new Color(219, 219, 219));
		comboServiceChannels.setUI(new ComboBox());
		String[] option = new String[] { "Canales de servicio", "Presenciales", "No Presenciales" };
		for (String string : option) {
			comboServiceChannels.addItem(string);
		}

	}

	public JButton getBtnEnteroKay() {
		return btnEnteroKay;
	}

}
