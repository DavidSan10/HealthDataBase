package ViewDesktop;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import constants.Constants;



public class BarChartPanel extends JPanel{

	private JLabel lblTextInitial;
	private JButton btnExit;
	private int[] listVaccinationByCity;
	private String[] namesCitites;
	private int[] porcentage;
	private static final long serialVersionUID = 1L;
	
	public BarChartPanel(ActionListener listener,int[] vaccinationsByCity,String[] namesCitites,String nameCity,String nameHospital) {
		this.listVaccinationByCity = vaccinationsByCity;
		this.namesCitites = namesCitites;
		this.setLayout(new BorderLayout());
		initComponents(listener,nameCity,nameHospital);
	}

	private void initComponents(ActionListener listener,String nameCity,String nameHospital) {
		lblTextInitial = new JLabel("Diagrama de barras de  " + nameHospital + " \n   " + nameCity);
		lblTextInitial.setFont(new Font("Yu Gothic UI SemiLIGHT",Font.PLAIN,20));
		add(lblTextInitial,BorderLayout.NORTH);
		btnExit = new JButton("Volver al menu");
		btnExit.addActionListener(listener);
		btnExit.setActionCommand(Constants.MESSAGE_RETURN_TO_GRAPHICS_PANEL);
		add(btnExit,BorderLayout.SOUTH);
		
	}
	
	public int getMaximumNumber() {
		int result = 0;
		for (int i = 0; i < listVaccinationByCity.length; i++) {
			if(listVaccinationByCity[i] > result) {
				result = listVaccinationByCity[i];
			}
		}
		return result;
	}
	
	
	public int getTotal() {
		int result = 0;
		for (int i = 0; i < listVaccinationByCity.length; i++) {
			result += listVaccinationByCity[i];
		}
		return result;
		
	}
	
	public int getRange() {
		int maxNumberWithPorcentage = (int) (getMaximumNumber());
		if(maxNumberWithPorcentage % 5 == 0) {
			return maxNumberWithPorcentage;
		}else {
			maxNumberWithPorcentage+=1;
		}
		return maxNumberWithPorcentage;
	}
	
	public int getRandom() {
		return (int) (Math.random() * 253 + 1);
	}

	public Color[] getColors(int length) {
		Color[] colors = new Color[length];
		for (int i = 0; i < colors.length; i++) {
			int number1 = getRandom();
			int number2 = getRandom();
			int number3 = getRandom();
			colors[i] = new Color(number1, number2, number3);
		}
		return colors;
	}
	
	
	public void getMessageError() {
		JOptionPane.showMessageDialog(this, "No hay datos ","error",JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void setVisible() {
		this.setVisible(false);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int maximumNumber = getMaximumNumber();
		Graphics2D g2d = (Graphics2D) g;
		if(maximumNumber > 0) {
			int count = 60;
			int countNames = 80;
			int auxNames = 60;
			//int range = getRange();
			Color[] colors = getColors(listVaccinationByCity.length);
			g2d.setStroke(new BasicStroke(3));
			g2d.drawLine(100, 300, 500, 300);
			g2d.drawLine(100, 300, 100, 50);
			g2d.setColor(Color.LIGHT_GRAY);
			g2d.setStroke(new BasicStroke(1));
			g2d.drawLine(100, 250, 500, 250);
			g2d.drawLine(100, 200, 500, 200);
			g2d.drawLine(100, 150, 500, 150);
			g2d.drawLine(100, 100, 500, 100);
			g2d.drawLine(100, 50, 500, 50);
			g2d.setColor(Color.BLACK);
			g2d.drawString(String.valueOf(0), 100, 320);
			for (int i = 0; i < listVaccinationByCity.length; i++) {
				int largo = listVaccinationByCity[i]*400/getTotal();
				g2d.setColor(colors[i]);
				g2d.fillRect(100, count, largo, 20);
				g2d.drawString(namesCitites[i], 60, countNames);
				g2d.fillRect(515, auxNames, 15, 15);
				g2d.drawString(String.valueOf(listVaccinationByCity[i]),530, auxNames+10);
				count+= 20;
				countNames+= 20;
				auxNames += 20;
			
			}
		}else {
			g2d.setFont(new Font("TimesRoman", Font.BOLD, 30)); 
			g2d.drawString("No hay datos disponibles", 50, 100);
		
		}
		
	}
	
	
	

}
