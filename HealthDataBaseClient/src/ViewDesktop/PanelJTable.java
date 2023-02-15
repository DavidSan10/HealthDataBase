package ViewDesktop;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import constants.Constants;

public class PanelJTable extends JPanel{

	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnExit;
	private JButton	insertButton;
	private JButton	deleteButton;
	private JButton buttonBar;
	private JButton buttonPorcentage;
	private JScrollPane scroll;
	private JPanel panelAux;
	private JPanel panelAuxButton;
	private JLabel tittleWelcome; 
	
	

	
	public PanelJTable(ArrayList<Object[]> listCity,ActionListener listener,int option) {
		this.setLayout(new GridBagLayout());
		switch (option) {
		case 0:
			initComponentsDesktop(listCity,listener);
			break;
		case 1:
			break;
		default:
			break;
		}
			
	}

	private void initComponentsDesktop(ArrayList<Object[]> listCity, ActionListener listener) {
		GridBagConstraints gbc = new GridBagConstraints();
		tittleWelcome = new JLabel("Bienvenido al sistema");
		tittleWelcome.setFont(new Font("Tahoma", Font.BOLD, 25));
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(tittleWelcome, gbc);
		table = new JTable(initJTable(listCity));
		table.setDefaultRenderer(Object.class, new Render());
		table.setPreferredScrollableViewportSize(new Dimension(1100, 300));
		table.setFillsViewportHeight(true);
		scroll = new JScrollPane(table);
		scroll.setVisible(true);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(scroll, gbc);
		panelAux = new JPanel();
		insertButton = new JButton("Insertar");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 40, 0, 0);
		insertButton.addActionListener(listener);
		insertButton.setActionCommand(Constants.MESSAGE_ADD_PANELJTABLE);
		panelAux.add(insertButton, gbc);
		deleteButton = new JButton("Eliminar");
		gbc.gridx = 1;
		gbc.gridy = 0;
		deleteButton.addActionListener(listener);
		deleteButton.setActionCommand(Constants.MESSAGE_REMOVE_PANELJTABLE);
		panelAux.add(deleteButton, gbc);
		buttonBar = new JButton("Salida segura");
		gbc.gridx = 2;
		gbc.gridy = 0;
		buttonBar.addActionListener(listener);
		buttonBar.setActionCommand(Constants.MESSAGE_CONFIRMATION_CLOSE);
		panelAux.add(buttonBar, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 0, 0, 0);
		this.add(panelAux, gbc);
		panelAuxButton = new JPanel();
		btnExit = new JButton("volver al menu del sistema");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		// gbc.gridwidth = 2;
		btnExit.addActionListener(listener);
		btnExit.setActionCommand(Constants.MESSAGE_GET_OUT_OF_THE_SYSTEM);
		panelAuxButton.add(btnExit, gbc);
		
		buttonPorcentage = new JButton("Obtener porcentage");
		buttonPorcentage.addActionListener(listener);
		buttonPorcentage.setActionCommand(Constants.MESSAGE_PORCENTAGE);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panelAuxButton.add(buttonPorcentage, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(panelAuxButton, gbc);

	}
	
	
	

	public DefaultTableModel initJTable(ArrayList<Object[]> listCity) {
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row,int columns) {
				boolean[] options = new boolean[]{true,true,true,true,true,true,true,true,true,true,true,true,true,true};
				return options[columns];
			}
		};
		Object[] nameColumns = Constants.HEADERS;
		getColumns(model,nameColumns);
		getRows(model,listCity);
		return model;
	}
	
	private void getColumns(DefaultTableModel model,Object[] nameColumns) {
		for (Object object : nameColumns) {
			model.addColumn(object);
		}
	}
	
	private void getRows(DefaultTableModel model,ArrayList<Object[]> listHealthPost) {
		for (int i = 0; i < listHealthPost.size(); i++) {
			Object[] option = listHealthPost.get(i);
			String cuidad = String.valueOf(option[0]);
			String id = String.valueOf(option[1]);
			String nombre = String.valueOf(option[2]);
			String documento = String.valueOf(option[3]);
			String idpaciente = String.valueOf(option[4]);
			String Nombre = String.valueOf(option[5]);
			String Apellido = String.valueOf(option[6]);
			String fecha = String.valueOf(option[7]);
			String cormobilidad = String.valueOf(option[8]);
			String toma = option[9].toString();
			String isVacuned = String.valueOf(option[10]);
			String isPositive = String.valueOf(option[11]);
			Object[] result = new Object[] {cuidad,id,nombre,documento,idpaciente,Nombre,Apellido,fecha,cormobilidad,toma,isVacuned,isPositive};
			model.addRow(result);
		}
		
		
	
	}

	
	public void refreshTable(DefaultTableModel model) {
		table.setModel(model);
	}
	
	
	public void removePatient(DefaultTableModel model,int row) {
		model.removeRow(row);
		table.setModel(model);
	}
	
	
	public int getSelectRowTable() {
		return table.getSelectedRow();
	}
	
	
	
}
