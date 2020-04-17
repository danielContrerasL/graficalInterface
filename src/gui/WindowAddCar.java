package gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Entity.Car;
import Entity.Person;
import config.HandlerLanguage;
import config.HandlerProperties;
import controller.Controller;
import general.Constants;

@SuppressWarnings("serial")
public class WindowAddCar extends JDialog {
	private Controller controller;
	private Car car;

	@SuppressWarnings("rawtypes")
	private JComboBox camboBoxprimaryOwner;
	@SuppressWarnings("rawtypes")
	private JComboBox camboBoxSecondOwner;
	private JLabel jLOwner;

	private JButton jBSave;
	private JButton jBClose;

	private JTextField jTFPlaca;
	private JLabel jLPlaca;

	private JTextField jTMarca;
	private JLabel jLMarca;

	private JTextField jTFModelo;
	private JLabel jLModelo;

	private JButton JBddColorButton;
	private String colorSelected;

	public WindowAddCar(Controller controller, JFrame frame) {
		super(frame, true);
		this.controller = controller;
		setSize(420, 490);
		setTitle("Agrgar Carro");
		setLocationRelativeTo(null);
		setLayout(null);
		inizialitation();
		setTexts();
	}

	// --------------Parcial------------------------------
	private JLabel jLBoxCar;
	private JRadioButton jRadioAutomatic;
	private JRadioButton jRadioMecanic;
	private ButtonGroup buttonGroup;

	public void initjLBoxCar() {
		buttonGroup = new ButtonGroup();

		jLBoxCar = new JLabel("Box Car:");
		jLBoxCar.setBounds(20, 160, 100, 30);
		this.add(jLBoxCar);

		jRadioAutomatic = new JRadioButton("Automatico");
		jRadioAutomatic.setBounds(150, 160, 90, 30);
		this.add(jRadioAutomatic);
		buttonGroup.add(jRadioAutomatic);

		jRadioMecanic = new JRadioButton("Mecanico");
		jRadioMecanic.setBounds(250, 160, 80, 30);
		this.add(jRadioMecanic);
		buttonGroup.add(jRadioMecanic);
	}

	public String getBoxCar() {
		boolean automatic = jRadioAutomatic.isSelected();
		boolean mecanic = jRadioMecanic.isSelected();
		String result = "n";
		if (mecanic) {
			result = Constants.MECANIC;
		} else if (automatic) {
			result = Constants.AUTOMTIC;
		}
		return result;
	}

	// --------------Parcial------------------------------

	public void clean() {
		jTFPlaca.setText("");

	}

	public Car getCar() {
		car = new Car();
		car.setPlaca(jTFPlaca.getText());
		car.setMarca(jTMarca.getText());
		car.setModelo(jTFModelo.getText());
		car.setBox(getBoxCar());
		return car;
	}

	public void inizialitation() {
		initButtonSave();
		initButtonClose();
		addTextFile();
		initColorButton();
		initjLBoxCar();
	}

	public void addTextFile() {
		jLPlaca = new JLabel("placa: ");
		jLPlaca.setBounds(20, 20, 100, 30);
		this.add(jLPlaca);
		jTFPlaca = new JTextField();
		jTFPlaca.setBounds(150, 25, 150, 20);
		this.add(jTFPlaca);

		jLMarca = new JLabel("marca:");
		jLMarca.setBounds(20, 70, 100, 30);
		this.add(jLMarca);
		jTMarca = new JTextField();
		jTMarca.setBounds(150, 75, 150, 20);
		this.add(jTMarca);

		jLModelo = new JLabel("modelo:");
		jLModelo.setBounds(20, 120, 120, 30);
		this.add(jLModelo);
		jTFModelo = new JTextField();
		jTFModelo.setBounds(150, 125, 150, 20);
		this.add(jTFModelo);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addOwner(ArrayList<Person> list) {
		jLOwner =  new JLabel("Propietario");
		jLOwner.setBounds(50, 220, 100, 30);
		this.add(jLOwner);
		camboBoxprimaryOwner = new JComboBox();
		camboBoxprimaryOwner.setBounds(120, 225, 80, 20);
		for (Person person : list) {
			camboBoxprimaryOwner.addItem(person);
		}
		this.add(camboBoxprimaryOwner);
	}
	
	public void primaryOwnerSelected() {
		camboBoxprimaryOwner.getSelectedItem();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addSecondOwner(ArrayList<Person> list) {
		camboBoxSecondOwner = new JComboBox();
		camboBoxSecondOwner.setBounds(220, 225, 80, 20);
		for (Person person : list) {
			camboBoxSecondOwner.addItem(person);
		}
		this.add(camboBoxSecondOwner);
	}

	public void initColorButton() {
		JBddColorButton = new JButton("Color");
		JBddColorButton.setBounds(160, 280, 100, 30);
		JBddColorButton.setActionCommand(Constants.ADD_COLOR);
		JBddColorButton.addActionListener(controller);
		this.add(JBddColorButton);
	}

	public void initButtonSave() {
		jBSave = new JButton("guardar");
		jBSave.setBounds(100, 320, 100, 30);
		jBSave.setActionCommand(Constants.ACTION_WINDOW_ADD_CAR);
		jBSave.addActionListener(controller);
		this.add(jBSave);
	}

	public void initButtonClose() {
		jBClose = new JButton("Cerrar");
		jBClose.setBounds(220, 320, 100, 30);
		jBClose.setActionCommand(Constants.CLOSE_JDIALOG);
		jBClose.addActionListener(controller);
		this.add(jBClose);
	}

	public void ddSelectedColor(String selectedColor) {
		colorSelected = selectedColor;
		Color color = Color.decode(colorSelected);
		JBddColorButton.setBackground(color);
	}

	public void setTexts() {
		HandlerProperties languageProperties = new HandlerProperties(HandlerLanguage.language);

		setTitle(languageProperties.getProperty("complete_car_title"));
		jBClose.setText(languageProperties.getProperty("close_button"));
		jBSave.setText(languageProperties.getProperty("complete_save"));
		jLPlaca.setText(languageProperties.getProperty("complete_car_license_plate"));
		jLMarca.setText(languageProperties.getProperty("complete_car_stamp"));
		jLModelo.setText(languageProperties.getProperty("complete_car_model"));
		jLBoxCar.setText(languageProperties.getProperty("complete_car_box_car"));
		jRadioAutomatic.setText(languageProperties.getProperty("complete_car_automatic_box_car"));
		jRadioMecanic.setText(languageProperties.getProperty("complete_car_mecanic_box_car"));
	}
}