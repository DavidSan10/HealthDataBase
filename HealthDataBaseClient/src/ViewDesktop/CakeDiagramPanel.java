package ViewDesktop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import constants.Constants;


public class CakeDiagramPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel lblTextInitial;
	private JButton btnExit;
	private int[] gradesVar;
	private int[] porcentage;
	private int countGlobal;
	private int auxGlobal;
	private String[] namesCities;

	public CakeDiagramPanel(ActionListener listener, int[] grades,int[] porcentage,String[] nameCities,String nameCity,String nameHealthPost) {
		this.gradesVar = grades;
		this.namesCities = nameCities;
		this.porcentage = porcentage;
		this.setLayout(new BorderLayout());
		initComponents(listener,nameCity,nameHealthPost);
	}

	private void initComponents(ActionListener listener,String nameCity,String nameHealthPost) {
		lblTextInitial = new JLabel("Diagrama de pastel");
		lblTextInitial.setFont(new Font("Yu Gothic UI SemiLIGHT", Font.PLAIN, 20));
		add(lblTextInitial, BorderLayout.NORTH);
		btnExit = new JButton("Volver al menu");
		btnExit.addActionListener(listener);
		btnExit.setActionCommand(Constants.MESSAGE_RETURN_TO_GRAPHICS_PANEL_CAKE);
		add(btnExit, BorderLayout.SOUTH);
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
	
	public int sumTotal(int[] porcentage) {
		int total = 0;
		for (int i = 0; i < porcentage.length; i++) {
			total+= porcentage[i];
		}
		return total;
		
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int count = 0;
		int aux = 50;
		Color[] colors = getColors(gradesVar.length);
		for (int i = 0; i < gradesVar.length; i++) {
			g.setColor(Color.BLACK);
			g.drawString(namesCities[i], 350, aux +10);
			g.drawString(porcentage[i]+ "%", 400, aux+10);
			g.setColor(colors[i]);
			g.fillRect(330, aux, 15, 15);
			g.fillArc(50, 50, 200, 200, count, gradesVar[i]);
			count += gradesVar[i];
			aux+= 20;
			countGlobal = count;
			auxGlobal = aux;
		}if(countGlobal < 360) {
			g.setColor(Color.BLACK);
			g.drawString("Datos perdidos",350, auxGlobal + 10);
			g.drawString(100-sumTotal(porcentage)+ "%", 440, auxGlobal + 10);
			g.setColor(Color.WHITE);
			g.fillRect(330, auxGlobal, 15, 15);
			g.fillArc(50, 50, 200, 200, countGlobal, 360-countGlobal);
		}

	}

}
