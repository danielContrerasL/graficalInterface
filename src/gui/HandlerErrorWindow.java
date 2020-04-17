package gui;

import javax.swing.JOptionPane;

public class HandlerErrorWindow {
	public void printerror(String error) {
		JOptionPane.showMessageDialog(null, error, error, JOptionPane.ERROR_MESSAGE);;
	}
	

}
