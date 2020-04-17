package gui.windowAbout;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.Controller;
import general.Constants;

@SuppressWarnings("serial")
public class PanelButton extends JPanel {
	private JButton button;
	private Controller controller;

	public PanelButton(Controller controller) {
		this.controller = controller;
		inisialisateComponents();
	}

	public void inisialisateComponents() {
		addButtonClose();
	}

	public void addButtonClose() {
		button =  new JButton("no name");
		button.setBounds(1, 1, 200, 30);
		button.addActionListener(controller);
		button.setActionCommand(Constants.CLOSE_JDIALOG);
	}

}
