package ViewDesktop;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class PanelButton extends JPanel{
	
	private InitPanel initPanel;
	private NewsPanel NewsPanel;
	
	private static final long serialVersionUID = 1L;

	public PanelButton(ActionListener listener) {
		this.setLayout(new GridLayout(1,2));
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		NewsPanel = new NewsPanel(listener);
		this.add(NewsPanel);
		initPanel = new InitPanel(listener);
		this.add(initPanel);
		
	}

	
}
