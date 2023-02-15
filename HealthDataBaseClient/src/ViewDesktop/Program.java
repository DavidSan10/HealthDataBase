package ViewDesktop;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Program extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelButton panelButton;
	private PanelSliderCombination panelSlider;
	private JPanel panelAux;
	private PanelJTable table;
	private int typeView;

	public Program(ActionListener listener,int typeView) {
		initComponents(listener, typeView);
	}
	
	

	public void initComponents(ActionListener listener,int typeView) {
		initPanelAux(listener,typeView);
	}
	
	
	
	public void initPanelAux(ActionListener listener,int typeView) {
		this.typeView = typeView;
		panelAux = new JPanel();
		panelAux.setLayout(new BoxLayout(panelAux,BoxLayout.Y_AXIS));
		panelButton = new PanelButton(listener);
		panelAux.add(panelButton);
		panelSlider = new PanelSliderCombination(typeView);
		panelAux.add(panelSlider);
		this.add(panelAux);
		
	}
	
	public void initPanelAuxJTable(ArrayList<Object[]> listCity,ActionListener listener) {
		panelAux = new JPanel();
		table = new PanelJTable(listCity,listener,typeView);
		panelAux.add(table);
		this.add(panelAux);	
	}
	
	
	public void panelAuxDispose() {
		panelAux.setVisible(false);
	}
	
	public void setImage(String url) {
		panelSlider.setImage(url);
	}
	
	public void setLabelDescriptionTittleMessage(String tittle) {
		panelSlider.setLabelDescriptionTittleMessage(tittle);
	}

	public void setLblTextMessage(String text) {
		panelSlider.setLblTextMessage(text);
	}
	
	public void initJTable(ArrayList<Object[]> listCity) {
		table.initJTable(listCity);
	}

	public void refreshTable(DefaultTableModel model) {
		table.refreshTable(model);
	}	
	
	public void removePatient(DefaultTableModel model,int row) {
		table.removePatient(model, row);
	}
	
	
	public int getSelectRowTable() {
		return table.getSelectRowTable();
	}
	
	
	
	
}
