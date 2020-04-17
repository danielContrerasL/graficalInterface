package gui.windowAbout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelInfo extends JPanel {
	
	
	
	
	public void initLable() {
		JLabel jLUniversity = new JLabel();
		jLUniversity.setIcon(new ImageIcon("supp.png"));
		jLUniversity.setBounds(20, 200, 256, 256);
		this.add(jLUniversity);
	
		JTextArea textArea = new JTextArea();
		textArea.setText("Universidad Pedagogica y Tecnologica de Colombia\nDaniel Flelipe Contreras Lopez");
		textArea.setBounds(1, 1, 290, 45);
		textArea.setBackground(this.getBackground());
		this.add(textArea);
		
	}

}
