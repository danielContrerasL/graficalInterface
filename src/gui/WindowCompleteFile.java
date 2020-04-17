package gui;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Entity.Person;
import config.HandlerLanguage;
import config.HandlerProperties;
import controller.Controller;
import general.Constants;

@SuppressWarnings("serial")
public class WindowCompleteFile extends JDialog {
	private Controller controller;
	private Person person;

	private JLabel jLGender;
	private JRadioButton jRadioMen;
	private JRadioButton jRadioWoman;
	private ButtonGroup buttonGroup;

	private JButton jBSave;
	private JButton jBClose;

	private JTextField jTFName;
	private JLabel jLName;

	private JTextField jTFLastName;
	private JLabel jLLastName;

	private JTextField jTFCode;
	private JLabel jLCode;

	public WindowCompleteFile(Controller controller, JFrame frame) {
		super(frame, true);
		this.controller = controller;
		setSize(420, 380);
		setTitle("Completar Datos");
		setLocationRelativeTo(null);
		setLayout(null);
		inizialitation();
		initJRadioButton();
		setTexts();
	}

	public void initJRadioButton() {
		buttonGroup = new ButtonGroup();

		jLGender = new JLabel("Genero:");
		jLGender.setBounds(20, 190, 100, 30);
		this.add(jLGender);

		jRadioMen = new JRadioButton("Masculino");
		jRadioMen.setBounds(150, 190, 90, 30);
		this.add(jRadioMen);
		buttonGroup.add(jRadioMen);

		jRadioWoman = new JRadioButton("Femenino");
		jRadioWoman.setBounds(250, 190, 80, 30);
		this.add(jRadioWoman);
		buttonGroup.add(jRadioWoman);
	}

	public void clean() {
		jTFName.setText("");

	}

	public Person getPerson() {
		person = new Person();
		person.setName(jTFName.getText());
		person.setCode(Integer.parseInt(jTFCode.getText()));
		person.setLastName(jTFLastName.getText());
		person.setGender(getGender());
		return person;
	}
	
	public String getGender() {
		boolean man =jRadioMen.isSelected();
		boolean woman = jRadioWoman.isSelected();
		String result = "n";
		if (woman) {
			result = Constants.WOMAN;
		}else if (man) {
			result = Constants.MEN;
		}
		return result;
	}

	public void inizialitation() {
		initButtonSave();
		initButtonClose();
		addTextFile();
	}

	public void addTextFile() {
		jLName = new JLabel("Nombre: ");
		jLName.setBounds(20, 20, 120, 30);
		this.add(jLName);
		jTFName = new JTextField();
		jTFName.addKeyListener(controller);
		jTFName.setBounds(180, 25, 150, 20);
		this.add(jTFName);

		jLLastName = new JLabel("Apellido:");
		jLLastName.setBounds(20, 70, 120, 30);
		this.add(jLLastName);
		jTFLastName = new JTextField();
		jTFLastName.addKeyListener(controller);
		jTFLastName.setBounds(180, 75, 150, 20);
		this.add(jTFLastName);

		jLCode = new JLabel("Usuario Codigo:");
		jLCode.setBounds(20, 120, 120, 30);
		this.add(jLCode);
		jTFCode = new JTextField();
		jTFCode.setBounds(180, 125, 150, 20);
		jTFCode.setName("code");
		jTFCode.addKeyListener(controller);
		this.add(jTFCode);
	}

	public void initButtonSave() {
		jBSave = new JButton("guardar");
		jBSave.setBounds(100, 280, 100, 30);
		jBSave.setActionCommand(Constants.ADD_NEW_PERSON);
		jBSave.addActionListener(controller);
		this.add(jBSave);
	}

	public void initButtonClose() {
		jBClose = new JButton("Cerrar");
		jBClose.setBounds(220, 280, 100, 30);
		jBClose.setActionCommand(Constants.CLOSE_JDIALOG);
		jBClose.addActionListener(controller);
		this.add(jBClose);
	}

	public void setTexts() {
		HandlerProperties languageProperties = new HandlerProperties(HandlerLanguage.language);
		setTitle(languageProperties.getProperty("complete_title"));
		jLGender.setText(languageProperties.getProperty("complete_gender"));
		jRadioMen.setText(languageProperties.getProperty("complete_man"));
		jRadioWoman.setText(languageProperties.getProperty("complete_woman"));
		
		
		jBClose.setText(languageProperties.getProperty("close_button"));
		jBSave.setText(languageProperties.getProperty("complete_save"));
		jLName.setText(languageProperties.getProperty("complete_name"));
		jLLastName.setText(languageProperties.getProperty("complete_last_name"));
		jLCode.setText(languageProperties.getProperty("complete_user_code"));
	}

}
