package ViewDesktop;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JDialogPorcentageFinal extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblPositive;
	private JTextField txtPositive;
	private JLabel lblNegative;
	private JTextField txtNegative;
	
	
	public JDialogPorcentageFinal(JFrame frame,int[] array) {
		super(frame,"Porcentage por vacunados",true);
		this.setLayout(new FlowLayout());
		initComponents(array);
		this.setSize(300, 100);
		this.setVisible(true);
	}


	private void initComponents(int array[]) {
		lblPositive = new JLabel("Si");
		this.add(lblPositive);
		txtPositive = new JTextField(array[0] + "%");
		this.add(txtPositive);
		lblNegative = new JLabel("No");
		this.add(lblNegative);
		txtNegative = new JTextField(array[1] + "%");
		this.add(txtNegative);
	}

	
	
	

}
