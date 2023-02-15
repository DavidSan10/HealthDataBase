package ViewDesktop;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class JDialogGraphicsCakeDiagram extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelGraficsMenuCakeDiagram panelCakeDiagram;
	private CakeDiagramPanel cakeDiagramPanel;
	private ActionListener listener;
	
	public JDialogGraphicsCakeDiagram(JFrame frame,ArrayList<String> listBoxCities,ArrayList<String> listHealthPost,ItemListener itemListener,ActionListener listener) {
		super(frame,"Diagrama de pastel",true);
		initComponents(listBoxCities,listHealthPost,itemListener,listener);
		this.setSize(620, 380);
		this.setVisible(false);
	}

	private void initComponents(ArrayList<String> listBoxCities, ArrayList<String> listHealthPost,
		ItemListener itemListener, ActionListener listener) {
		this.listener = listener;
		panelCakeDiagram = new PanelGraficsMenuCakeDiagram(listBoxCities,listHealthPost,itemListener,listener);
		this.add(panelCakeDiagram);	
	}
	
	public void isVisible(boolean isVisible) {
		this.setVisible(isVisible);
	}
	
	public String getComboBoxCity() {
		return panelCakeDiagram.getComboBoxCity();
	}
	
	public String getComboBoxHealthPost() {
		return panelCakeDiagram.getComboBoxHealthPost();
	}
	
	public void initComboBoxHospital(ArrayList<String> listNameHospital) {
		panelCakeDiagram.initComboBoxHospital(listNameHospital);
	}

	public void isVisiblePanelGrafics(boolean option) {
		panelCakeDiagram.setVisible(option);
	}
	
	public void getCakePanelGraphics(int[] grades,int[] porcentage,String[] namesCitites,String nameCity,String nameHospital) {
		cakeDiagramPanel = new CakeDiagramPanel(listener,grades,porcentage,namesCitites,nameCity,nameHospital);
		this.add(cakeDiagramPanel);
	}
	
	public void isPanelCakeDiagramPanel() {
		cakeDiagramPanel.setVisible(false);
	}
	

}
