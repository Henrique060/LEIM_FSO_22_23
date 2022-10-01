package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import MOVE.movement;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.ScrollPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import MOVE.movement;

public class gui_app extends movement implements ActionListener, KeyListener{

	private JTextArea textArea;
	private JFrame frmGuiDoServidor;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	
	public movement move = new movement();
	
	private String robot_name;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_app window = new gui_app();
					window.frmGuiDoServidor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui_app() {
		initialize();
		frmGuiDoServidor.addKeyListener(this);
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGuiDoServidor = new JFrame();
		frmGuiDoServidor.setTitle("GUI do SERVIDOR");
		frmGuiDoServidor.setBounds(100, 100, 449, 417);
		frmGuiDoServidor.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmGuiDoServidor.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyListener() {
			

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textArea.append("\r" + textField.getText() + "\n");
					robot_name = textField.getText();
				}	
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		textField.setBounds(64, 10, 198, 19);
		frmGuiDoServidor.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Robot");
		lblNewLabel.setBounds(6, 13, 62, 13);
		frmGuiDoServidor.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("On/Off");
		rdbtnNewRadioButton.setBounds(319, 9, 103, 21);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(move.esta_ligado(robot_name) == true) {
					textArea.append("\r" + "Robot ON" + "\n");
				} else {
					textArea.append("\r" + "Robot OFF" + "\n");
				}
				
			}
		});
		
		frmGuiDoServidor.getContentPane().add(rdbtnNewRadioButton);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyListener() {
			

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textArea.append("\r" + textField_1.getText() + "\n");
				}	
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		textField_1.setBounds(368, 36, 54, 19);
		frmGuiDoServidor.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyListener() {
			

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textArea.append("\r" + textField_2.getText() + "\n");
				}	
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(208, 39, 54, 19);
		frmGuiDoServidor.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyListener() {
			

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textArea.append("\r" + textField_3.getText() + "\n");
				}	
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(64, 39, 54, 19);
		frmGuiDoServidor.getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("Frente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					move.andar_frente(robot_name);
					textArea.append("\r" + "Frente..." + "\n");
				} catch (InterruptedException e1) {
					textArea.append("\r" + "Falhou" + "\n");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(159, 68, 103, 35);
		frmGuiDoServidor.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Parar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					move.parar(robot_name);
					textArea.append("\r" + "Parar..." + "\n");
				} catch (InterruptedException e1) {
					textArea.append("\r" + "Falhou" + "\n");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(159, 107, 103, 35);
		frmGuiDoServidor.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Retaguarda");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					move.andar_tras(robot_name);
					textArea.append("\r" + "Retaguarda..." + "\n");
				} catch (InterruptedException e1) {
					textArea.append("\r" + "Falhou" + "\n");
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(159, 146, 103, 35);
		frmGuiDoServidor.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Direita");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					move.curvar_direita(robot_name);
					textArea.append("\r" + "Direita..." + "\n");
				} catch (InterruptedException e1) {
					textArea.append("\r" + "Falhou" + "\n");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(266, 107, 103, 35);
		frmGuiDoServidor.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Esquerda");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					move.curvar_esquerda(robot_name);
					textArea.append("\r" + "Esquerda..." + "\n");
				} catch (InterruptedException e1) {
					textArea.append("\r" + "Falhou" + "\n");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(53, 107, 103, 35);
		frmGuiDoServidor.getContentPane().add(btnNewButton_4);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Debug");
		chckbxNewCheckBox.setBounds(6, 153, 93, 21);
		frmGuiDoServidor.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Vaguear");
		chckbxNewCheckBox_1.setBounds(337, 146, 93, 21);
		frmGuiDoServidor.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Evitar");
		chckbxNewCheckBox_2.setBounds(337, 166, 93, 21);
		frmGuiDoServidor.getContentPane().add(chckbxNewCheckBox_2);
		
		JLabel lblNewLabel_1 = new JLabel("Consola");
		lblNewLabel_1.setBounds(6, 192, 62, 13);
		frmGuiDoServidor.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Raio");
		lblNewLabel_2.setBounds(9, 42, 45, 13);
		frmGuiDoServidor.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Angulo");
		lblNewLabel_2_1.setBounds(153, 42, 45, 13);
		frmGuiDoServidor.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Distancia");
		lblNewLabel_2_1_1.setBounds(295, 39, 63, 13);
		frmGuiDoServidor.getContentPane().add(lblNewLabel_2_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 228, 402, 131);
		frmGuiDoServidor.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		}
		
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
