package ViewDesktop;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Render extends DefaultTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelect,boolean hasFocus,int row,int column) {
		if(value instanceof JButton) {
			JButton btn = (JButton)value;
			return btn;
		}
		if((row % 2) == 0) {
			this.setBackground(Color.WHITE);
		}else {
			this.setBackground(Color.LIGHT_GRAY);
		}
		return super.getTableCellRendererComponent(table, value, isSelect, hasFocus, row, column);
	}
	

}
