package controller;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


import Entity.Person;
import Entity.Car;
import config.HandlerLanguage;
import general.Constants;
import gui.HandlerErrorWindow;
import gui.MainWindow;
import gui.WindowAddCar;
import gui.WindowAddOwner;
import gui.WindowCarList;
import gui.WindowColor;
import gui.WindowCompleteFile;
import gui.WindowTable;
import gui.windowAbout.WindowAbout;
import logic.CarLogic;
import logic.PersonLogic;
import persistence.interfce.Iperdistence;

public class Controller implements ActionListener, KeyListener {
	private MainWindow mainWindow;
	private WindowAbout windowAbout;
	private WindowCarList carList;
	private WindowTable table;
	private WindowAddCar addCar;
	private WindowCompleteFile completeFile;
	private WindowAddOwner addOwner;
	private WindowColor windowColor;
	private HandlerErrorWindow errorWindow;
	
	private HandlerLanguage handlerLanguage;
	private final String FILECONFIC = "confi.properties";
	
	private PersonLogic personLogic;
	private CarLogic carLogic;
	

	public Controller(Iperdistence iperdistence) {
		personLogic = new PersonLogic();
		carLogic = new CarLogic();
		errorWindow = new HandlerErrorWindow();
		
		personLogic.setPersistence(iperdistence);
		carLogic.setPersistence(iperdistence);

	}

	public void loadConfiguration() {
		if (handlerLanguage == null) {
			handlerLanguage = new HandlerLanguage(FILECONFIC);
		}
		try {
			handlerLanguage.loadLanguage();
		} catch (Exception e) {
			System.err.println("Error loading configuration Controller " + e.getMessage());
		}
	}

	public void openMainWindow() {
		mainWindow = new MainWindow(this);
		mainWindow.setTexts();
		mainWindow.setVisible(true);
	}

	public void openWindowColor() {
		if (windowColor == null) {
			windowColor = new WindowColor(this, mainWindow);
		}
		windowColor.setVisible(true);
	}

	public void openWindowAbout() {
		if (windowAbout == null) {
			windowAbout = new WindowAbout(this, mainWindow);
		}
		windowAbout.setVisible(true);
	}

	public void openWindowCarList() {
		if (carList == null) {
			carList = new WindowCarList(this, mainWindow);
		}
		carList.setVisible(true);
	}

	public void openWindowTable() {
		if (table == null) {
			table = new WindowTable(this, mainWindow);
		}
		table.setVisible(true);
	}

	public void openWindowAddCar() {
		if (addCar == null) {
			addCar = new WindowAddCar(this, mainWindow);
		}
		loadPersonsInComboBox();
		addCar.setVisible(true);
	}
	
	public void openWindowAddOwner() {
		if (addOwner == null) {
			addOwner = new WindowAddOwner(this, mainWindow);
		}
		loadOwnerInformation();
		addOwner.setVisible(true);
	}

	public void openWindowAdd() {
		if (completeFile == null) {
			completeFile = new WindowCompleteFile(this, mainWindow);
		}
		completeFile.setVisible(true);
	}

	// Controller-------------------------------------------Controller
	@Override
	public void actionPerformed(ActionEvent e) {
		actionPerformedOpenWindow(e);
		actionPerformedAdd(e);
		actionPerformedChangeLanguage(e);
		actionPerformedLoadInformation(e);
		actionPerformedClose(e);
	}

	public void actionPerformedOpenWindow(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.ACTION_ABOUT:
			openWindowAbout();
			break;
		case Constants.OPEN_WINDOW_ADD_CAR:
			openWindowAddCar();
			break;
		case Constants.ACTION_WINDOW_CAR:
			openWindowCarList();
			break;
		case Constants.ACTION_WINDOW_ADD:
			openWindowAdd();
			break;
		case Constants.ACTION_WINDOW_TABLE:
			openWindowTable();
			break;
		case Constants.ACTION_WINDOW_ADD_OWNER:
			openWindowAddOwner();
			break;
		}
	}

	public void actionPerformedAdd(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.ADD_NEW_PERSON:
			Person person = completeFile.getPerson();
			try {
				personLogic.save(person);
				table.addValuetable(person);
			} catch (Exception e2) {
				errorWindow.printerror(e2.getMessage());
			}
			break;
		case Constants.ACTION_WINDOW_ADD_CAR:
			Car car = addCar.getCar();
			try {
				carLogic.save(car);
				carList.addValueList(car);
			} catch (Exception e2) {
				errorWindow.printerror(e2.getMessage());
			}
			break;
		case Constants.ADD_COLOR:
			openWindowColor();
			break;
		}
	}

	public void actionPerformedChangeLanguage(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.CHANGE_ENGLISH:
			changeToEnglish();
			setTexts();
			break;
		case Constants.CHANGE_SPANIH:
			changeToSpanish();
			setTexts();
			break;
		}
	}

	public void actionPerformedLoadInformation(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.LOAD_TABLE:
			loadPeople();
			break;
		}
	}

	public void actionPerformedClose(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.CLOSE_JDIALOG:
			closeJdialog(e);
			break;
		case Constants.EXIT:
			System.exit(0);
			break;
		}
	}

	public void closeJdialog(ActionEvent e) {
		Window window = (JDialog) SwingUtilities.getWindowAncestor((Component) e.getSource());
		window.dispose();
	}
	// Controller-----------------------------------------------------Controller


	public void loadPeople() {
		ArrayList<Person> list = null;
		try {
			list = personLogic.load();
			table.initLable();
			for (Person person : list) {
				table.addValuetable(person);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadPersonsInComboBox() {
		ArrayList<Person> list = null;
		try {
			list = personLogic.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		addCar.addOwner(list);
		addCar.addSecondOwner(list);
	}
	
	public void loadOwnerInformation() {
		try {
			ArrayList<Car> list = carLogic.load();
			addOwner.initLable();
			for (Car car : list) {
				addOwner.addValuetable(car);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void loadTableInformation() throws IOException {
		personLogic.load();
	}

	public void setTexts() {
		mainWindow.setTexts();
		if (table != null) {
			table.setTexts();
		}
		if (windowAbout != null) {
			windowAbout.setTexts();
		}
		if (completeFile != null) {
			completeFile.setTexts();
		}
		if (addCar != null) {
			addCar.setTexts();
		}
		if (carList != null) {
			carList.setTexts();
		}
	}

	public void loadLanguage() {
		try {
			handlerLanguage.loadLanguage();
		} catch (Exception e) {
		}
	}

	public void changeToSpanish() {
		HandlerLanguage.language = "spanish.txt";
		saveConfig();
		loadLanguage();
	}

	public void changeToEnglish() {
		HandlerLanguage.language = "english.txt";
		saveConfig();
		loadLanguage();
	}

	public void saveConfig() {
		try {
			new HandlerLanguage(FILECONFIC).saveLanguage();
		} catch (Exception e) {
			System.out.println("Error en saveConfig");
		}
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		JTextField f = (JTextField) e.getSource();
		if (f.getName() != null) {
			if (Character.isLetter(e.getKeyChar())) {
				e.consume();
				mainWindow.getToolkit().beep();
			}
		} else if (Character.isDigit(e.getKeyChar())) {
			e.consume();
			mainWindow.getToolkit().beep();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
