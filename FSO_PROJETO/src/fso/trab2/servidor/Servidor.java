package fso.trab2.servidor;

import robot.RobotLegoEV3;
import java.awt.EventQueue;

import java.lang.reflect.InvocationTargetException;
import fso.trab2.gui.GuiAPP;


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
	
	
	public short estado = 1;
	
	public Servidor() {
		System.out.println("servidor criado");	
		this.r = new RobotLegoEV3();
	}
	

	
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
		r.Reta(getDistancia());
		r.Parar(false);
		
	}
	
	public void esquerda() {
		r.CurvarEsquerda(getRaio(), getAngulo());
		r.Parar(false);
		
	}
	
	public void direita() {
		r.CurvarDireita(getRaio(), getAngulo());
		r.Parar(false);
		
	}
	
	public void retaguarda() {
		r.Reta(getDistancia());
		r.Parar(false);
		
	}
	
	public void parar() {
		r.Parar(true);
	}
	
	
	
	
	public void run() {
		System.out.println("maquina de estados ativa");
			
		//r.OpenEV3("EV3"); //teste para tentar abrir o robot sem ter fisico
		
		for(;;) {
			try {
				
				
			} catch (Exception e) {
				
			}
		}
		
	}
	
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		
		System.out.println("main chamado");
		GuiAPP g = new GuiAPP();
		EventQueue.invokeAndWait(g);
		System.out.println("antes de g run");
		g.getServidor().run();
	}
}
