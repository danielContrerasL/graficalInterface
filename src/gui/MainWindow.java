package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import config.HandlerLanguage;
import config.HandlerProperties;
import controller.Controller;
import general.Constants;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JButton jBClose;
	private JMenuBar jMenuBar;

	private Controller controller;

	private JMenuItem jMenuAbout;
	private JMenuItem jMenuTable;
	private JMenuItem jMenuList;
	private JMenu jMenuStartCapsule;


	private JMenuItem jMenuClose;
	private JMenu jMenuCloseWindowCapsule;

	private JMenuItem jMenuLanguageEnglish;
	private JMenuItem jMenuLanguageSpanish;
	private JMenu jMenuLanguageCapsule;
	
	private JTextArea textArea;

	public MainWindow(Controller controller) {
		setController(controller);
		setSize(320, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		setTitle("Inicio");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		inizialitation();
		setTexts();
	}

	public void setController(Controller runner) {
		this.controller = runner;
	}

	public void inizialitation() {
		initButton();
		initMenu();
		initLable();
	}

	public void initMenu() {
		jMenuBar = new JMenuBar();
		jMenuStartCapsule = new JMenu();
		jMenuLanguageCapsule = new JMenu();
		jMenuCloseWindowCapsule = new JMenu();

		initMenuButton();

		jMenuBar.add(jMenuStartCapsule);
		jMenuBar.add(jMenuLanguageCapsule);
		jMenuBar.add(jMenuCloseWindowCapsule);
		this.setJMenuBar(jMenuBar);
	}

	public void initMenuButton() {
		jMenuAbout = new JMenuItem();
		jMenuAbout.setActionCommand(Constants.ACTION_ABOUT);
		jMenuAbout.addActionListener(controller);

		jMenuTable = new JMenuItem();
		jMenuTable.setActionCommand(Constants.ACTION_WINDOW_TABLE);
		jMenuTable.addActionListener(controller);
		
		jMenuList =  new JMenuItem();
		jMenuList.setActionCommand(Constants.ACTION_WINDOW_CAR);
		jMenuList.addActionListener(controller);


		jMenuLanguageEnglish = new JMenuItem();
		jMenuLanguageEnglish.setActionCommand(Constants.CHANGE_ENGLISH);
		jMenuLanguageEnglish.addActionListener(controller);
		jMenuLanguageSpanish = new JMenuItem();
		jMenuLanguageSpanish.setActionCommand(Constants.CHANGE_SPANIH);
		jMenuLanguageSpanish.addActionListener(controller);

		jMenuClose = new JMenuItem("Cerrar");
		jMenuClose.setActionCommand(Constants.EXIT);
		jMenuClose.addActionListener(controller);

		jMenuStartCapsule.add(jMenuAbout);
		jMenuStartCapsule.add(jMenuTable);
		jMenuStartCapsule.add(jMenuList);


		jMenuLanguageCapsule.add(jMenuLanguageSpanish);
		jMenuLanguageCapsule.add(jMenuLanguageEnglish);

		jMenuCloseWindowCapsule.add(jMenuClose);
	}

	public void initLable() {
		textArea = new JTextArea();
		textArea.setText("Undefinide");
		textArea.setBounds(40, 150, 320, 30);
		textArea.setBackground(this.getBackground());
		this.add(textArea);
	}

	public void initButton() {
		jBClose = new JButton();
		jBClose.setBounds(95, 350, 130, 30);
		jBClose.setActionCommand(Constants.EXIT);
		jBClose.setFont(null);
		jBClose.addActionListener(controller);
		// agregar botones
		this.add(jBClose);
	}

	public void setTexts() {
		HandlerProperties properties = new HandlerProperties(HandlerLanguage.language);
		setTitle(properties.getProperty("main_window_title"));
		jMenuStartCapsule.setText(properties.getProperty("start"));
		jMenuLanguageCapsule.setText(properties.getProperty("language"));
		jMenuCloseWindowCapsule.setText(properties.getProperty("close_button"));

		textArea.setText(properties.getProperty("uptc"));
		jMenuList.setText(properties.getProperty("car_list"));
		jMenuAbout.setText(properties.getProperty("about"));
		jMenuTable.setText(properties.getProperty("table"));
		jMenuLanguageEnglish.setText(properties.getProperty("english"));
		jMenuLanguageSpanish.setText(properties.getProperty("spanish"));
		jMenuClose.setText(properties.getProperty("close_button"));
		jBClose.setText(properties.getProperty("close_button"));

	}

}
