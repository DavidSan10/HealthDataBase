package ViewDesktop;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class JDialogGraphics extends JDialog{


	private static final long serialVersionUID = 1L;
	private PanelGraficsMenu panelGrafics;
	private BarChartPanel barPanelGraphics;
	private ActionListener listener;
	
	public JDialogGraphics(JFrame frame,ArrayList<String> listBoxCities,ArrayList<String> listHealthPost,ItemListener itemListener,ActionListener listener) {
		super(frame,"Diagrama de barras",true);
		initComponents(listBoxCities,listHealthPost,itemListener,listener);
		this.setSize(620, 380);
		this.setVisible(false);
	}

	private void initComponents(ArrayList<String> listBoxCities,ArrayList<String> listHealthPost,ItemListener itemListener,ActionListener listener) {
		this.listener = listener;
		panelGrafics = new PanelGraficsMenu(listBoxCities,listHealthPost,itemListener,listener);
		this.add(panelGrafics);		
	}
	
	public void isVisible(boolean isVisible) {
		this.setVisible(isVisible);
	}
	
	public String getComboBoxCity() {
		return panelGrafics.getComboBoxCity();
	}
	
	public String getComboBoxHealthPost() {
		return panelGrafics.getComboBoxHealthPost();
	}
	
	public void initComboBoxHospital(ArrayList<String> listNameHospital) {
		panelGrafics.initComboBoxHospital(listNameHospital);
	}

	public void isVisiblePanelGrafics(boolean option) {
		panelGrafics.setVisible(option);
	}
	
	
	public void getBarPanelGraphics(int[] vaccinationsByCity,String[] namesCitites,String nameCity,String nameHospital) {
		barPanelGraphics = new BarChartPanel(listener,vaccinationsByCity,namesCitites,nameCity,nameHospital);
		this.add(barPanelGraphics);
	}
	
	public void setVisible() {
		barPanelGraphics.setVisible(false);
	}
	
}
