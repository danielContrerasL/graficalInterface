package gui.windowAbout;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import config.HandlerLanguage;
import config.HandlerProperties;
import controller.Controller;
import general.Constants;

@SuppressWarnings("serial")
public class WindowAbout extends JDialog{
	private JButton jBClose;
	private JLabel jLUniversity;
	private JTextArea textArea;
	
	private Controller controller;

	public WindowAbout( Controller controller, JFrame frame) {
		super(frame,true);
		this.controller =  controller;
		setSize(320, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		inizialitation();
	}

	public void inizialitation() {
		initButton();
		initLable();
	}

	public void initLable() {
		jLUniversity = new JLabel();
		jLUniversity.setIcon(new ImageIcon("supp.png"));
		jLUniversity.setBounds(20, 200, 256, 256);
		this.add(jLUniversity);
	
		textArea =  new JTextArea();
		textArea.setText("Universidad Pedagogica y Tecnologica de Colombia" + "\nDaniel Flelipe Contreras Lopez");
		textArea.setBounds(1, 1, 290, 55);
		textArea.setBackground(this.getBackground());
		this.add(textArea);
		
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
		textArea.setText(languageProperties .getProperty("uptc")+ "\nDaniel Flelipe Contreras Lopez");
		jBClose.setText(languageProperties .getProperty("close_button"));
	}

}
