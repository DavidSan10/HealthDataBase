package ViewDesktop;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ToolView.ToolView;

public class Slider extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel lblImages;
	private ToolView tool;

	
	
	public Slider(int option) {
		tool = new ToolView();
		initComponents(option);
	}
	



	private void initComponents(int option) {
		switch (option) {
		case 0:
			initComponentsViewDesktop();
			break;
		case 1:
			initComponentsViewMovil();
			break;
		default:
			break;
		}
		
	}

	private void initComponentsViewDesktop() {
		lblImages = new JLabel();
		lblImages.setSize(740, 350);
		ImageIcon logo = new ImageIcon(getClass().getResource("/Images/ministro.jpg"));
		//ImageIcon logo = new ImageIcon(getClass().getResource("/HealthDataBaseClient/Images/ministro.jpg"));
		Image escala = logo.getImage().getScaledInstance(lblImages.getWidth(), lblImages.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(escala); 
		lblImages.setIcon(imageIcon);
		this.add(lblImages);
		
	}

	private void initComponentsViewMovil() {
		lblImages = new JLabel();
		lblImages.setSize(700, 280);
		//ImageIcon logo = new ImageIcon(getClass().getResource("/Images/ministro.jpg"));
		ImageIcon logo = new ImageIcon(getClass().getResource("Images/ministro.jpg"));
		Image escala = logo.getImage().getScaledInstance(lblImages.getWidth(), lblImages.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(escala); 
		lblImages.setIcon(imageIcon);
		this.add(lblImages);
		
	}
	
	public void setImage(String url) {
		tool.intializedJLabel(lblImages, url);
	}
	
	
	
//	
//	public String[] getImages(File carpeta) {
//		String[] images = new String[carpeta.list().length];
//		int count = 0;
//	    for (File ficheroEntrada : carpeta.listFiles()) {
//	        if (ficheroEntrada.isDirectory()) {
//	        	getImages(ficheroEntrada);
//	        } else {
//	        	images[count] = ficheroEntrada.getPath();
//	            System.out.println(ficheroEntrada.getPath());
//	        }
//	    }
//	    return images;
//	}


	
//	public static void main(String[] args) {
//		Slider s = new Slider(new File("Images_Banner"));
//		//s.getFiles();
//	}
}
