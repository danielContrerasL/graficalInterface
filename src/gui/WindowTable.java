package gui;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Entity.Person;
import config.HandlerLanguage;
import config.HandlerProperties;
import controller.Controller;
import general.Constants;
import logic.PersonFileTxt;

@SuppressWarnings("serial")
public class WindowTable extends JDialog {
	private Person person;
	private JButton jBAddButton;
	private JButton jBCloseButton;
	private JButton jButtonLoadTable;
	private Controller controller;
	private JTable jTable;
	private DefaultTableModel model;

	public WindowTable(Controller controller, JFrame frame) {
		super(frame, true);
		this.controller = controller;
		setSize(320, 600);
		setTitle("Tabla de informacion");
		setLocationRelativeTo(null);
		setLayout(null);
		inizialitation();
		setTexts();
	}

	public void inizialitation() {
		initButtonAdd();
		initButtonClose();
		initTable();
		addColumns();
		initButtonLoad();
		
	}

	public void addValuetable(Person person) {
		DefaultTableModel DTM = (DefaultTableModel) jTable.getModel();
		DTM.setRowCount(DTM.getRowCount() + 1);
		DTM.setValueAt(person.getName(), DTM.getRowCount() - 1, 0);
		DTM.setValueAt(person.getLastName(), DTM.getRowCount() - 1, 1);
		DTM.setValueAt(person.getGender(), DTM.getRowCount() - 1, 2);
	}

	public void initLable() {
		DefaultTableModel DTM = (DefaultTableModel) jTable.getModel();
		DTM.setRowCount(0);
	}

	
	public void initTable() {
		jTable = new JTable();
		jTable.setEnabled(false);
		JScrollPane scrol = new JScrollPane(jTable);
		this.add(scrol);
		scrol.setBounds(20, 20, 265, 350);
	}

	public void addColumns() {
		model = (DefaultTableModel) (jTable.getModel());
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Genero");
	}

	public void initButtonAdd() {
		jBAddButton = new JButton("Agregar");
		jBAddButton.setBounds(110, 390, 100, 30);
		jBAddButton.setActionCommand(Constants.ACTION_WINDOW_ADD);
		jBAddButton.addActionListener(controller);
		this.add(jBAddButton);
	}
	
	public void initButtonLoad() {
		jButtonLoadTable = new JButton("Cargar");
		jButtonLoadTable.setBounds(110, 430, 100, 30);
		jButtonLoadTable.setActionCommand(Constants.LOAD_TABLE);
		jButtonLoadTable.addActionListener(controller);
		this.add(jButtonLoadTable);
	}

	public void initButtonClose() {
		jBCloseButton = new JButton("Cerrar");
		jBCloseButton.setBounds(110, 510, 100, 30);
		jBCloseButton.setActionCommand(Constants.CLOSE_JDIALOG);
		jBCloseButton.addActionListener(controller);
		this.add(jBCloseButton);
	}

	public void setTexts() {
		HandlerProperties languageProperties = new HandlerProperties(HandlerLanguage.language);
		setTitle(languageProperties.getProperty("table_title"));
		TableColumnModel tCm = jTable.getColumnModel();
		tCm.getColumn(0).setHeaderValue(languageProperties.getProperty("table_name"));
		tCm.getColumn(1).setHeaderValue(languageProperties.getProperty("table_last_name"));
		tCm.getColumn(2).setHeaderValue(languageProperties.getProperty("table_gender"));
		jBAddButton.setText(languageProperties.getProperty("table_add_button"));
		jButtonLoadTable.setText(languageProperties.getProperty("table_load"));
		jBCloseButton.setText(languageProperties.getProperty("close_button"));
		repaint();
	}
}
