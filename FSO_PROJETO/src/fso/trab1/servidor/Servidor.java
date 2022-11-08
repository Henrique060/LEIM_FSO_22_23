package fso.trab1.servidor;

import robot.RobotLegoEV3;
import java.awt.EventQueue;

import java.lang.reflect.InvocationTargetException;

import fso.trab1.canal.CanalComunicacaoMensagens;
import fso.trab1.canal.mensagens.Mensagem;
import fso.trab1.canal.mensagens.MensagemCurvaDir;
import fso.trab1.canal.mensagens.MensagemCurvaEsq;
import fso.trab1.canal.mensagens.MensagemParar;
import fso.trab1.canal.mensagens.MensagemReta;
import fso.trab1.gui.GuiApp;


public class Servidor implements Runnable{
	private String nome;
	private int dist, ang;
	private double raio;
	//private RobotLegoEV3 r = new RobotLegoEV3();
	private RobotLegoEV3 r ; // robot 1
	//private CanalComunicacaoLock c;
	boolean mensagem = false;
	
	public final short desligado = 1;
	public final short espera    = 2;
	public final short vaguear   = 3;
	public final short evitar    = 4;
	public final short frente    = 5;
	public final short direita   = 6;
	
	public short mensagemtipo = 0;
	
	private CanalComunicacaoMensagens c;
	
	public short estado = 1;
	
	public Servidor() {
		this.c = new CanalComunicacaoMensagens();
		c.abrirCanal("teste_vaguear.txt");
		//MensagemParar msg = new MensagemParar((short) 1);
		//c.enviarMensagem(msg);
		System.out.println("servidor criado");	
		this.r = new RobotLegoEV3();
	}
	
	public short getTipo() {
		return mensagemtipo;
	}
	
	public void setTipo(short tipo) {
		this.mensagemtipo = tipo;
	}
	
	/*1- getters e setters.
	 *2- Ligar, desligar e verificar ligação.
	 *3- Métodos para os botões da GUI usando os getters.
	 */
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	public double getRaio() {
		return raio;
	}
	
	public void setAngulo(int ang) {
		this.ang = ang;
	}
	
	public int getAngulo() {
		return ang;
	}
	
	public void setDistancia(int dist) {
		this.dist = dist;
	}
	
	public int getDistancia() {
		return dist;
	}
	
	public void ligarRobo() {
		r.OpenEV3(getNome());
	}
	
	public void fecharRobo() {
		r.CloseEV3();
	}
	
	public boolean esta_ligado() {
		if(r.OpenEV3(getNome()) == true) {
			return true;
		}
		return false;
	}
	
	public void frente() {
		//r.Reta(getDistancia());
		//r.Parar(false);
		
		MensagemReta msg = new MensagemReta((short) getDistancia(), (short) 1);
		c.enviarMensagem(msg);
		
	}
	
	public void esquerda() {
		//r.CurvarEsquerda(getRaio(), getAngulo());
		//r.Parar(false);
		
		MensagemCurvaEsq msg = new MensagemCurvaEsq((short) getRaio(), (short) getAngulo(), (short) 3);
		c.enviarMensagem(msg);
		
	}
	
	public void direita() {
		//r.CurvarDireita(getRaio(), getAngulo());
		//r.Parar(false);
		
		MensagemCurvaDir msg = new MensagemCurvaDir((short) getRaio(), (short) getAngulo(), (short) 2);
		c.enviarMensagem(msg);
		
	}
	
	public void retaguarda() {
		//r.Reta(getDistancia());
		//r.Parar(false);
		
		MensagemReta msg = new MensagemReta((short) getDistancia(), (short) 1);
		c.enviarMensagem(msg);
		
	}
	
	public void parar() {
		//r.Parar(true);
		
		MensagemParar msg = new MensagemParar((short) 1, (short) 5);
		c.enviarMensagem(msg);
		
	}
	
	
	
	
	public void run() {
		System.out.println("maquina de estados ativa");
			
		//r.OpenEV3("EV3"); //teste para tentar abrir o robot sem ter fisico
		//this.c = new CanalComunicacaoMensagens();
		c.abrirCanal("C:\\LEIM\\3SEM\\FSO\\Code\\FSO_PROJETO\\src\\fso\\trab1\\gui\\canal.txt"); //testes de simulação (??) perguntar ao stor
		//TODO este path tem de ser genérico ou vai fazer kaput no PC do professor
		//tipo "../gui/canal.txt"
		for(;;) {
			try {
				//Mensagem msg;
				
					//System.out.println("A receber mensagem.... ");
					//msg = c.receberMensagemM();
					//System.out.println( msg.toString());
					//System.out.println("Mensagem recebida ");
					
					/*
					 * switch(getTipo()) {
					 * 
					 * case 1: ProcessBuilder pb = new ProcessBuilder("java", "-jar",
					 * "C:\\LEIM\\3SEM\\FSO\\Code\\FSO_PROJETO\\src\\fso\\trab1\\gui\\vaguearExec.jar",
					 * "C:\\LEIM\\3SEM\\FSO\\Code\\FSO_PROJETO\\src\\fso\\trab1\\gui\\canal.txt");
					 * //pb.command(
					 * "C:\\LEIM\\3SEM\\FSO\\Code\\FSO_PROJETO\\src\\fso\\trab1\\gui\\vaguearExec.jar"
					 * ); //pb.directory(new
					 * File("C:\\LEIM\\3SEM\\FSO\\Code\\FSO_PROJETO\\src\\fso\\trab1\\gui"));
					 * System.out.print("criado"); try { pb.start(); System.out.print("começado"); }
					 * catch (IOException e1) { // TODO Auto-generated catch block
					 * e1.printStackTrace(); System.out.print("falhado"); } break; }
					 */
					
					
					Mensagem msg;
					
					//System.out.println("A receber mensagem.... ");
					msg = c.receberMensagemM();
					
					
					//servidor abaixo foi teste inicial para 
					//valores simples de movimento
					switch(msg.getTipo()){
					
						case Mensagem.tipoReta:
							MensagemReta msgReta = (MensagemReta)msg; //cast à mensagem original para ter o valor de reta
							r.Reta(msgReta.getDistancia()); //verificar que getDistancia está hard coded a '2' para testes -> MUDAR PARA FINAL
							System.out.println("Tipo Reta");
							break;
							
						case Mensagem.tipoCurvaDir:
							MensagemCurvaDir msgDireita = (MensagemCurvaDir)msg;
							r.CurvarDireita(msgDireita.getRaio(),msgDireita.getAngulo());
							System.out.println("Tipo Curva Direita");
							break;
						
						case Mensagem.tipoCurvaEsq:
							MensagemCurvaEsq msgEsquerda = (MensagemCurvaEsq)msg;
							r.CurvarEsquerda(msgEsquerda.getRaio(),msgEsquerda.getAngulo());
							System.out.println("Tipo Curva Esquerda");
							break;
							
						case Mensagem.tipoParar:
							MensagemParar msgPara = (MensagemParar)msg;
							System.out.println("Tipo Parar");
							r.Parar(msgPara.getEstado());
						
							break;
							
					}
			} catch (Exception e) {
				
			}
		}
		
	}
	
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		
		System.out.println("main chamado");
		GuiApp g = new GuiApp();
		EventQueue.invokeAndWait(g);
		System.out.println("antes de g run");
		g.getServidor().run();
		//g.run(); -> não será necesserário visto que o main chama o runnable
	}
}
