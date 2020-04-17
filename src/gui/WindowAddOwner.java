package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Entity.Car;
import Entity.Person;
import config.HandlerLanguage;
import config.HandlerProperties;
import controller.Controller;
import general.Constants;

@SuppressWarnings("serial")
public class WindowAddOwner extends JDialog {
	private JButton jBClose;
	private Controller controller;
	private JTable jTable;
	private DefaultTableModel model;
	private Car car;

	public WindowAddOwner(Controller controller, JFrame frame) {
		super(frame, true);
		this.controller = controller;
		setSize(320, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		inizialitation();
	}

	public void inizialitation() {
		initButton();
		initTable();
		addColumns();
	}

	public void initLable() {
		DefaultTableModel DTM = (DefaultTableModel) jTable.getModel();
		DTM.setRowCount(0);
	}

	public void addValuetable(Car car) {
		DefaultTableModel DTM = (DefaultTableModel) jTable.getModel();
		DTM.setRowCount(DTM.getRowCount() + 1);
		DTM.setValueAt(car.getPlaca(), DTM.getRowCount() - 1, 0);
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
		model.addColumn("Crro");
		model.addColumn("Propietrio");
		model.addColumn("Propietrio");
	}

	public void initButton() {
		// Caracteristicas del boton Cerrar
		jBClose = new JButton("Cerrar");
		jBClose.setBounds(95, 500, 130, 30);

		jBClose.setActionCommand(Constants.CLOSE_JDIALOG);
		jBClose.setFont(null);
		jBClose.addActionListener(controller);
		// agregar botones
		this.add(jBClose);
	}

	public void setTexts() {
		HandlerProperties languageProperties = new HandlerProperties(HandlerLanguage.language);
		jBClose.setText(languageProperties.getProperty("close_button"));
	}

}
