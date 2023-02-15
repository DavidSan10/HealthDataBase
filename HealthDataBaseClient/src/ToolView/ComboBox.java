package ToolView;

import java.awt.Color;
import java.awt.Component;


import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.basic.BasicComboBoxUI;

//import constants.Constants;

public class ComboBox extends BasicComboBoxUI {

	
	
	
	

	
	@Override
	public ListCellRenderer<Object> createRenderer() {
		return new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (isSelected) {
					list.setSelectionBackground(Color.LIGHT_GRAY);
				} else {
					list.setSelectionBackground(Color.white);
					list.setForeground(Color.BLACK);
				}
				return this;
			}
		};

	}

}
