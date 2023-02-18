package ViewDesktop;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import myEnum.Cormorbidities;
import myEnum.DocumentType;

;

public class DesktopView extends  JFrame{

	private static final long serialVersionUID = 1L;
	private ActionListener listener;
	private JDialogRegisterAministrator popupRegister;
	private JDialogEnteroKey popupEnterokey;
	private Banner banner;
	private JDialogRegisterGeneral popupGeneral;
	private Program program;
	private JDialogPorcentageFinal porcentage;
	private JDialogGraphics popupGraphics;
	private JDialogGraphicsCakeDiagram popupGraphicsCakeDiagram;
	private ItemListener itemListener; 
	private int typeView;

	public DesktopView(ActionListener listener,ItemListener itemListener,ArrayList<String> listBoxCities,ArrayList<String> listNameHospital,int typeView) {
		super("Vista escritorio");
		this.listener = listener;
		this.setLayout(new BorderLayout());
		this.setSize(1130, 800);
		this.setIconImage(new ImageIcon(getClass().getResource("/Images/logo.png")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents(this,listener,itemListener,listBoxCities,listNameHospital,typeView);
		this.setLocationRelativeTo(null);		
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void initComponents(JFrame frame,ActionListener listener,ItemListener itemListener,ArrayList<String> listBoxCities,ArrayList<String> listNameHospital,int typeView) {
		this.itemListener = itemListener;
		popupRegister = new JDialogRegisterAministrator(frame,listener);
		popupEnterokey = new JDialogEnteroKey(frame,listener);
		banner = new Banner(listener);
		this.add(banner,BorderLayout.NORTH);
		program = new Program(listener,typeView);
		this.add(program,BorderLayout.CENTER);
		popupGeneral = new JDialogRegisterGeneral(frame,listBoxCities,listNameHospital,listener,itemListener);
		popupGraphics = new JDialogGraphics(frame,listBoxCities,listNameHospital,itemListener,listener);
		popupGraphicsCakeDiagram = new JDialogGraphicsCakeDiagram(frame,listBoxCities,listNameHospital,itemListener,listener);
	}
	
	public void exit() {
		this.dispose();
	}
	
	

	public void setpanelJTable(ArrayList<Object[]> listCity) {
		program.panelAuxDispose();
		program.initPanelAuxJTable(listCity,listener);	
	}
	
	public void setSlider() {
		program.panelAuxDispose();
		program.initPanelAux(listener,typeView);
	}
	
	
	
	public void initJTable(ArrayList<Object[]> listCity) {
		program.initJTable(listCity);
	}
	
	
	public void setVisibleEnteroKey(boolean isVisible) {
		popupEnterokey.setVisible(isVisible);
	}

	public void setVisibleRegister(boolean isVisible) {
		popupRegister.setVisible(isVisible);
		cleanLogPanel();
	}
	
	
	public void setImage(String url) {
		program.setImage(url);
	}
	
	
	public void setLabelDescriptionTittleMessage(String tittle) {
		program.setLabelDescriptionTittleMessage(tittle);
	}

	public void setLblTextMessage(String text) {
		program.setLblTextMessage(text);
	}
	
	
	public void showRegistrationPanel() {
		program.panelAuxDispose();
	}
	
	public String getChoice() {
		return popupRegister.getChoice();
	}
	
	
	public String getTxtId() {
		return popupRegister.getTxtId();
	}


	public void setTxtId(String text) {
		popupRegister.setTxtId(text);
	}


	public String getTxtFirstName() {
		return popupRegister.getTxtFirstName();
	}


	public void setTxtFirstName(String text) {
		popupRegister.setTxtFirstName(text);;
	}


	public String getTxtLastName() {
		return popupRegister.getTxtLastName();
	}


	public void setTxtLastName(String text) {
		popupRegister.setTxtLastName(text);;
	}


	public String getTxtBirthdayDate() {
		return popupRegister.getTxtBirthdayDate();
	}


	public void setTxtBirthdayDate(String text) {
		popupRegister.setTxtBirthdayDate(text);;
	}


	public String getTxtUserName() {
		return popupRegister.getTxtUserName();
	}


	public void setTxtUserName(String text) {
		this.popupRegister.setTxtUserName(text);
	}
	
	
	public String getTxtPassword() {
		return popupRegister.getTxtPassword();
	}


	public void setTxtPassword(String text) {
		popupRegister.setTxtPassword(text);
	}
	
	
	public DocumentType getTypeDocument(String option) {
		DocumentType aux = null;
		while (aux == null) {
			switch (option) {
			case "Cedula de Ciudadania":
				aux = DocumentType.CITIZENSHIP_CARD;
				break;
			case "Cedula de Extranjeria":
				aux = DocumentType.IMMIGRATION_CARD;
				break;
			case "Tarjeta de identidad":
				aux = DocumentType.IDENTITY_CARD;
				break;
			case "Pasaporte":
				aux = DocumentType.PASSPORT;
				break;
			default:
				System.err.println();
				break;
			}
			
		}
		return aux;
	}
	
	
	public void getJOptionShowMessage(String message,String title,int typeJOptionPane) {
		JOptionPane.showMessageDialog(null, message,title,typeJOptionPane);
	}
	
	
	public void cleanLogPanel() {
		setTxtId("");
		setTxtFirstName("");
		setTxtLastName("");
		setTxtBirthdayDate("");
		setTxtUserName("");
		setTxtPassword("");
	}
	
	
	
	/*
	 * panelEnterokey
	 * */

	
	public String getTxtEmail() {
		return popupEnterokey.getTxtEmail();
	}


	public void setTxtEmail(String txtEmail) {
		popupEnterokey.setTxtEmail(txtEmail);
	}


	public String getTxtPasswordPanelEnteroKey() {
		return popupEnterokey.getTxtPassword();
	}


	public void setTxtPasswordPanelEnteroKey(String txtPassword) {
		this.popupEnterokey.setTxtPassword(txtPassword);;
	}

	/*
	 * 
	 * 
	 * */
	
	public String getComboBoxCities() {
		return popupGeneral.getComboBoxCities();
	}
	

	public String getComboBoxHospital() {
		return popupGeneral.getComboBoxHospital();
	}
	
	public void isVisible(boolean option) {
		popupGeneral.setVisible(option);
	}
	
	public void setPanelAddPatient() {
		popupGeneral.setPanelAddPatient();
	}
	
	public void setPanelHealthPost() {
		popupGeneral.setPanelHealthPost();
	}
	
	public void setPanelCity() {
		popupGeneral.setPanelCity();
	}
	
//	public String getTxtIdPanelCity() {
//		return popupGeneral.getTxtId();
//	}
//
//
//	public void setTxtIdPanelCity(String text) {
//		popupGeneral.setTxtId(text);;
//	}


	public String getTxtNamePanelCity() {
		return popupGeneral.getTxtName();
	}


	public void setTxtNamePanelCity(String text) {
		popupGeneral.setTxtName(text);;
	}
	
	/*
	 * ComboBox 
	 * */
	
	public void initComboBoxCitiesPanelPatient(ArrayList<String> listBoxCities) {
		popupGeneral.initComboBoxCitiesPanelPatient(listBoxCities);
	}
	
	public void initComboBoxCitiesPanelHealthPost(ArrayList<String> listBoxCities) {
		popupGeneral.initComboBoxCitiesPanelHealthPost(listBoxCities);
	}
	
	public void initComboBoxHospitalPanelPatient(ArrayList<String> listNameHospital) {
		popupGeneral.initComboBoxHospitalPanelPatient(listNameHospital);
	}

	public void clearFieldPanelCity() {
		popupGeneral.clearFieldPanelCity();
	}
	
	public void clearFieldPanelHealthPost() {
		popupGeneral.clearFieldPanelHealthPost() ;
	}
	
	public void clearFieldPanelPatient() {
		popupGeneral.clearFieldPanelPatient();
	}
	
//
//	public String getTxtIdHealthPost() {
//		return popupGeneral.getTxtIdHealthPost();
//	}

	public String getNameHealthPost() {
		return popupGeneral.getNameHealthPost();
	}
	
	public String getNameCity() {
		return popupGeneral.getNameCity();
	}
	
	public String getChoiceTypeDocumentPanelPatient() {
		return  popupGeneral.getChoiceTypeDocumentPanelPatient();
	}
	
	public String getComboBoxHospitalPanelPatient() {
		return popupGeneral.getComboBoxHospitalPanelPatient();
	}

	
	public String getTxtIdPanelPatient() {
		return popupGeneral.getTxtIdPanelPatient();
	}

	public String getTxtFirstNamePanelPatient() {
		return popupGeneral.getTxtFirstName();
	}
	
	public String getTxtLastNamePanelPatient() {
		return popupGeneral.getTxtLastName();
	}
	
	public String getTxtDateOfBirthPanelPatient() {
		return popupGeneral.getTxtDateOfBirth();
	}
	
	public String getComboBoxComorbiliditiesPanelPatient() {
		return popupGeneral.getComboBoxComorbilidities();
	}
	
	
	public Cormorbidities getCormorbidities() {
		Cormorbidities aux = null;
		while (aux == null) {
			String option =  getComboBoxComorbiliditiesPanelPatient();
			switch (option) {
			case "Cardiovascular":
				aux = Cormorbidities.CARDIOVASCULAR;
				break;
			case "Muscular":
				aux = Cormorbidities.MUSCULAR;
				break;
			case "Mental":
				aux = Cormorbidities.MENTAL;
				break;
			case "Oseo":
				aux = Cormorbidities.OSSEOUS;
				break;
			case "Nervioso":
				aux = Cormorbidities.NERVOUS;
				break;
			case "Respiratorio":
				aux = Cormorbidities.RESPIRATORY;
				break;
			case "Digestivo":
				aux = Cormorbidities.DIGESTIVE;
				break;
			case "No registra":
				aux = Cormorbidities.NOT_REGISTER;
				break;
			default:
				break;
			}
			
		}
		return aux;
	}
	
	public String getTxtTakeDay() {
		return popupGeneral.getTxtTakeDay();
	}
	
	public boolean isVacuned() {
		return popupGeneral.isVacuned();
	}
	
	public boolean hadCovid() {
		return popupGeneral.hadCovid();
	}
	

	public void refreshTable(DefaultTableModel model) {
		program.refreshTable(model);
	}	

	public void isVisiblePopUpGrapichs(boolean isVisible) {
		popupGraphics.isVisible(isVisible);
	}
	
	public String getComboBoxCityGrafics() {
		return popupGraphics.getComboBoxCity();
	}
	
	public String getComboBoxHealthPostGraphics() {
		return popupGraphics.getComboBoxHealthPost();
	}
	
	public void initComboBoxHospital(ArrayList<String> listNameHospital) {
		popupGraphics.initComboBoxHospital(listNameHospital);
	}
	
	public void clearFieldsLoginAdministrator() {
		popupEnterokey.clearFieldsLoginAdministrator();
	}
	
	public void isVisiblePanelGrafics(boolean option) {
		popupGraphics.isVisiblePanelGrafics(option);
	}
	
	
	public void getBarPanelGraphics(int[] vaccinationsByCity,String[] namesCitites,String nameCity,String nameHospital) {
		popupGraphics.getBarPanelGraphics(vaccinationsByCity,namesCitites,nameCity,nameHospital);
	}
	public void isVisiblePanelGraphics() {
		popupGraphics.setVisible();
	}
	
	public void isVisiblePanelCakeDiagram(boolean option) {
		popupGraphicsCakeDiagram.isVisible(option);
	}
	
	public void initComboBoxHospitalCakeDiagram(ArrayList<String> listNameHospital) {
		popupGraphicsCakeDiagram.initComboBoxHospital(listNameHospital);
	}
	
	public String getComboBoxCityGraphicsCakeDiagram() {
		return popupGraphicsCakeDiagram.getComboBoxCity();
	}
	
	public String getComboBoxHealthPost() {
		return popupGraphicsCakeDiagram.getComboBoxHealthPost();
	}
	
	
	public void getCakePanelGraphics(int[] grades,int[] porcentage,String[] namesCitites,String nameCity,String nameHospital) {
		popupGraphicsCakeDiagram.getCakePanelGraphics(grades,porcentage,namesCitites,nameCity,nameHospital);
	}
	
	public void isVisiblePanelGraficsCake(boolean option) {
		popupGraphicsCakeDiagram.isVisiblePanelGrafics(option);
	}
	
	public void isPanelCakeDiagramPanel() {
		popupGraphicsCakeDiagram.isPanelCakeDiagramPanel();
	}
	
	public void removePatient(DefaultTableModel model,int row) {
		program.removePatient(model, row);
	}
	
	
	public int getSelectRowTable() {
		return program.getSelectRowTable();
	}
	
	
	public void clearFieldHealthPost() {
		popupGeneral.clearFieldHealthPost();
	}
	
	public void getMessage(String message) {
		System.out.println(message);
	}
	
	
	public void getPorcentage(int[] array) {
		porcentage = new JDialogPorcentageFinal(this,array);
	}
	



}

