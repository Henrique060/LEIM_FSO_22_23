package demo.fso.consola;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DemoApplication {
	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	
	
	private void handleEnter() {
		this.textArea.append(
				"\r\n" + 
		this.textField.getText());
	}
	
	
	private void myInitialize() {
		System.out.println("As minhas inicializações...");
		this.textArea.setText("ola");
		this.textArea.append("\r\nmundo");
		}

	public static void main(String[] args) {
		
	}
}
