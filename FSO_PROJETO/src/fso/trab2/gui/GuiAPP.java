package fso.trab2.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fso.trab1.servidor.Servidor;

public class GuiAPP implements ActionListener, KeyListener, Runnable{

	/*
	 * Os nomes das variáveis foram mudados de maneira a ser mais fácil perceber qual eram.
	 */
	
	private JTextArea textAreaConsola;
	private JFrame frmGuiDoServidor;
	private JTextField textNome;
	private JTextField textDist;
	private JTextField textAng;
	private JTextField textRaio;
	private JRadioButton rdbtnOnOff;
	private JButton btnFrente;
	private JButton btnParar;
	private JButton btnRetaguarda;
	private JButton btnDireita;
	private JButton btnEsquerda;
	private JCheckBox chckbxDebug;
	private JCheckBox chckbxVaguear;
	private JCheckBox chckbxEvitar;
	private Servidor serv;
		
	public Servidor getServidor() {
		return serv;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiApp window = new GuiApp();
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
	public GuiApp() {
		initialize();
		frmGuiDoServidor.addKeyListener(this);
		
		frmGuiDoServidor.setVisible( true );
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
		/*
		 * Aqui é para quando queremos fechar a gui.
		 * O robot vai parar, vai fechar a ligação e no fim a janela fecha.
		 * Foram usados métodos da classe servidor.
		 */
		frmGuiDoServidor.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				serv.parar();
				serv.fecharRobo();
                System.exit(0);
			}
		});
		
		textNome = new JTextField();
		textNome.addKeyListener(new KeyListener() {
			

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					/*
					 * Vamos começar com o tratamento de erros quando o utilizador nao insere um nome.
					 * Depois de estar escrito na consola,
					 * vamos dar set ao nome do robot na classe servidor, 
					 * para depois o poder ligar.
					 */
					try {
						if(textNome.getText() == null || textNome.getText().isEmpty()){
							throw new RuntimeException();
						}
						textAreaConsola.append("\r" + textNome.getText() + "\n");
						serv.setNome(textNome.getText());
					}catch(RuntimeException e1) {
						System.out.print("Não foi dado um nome correto!!!" + "\n");
						textAreaConsola.append("\r" + "Não foi dado um nome correto!!!" + "\n");
					}
				}	
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		textNome.setBounds(64, 10, 198, 19);
		frmGuiDoServidor.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Robot");
		lblNewLabel.setBounds(6, 13, 62, 13);
		frmGuiDoServidor.getContentPane().add(lblNewLabel);

		rdbtnOnOff = new JRadioButton("On/Off");
		rdbtnOnOff.setBounds(319, 9, 103, 21);
		rdbtnOnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Vamos começar com o tratamento de erros quando o utilizador nao insere um nome.
				 * Depois de ter dado set do nome. Vamos ligar o robot e estabelecer a ligação.
				 * Vamos começar com o tratamento de erros quando o utilizador nao insere um nome.
				 * Se tiver ligado fica on e ativa caixas de texto, botoes e etc. Se não fica off e 
				 * acontece o contrario.
				 */
				
				
				  try { if(textNome.getText() == null || textNome.getText().isEmpty()){ throw
				  new RuntimeException(); } serv.ligarRobo(); if(serv.esta_ligado() == true) {
				  textAreaConsola.append("\r" + "Robot ON" + "\n"); textDist.setEnabled(true);
				  textAng.setEnabled(true); textRaio.setEnabled(true);
				  btnFrente.setEnabled(true); btnParar.setEnabled(true);
				  btnRetaguarda.setEnabled(true); btnDireita.setEnabled(true);
				  btnEsquerda.setEnabled(true); chckbxDebug.setEnabled(true);
				  chckbxVaguear.setEnabled(true); chckbxEvitar.setEnabled(true);
				  
				  } else { textAreaConsola.append("\r" + "Robot OFF" + "\n");
				  textDist.setEnabled(false); textAng.setEnabled(false);
				  textRaio.setEnabled(false); btnFrente.setEnabled(false);
				  btnParar.setEnabled(false); btnRetaguarda.setEnabled(false);
				  btnDireita.setEnabled(false); btnEsquerda.setEnabled(false);
				  chckbxDebug.setEnabled(false); chckbxVaguear.setEnabled(false);
				  chckbxEvitar.setEnabled(false); } }catch(RuntimeException e1) {
				  System.out.print("Não foi dado um nome correto!!!" + "\n");
				  textAreaConsola.append("\r" + "Não foi dado um nome correto!!!" + "\n"); }
				 	
			}
		});
		
		frmGuiDoServidor.getContentPane().add(rdbtnOnOff);
		
		textDist = new JTextField();
		textDist.addKeyListener(new KeyListener() {
			

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					/*
					 * Fazemos o tratamento de erros caso o utlizador não tenha introduzido um int.
					 * Vamos dar set da distancia na classe servidor,
					 * Temos de dar cast de String para int.
					 */
					try {
						int num = Integer.parseInt(textDist.getText()); 
						if(textDist.getText() == null || textDist.getText().isEmpty() || num != (int)num){
							throw new NumberFormatException();
						}
						textAreaConsola.append("\r" + "Distancia: "+textDist.getText() + "\n");
						serv.setDistancia(num);
					}catch(NumberFormatException e1) {
						System.out.print("Não foi dado uma distancia correta!!!" + "\n");
						textAreaConsola.append("\r" + "Não foi dado uma distancia correta!!!" + "\n");
					}
				}	
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		textDist.setBounds(368, 36, 54, 19);
		frmGuiDoServidor.getContentPane().add(textDist);
		textDist.setColumns(10);
		
		textAng = new JTextField();
		textAng.addKeyListener(new KeyListener() {
			

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					/* Fazemos o tratamento de erros caso o utlizador não tenha introduzido um int.
					 * Vamos dar set do angulo na classe servidor,
					 * Temos de dar cast de String para int.
					 */
					try {
						int num = Integer.parseInt(textAng.getText());
						if(textAng.getText() == null || textAng.getText().isEmpty() || num != (int)num){
							throw new NumberFormatException();
						}
						textAreaConsola.append("\r" + "Angulo: "+textAng.getText() + "\n");
						serv.setAngulo(num);
					}catch(NumberFormatException e1) {
						System.out.print("Não foi dado um angulo correto!!!" + "\n");
						textAreaConsola.append("\r" + "Não foi dado um angulo correto!!!" + "\n"); //Porque é que isto tá a juntar 3 strings separadas?
						//textAreaConsola.append("\r Não foi dado um angulo correto!!! \n"); //Não é melhor mudar todas para este formato?
					}
				}	
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		textAng.setColumns(10);
		textAng.setBounds(208, 39, 54, 19);
		frmGuiDoServidor.getContentPane().add(textAng);
		
		textRaio = new JTextField();
		textRaio.addKeyListener(new KeyListener() {
			

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {				
					/*
					 * Fazemos o tratamento de erros caso o utlizador não tenha introduzido um double.
					 * Vamos dar set do raio na classe servidor,
					 * Temos de dar cast de String para double.
					 */
					try {
						double num = Double.parseDouble(textRaio.getText());
						if(textRaio.getText() == null || textRaio.getText().isEmpty() || num != (double)num){
							throw new NumberFormatException();
						}
						textAreaConsola.append("\r" + "Raio: "+textRaio.getText() + "\n");
						serv.setRaio(num);
					}catch(NumberFormatException e1) {
						System.out.print("Não foi dado um raio correto!!!" + "\n");
						textAreaConsola.append("\r" + "Não foi dado um raio correto!!!" + "\n");
					}				
				}	
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		textRaio.setColumns(10);
		textRaio.setBounds(64, 39, 54, 19);
		frmGuiDoServidor.getContentPane().add(textRaio);
		
		btnFrente = new JButton("Frente");
		btnFrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaConsola.append("\r" + "Frente..." + "\n");
				/*
				 * Fazemos o tratamento de erros caso o utlizador não tenha introduzido um int na distancia.
				 * Depois do set da distancia e clicar no botão frente, vai então usar o 
				 * método frente da classe servidor.
				 */
				try {
					if(textDist.getText() == null || textDist.getText().isEmpty()){
						throw new NumberFormatException();
					}
					textAreaConsola.append("\r" + "Distancia: "+textDist.getText() + "\n");
					serv.frente();
				}catch(NumberFormatException e1) {
					System.out.print("Não foi dado uma distancia correta!!!" + "\n");
					textAreaConsola.append("\r" + "Não foi dado uma distancia correta!!!" + "\n");
				}	
			}
		});
		btnFrente.setForeground(new Color(0, 0, 0));
		btnFrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFrente.setBounds(159, 68, 103, 35);
		frmGuiDoServidor.getContentPane().add(btnFrente);
		
		btnParar = new JButton("Parar");
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaConsola.append("\r" + "Parar..." + "\n");
				/*
				 * Ao clicar no botão parar, vai então usar o 
				 * método parar da classe servidor.
				 */
				serv.parar();
				textAreaConsola.append("\r" + "Parado!!!" + "\n");
			}
		});
		btnParar.setBounds(159, 107, 103, 35);
		frmGuiDoServidor.getContentPane().add(btnParar);
		
		btnRetaguarda = new JButton("Retaguarda");
		btnRetaguarda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaConsola.append("\r" + "Retaguarda..." + "\n");
				/*
				 * Fazemos o tratamento de erros caso o utlizador não tenha introduzido um int na distancia.
				 * Depois do set da distancia e clicar no botão retaguarda, vai então usar o 
				 * método retaguarda da classe servidor.
				 */
				try {
					if(textDist.getText() == null || textDist.getText().isEmpty()){
						throw new NumberFormatException();
					}
					textAreaConsola.append("\r" + "Distancia: "+textDist.getText() + "\n");
					serv.retaguarda();
				}catch(NumberFormatException e1) {
					System.out.print("Não foi dado uma distancia correta!!!" + "\n");
					textAreaConsola.append("\r" + "Não foi dado uma distancia correta!!!" + "\n");
				}	
			}
		});
		btnRetaguarda.setBounds(159, 146, 103, 35);
		frmGuiDoServidor.getContentPane().add(btnRetaguarda);
		
		btnDireita = new JButton("Direita");
		btnDireita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaConsola.append("\r" + "Direita..." + "\n");
				/*
				 * Fazemos o tratamento de erros caso o utlizador não tenha introduzido um double para o raio
				 * e/ou um int para o angulo.
				 * Depois do set do raio e angulo e clicar no botão direita, vai então usar o 
				 * método direita da classe servidor.
				 */
				try {
					double num1 = Double.parseDouble(textRaio.getText());
					int num2 = Integer.parseInt(textAng.getText());
					if(textRaio.getText() == null || textRaio.getText().isEmpty() || num1 != (double)num1 || 
					   textAng.getText() == null || textAng.getText().isEmpty()  || num2 != (int)num2){
						throw new NumberFormatException();
					}
					textAreaConsola.append("\r" + "Raio: "+textRaio.getText() + "\n");
					textAreaConsola.append("\r" + "Angulo: "+textAng.getText() + "\n");
					serv.direita();
				}catch(NumberFormatException e1) {
					System.out.print("Não foi dado um raio e/ou angulo corretos!!!" + "\n");
					textAreaConsola.append("\r" + "Não foi dado um raio e/ou angulo corretos!!!" + "\n");
				}
			}
		});
		btnDireita.setBounds(266, 107, 103, 35);
		frmGuiDoServidor.getContentPane().add(btnDireita);
		
		btnEsquerda = new JButton("Esquerda");
		btnEsquerda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaConsola.append("\r" + "Esquerda..." + "\n");
				/*
				 * Fazemos o tratamento de erros caso o utlizador não tenha introduzido um double para o raio
				 * e/ou um int para o angulo.
				 * Depois do set do raio e angulo e clicar no botão esquerda, vai então usar o 
				 * método esquerda da classe servidor.
				 */
				try {
					double num1 = Double.parseDouble(textRaio.getText());
					int num2 = Integer.parseInt(textAng.getText());
					if(textRaio.getText() == null || textRaio.getText().isEmpty() || num1 != (double)num1 || 
					   textAng.getText() == null || textAng.getText().isEmpty()  || num2 != (int)num2){
						throw new NumberFormatException();
					}
					textAreaConsola.append("\r" + "Raio: "+textRaio.getText() + "\n");
					textAreaConsola.append("\r" + "Angulo: "+textAng.getText() + "\n");
					serv.esquerda();
				}catch(NumberFormatException e1) {
					System.out.print("Não foi dado um raio e/ou angulo corretos!!!" + "\n");
					textAreaConsola.append("\r" + "Não foi dado um raio e/ou angulo corretos!!!" + "\n");
				}	
			}
		});
		btnEsquerda.setBounds(53, 107, 103, 35);
		frmGuiDoServidor.getContentPane().add(btnEsquerda);
		
		chckbxDebug = new JCheckBox("Debug");
		chckbxDebug.setBounds(6, 153, 93, 21);
		frmGuiDoServidor.getContentPane().add(chckbxDebug);
		
		chckbxVaguear = new JCheckBox("Vaguear");
		chckbxVaguear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ter um bool para ver se isto foi ativar ou desativar o vaguear, e criar o vaguear ou matar o vaguear
				/*if(aVaguear && pb.isALive()){
				 * pb.waitFor(); //esperar que acabe o que está a fazer
				 * pb.destroy(); //kill it
				 * aVaguear = false;
				 * }
				 */
				textAreaConsola.append("\r" + "Vaguear..." + "\n");
				serv.setTipo((short)1);
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", "C:\\LEIM\\3SEM\\FSO\\Code\\FSO_PROJETO\\src\\fso\\trab1\\gui\\vaguearExec.jar", "C:\\LEIM\\3SEM\\FSO\\Code\\FSO_PROJETO\\src\\fso\\trab1\\gui\\canal.txt");
				//TODO mudar isto para path genérico
				System.out.print("criado");
				try {
					pb.start();
					System.out.print("começado");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.print("falhado");
				}
			}
		});
		chckbxVaguear.setBounds(337, 146, 93, 21);
		frmGuiDoServidor.getContentPane().add(chckbxVaguear);
		
		chckbxEvitar = new JCheckBox("Evitar");
		chckbxEvitar.setBounds(337, 166, 93, 21);
		frmGuiDoServidor.getContentPane().add(chckbxEvitar);
		
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
		
		textAreaConsola = new JTextArea();
		scrollPane.setViewportView(textAreaConsola);
		
		/*Fica disabled quando se da run a gui até o robot não ligar*/
		/*
		 * textAreaConsola.setEditable(false); textDist.setEnabled(false);
		 * textAng.setEnabled(false); textRaio.setEnabled(false);
		 * btnFrente.setEnabled(false); btnParar.setEnabled(false);
		 * btnRetaguarda.setEnabled(false); btnDireita.setEnabled(false);
		 * btnEsquerda.setEnabled(false); chckbxDebug.setEnabled(false);
		 * chckbxVaguear.setEnabled(false); chckbxEvitar.setEnabled(false);
		 */
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

	@Override
	public void run() {
		serv = new Servidor();
		
	}
	
}
