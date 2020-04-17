package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import config.HandlerLanguage;
import config.HandlerProperties;
import general.Constants;
import controller.Controller;

@SuppressWarnings("serial")
public class WindowColor extends JDialog implements ChangeListener {
	private JColorChooser jColorC;
    private JButton jBColor;
    private Controller controller;
    
  public WindowColor(Controller controller, JFrame jFrame){
	super(jFrame, true);
	this.controller = controller;
	setLayout(new BorderLayout());
    initializacion();
	pack();
	setLocationRelativeTo(null);
	setLayout(null);
  }  
	
  public void initializacion(){
	initJcolor();  
	initJbutton();  
  }
 public void initJcolor(){
	 jColorC = new JColorChooser();
     jColorC.getSelectionModel().addChangeListener(this);	 
     jColorC.setMaximumSize(new Dimension(100, 100));
     this.add(jColorC, BorderLayout.CENTER);
 }
  
  public void initJbutton(){
	  jBColor = new JButton("Pulsa aquí para cerrar");
	  jBColor.setBackground(new Color(4, 97, 128));
	  jBColor.setActionCommand(Constants.CLOSE_JDIALOG);
	  jBColor.addActionListener(controller);
	  this.add(jBColor, BorderLayout.SOUTH);
  }


	@Override
	public void stateChanged(ChangeEvent arg0) {
	}
	
	public String getHexColorSelected(){
		return "#" + Integer.toHexString(jColorC.getColor().getRGB()).substring(2);
	}
	
	public void setTexts() {
		HandlerProperties languageProperties = new HandlerProperties(HandlerLanguage.language);
		setTitle(languageProperties.getProperty("color_title"));
		jBColor.setText(languageProperties.getProperty("close_button"));
		}
}
