package ViewDesktop;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelSliderCombination extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Slider slider;
	private SliderDescription sliderDescription;
	
	
	public PanelSliderCombination(int typeView) {
		this.setLayout(new GridBagLayout());
		initComponents(typeView);
	}


	private void initComponents(int typeView) {
		GridBagConstraints gbc = new GridBagConstraints();
		slider = new Slider(typeView);
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(slider,gbc);
		sliderDescription = new SliderDescription(typeView);
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(sliderDescription,gbc);
	}
	
	public void setImage(String url) {
		slider.setImage(url);
	}
	
	
	public void setLabelDescriptionTittleMessage(String tittle) {
		sliderDescription.setLabelDescriptionTittleMessage(tittle);
	}

	public void setLblTextMessage(String text) {
		sliderDescription.setLblTextMessage(text);
	}
	

}
