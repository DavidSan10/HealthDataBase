package ToolView;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ToolView {

	public void initializedJButtonComplete(JButton btn,String url) {
		ImageIcon logo = new ImageIcon(getClass().getResource(url));
		Image escala  = logo.getImage().getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(escala); 
		btn.setIcon(imageIcon);
	}
	
	public void intializedJLabel(JLabel lbl,String url) {
		ImageIcon logo = new ImageIcon((getClass().getResource(url)));
		Image escala = logo.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon imageIcon = new ImageIcon(escala);
		lbl.setIcon(imageIcon);
	}
	
	public void initializedJButtonCut(JButton btn,String url) {
		ImageIcon logo = new ImageIcon(getClass().getResource(url));
		Image escala  = logo.getImage().getScaledInstance(30, 65, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(escala); 
		btn.setIcon(imageIcon);
	}
	public void initializedJButtonCut2(JButton btn,String url) {
		ImageIcon logo = new ImageIcon(getClass().getResource(url));
		Image escala  = logo.getImage().getScaledInstance(30, 45, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(escala); 
		btn.setIcon(imageIcon);
	}
	
}
