package gui;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import Entity.Car;
import config.HandlerLanguage;
import config.HandlerProperties;
import controller.Controller;
import general.Constants;

@SuppressWarnings("serial")
public class WindowCarList extends JDialog {
	private Controller controller;
	private JButton jBClose;
	private JButton jBAddCarButton;
	private JButton jBAddCarOwnerButton;
	private JList<Car> jList;
	private JScrollPane jScrollPane;
	private DefaultListModel<Car> defaultListModel;

	public WindowCarList(Controller controller, JFrame frame) {
		super(frame, true);
		this.controller = controller;
		setSize(320, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		inizialitation();
		initJList();
		setTexts();
		jList.setModel(defaultListModel);
	}

	

	public void initJList() {
		jList = new JList<Car>();
		jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		defaultListModel = new DefaultListModel<Car>();
		jScrollPane = new JScrollPane();
		jScrollPane.setBounds(10, 10, 290, 400);
		jScrollPane.setViewportView(jList);
		this.add(jScrollPane);
	}

	public void inizialitation() {
		initButton();
		initButtonAddCar();
		initCarOwnerAddButton();
	}
	public void initCarOwnerAddButton() {
		jBAddCarOwnerButton = new JButton("Propietario");
		jBAddCarOwnerButton.setBounds(110, 465, 100, 30);
		jBAddCarOwnerButton.setActionCommand(Constants.ACTION_WINDOW_ADD_OWNER);
		jBAddCarOwnerButton.addActionListener(controller);
		this.add(jBAddCarOwnerButton);
	}

	public void addValueList(Car car) {
		defaultListModel.addElement(car);
	}

	public void initButtonAddCar() {
		jBAddCarButton = new JButton("Agregar carro");
		jBAddCarButton.setBounds(110, 430, 100, 30);
		jBAddCarButton.setActionCommand(Constants.OPEN_WINDOW_ADD_CAR);
		jBAddCarButton.addActionListener(controller);
		this.add(jBAddCarButton);
	}

	public void initButton() {
		jBClose = new JButton("Cerrar");
		jBClose.setBounds(110, 500, 100, 30);
		jBClose.setActionCommand(Constants.CLOSE_JDIALOG);
		jBClose.addActionListener(controller);
		this.add(jBClose);
	}
	
	

	public void setTexts() {
		HandlerProperties languageProperties = new HandlerProperties(HandlerLanguage.language);
		jBClose.setText(languageProperties.getProperty("close_button"));
		setTitle(languageProperties.getProperty("table_title"));
		jBAddCarButton.setText(languageProperties.getProperty("table_add__car_button"));
	}

}
