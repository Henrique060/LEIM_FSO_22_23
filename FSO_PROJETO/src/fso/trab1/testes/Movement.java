package fso.trab1.testes;

import robot.RobotLegoEV3;

public class Movement {

	RobotLegoEV3 r = new RobotLegoEV3();
	
	public void ligar(String nome_robot) {
		r.OpenEV3(nome_robot);
	}
	
	public void desligar() {
		r.CloseEV3();
	}
	
	public void andar_frente(String nome_robot) throws InterruptedException {
		if(r.OpenEV3(nome_robot) == true) {
			r.Reta(100);
			r.Parar(false);
			//Thread.sleep(10 * 1000);
		}
	}
	
	public void andar_tras(String nome_robot) throws InterruptedException {
		if(r.OpenEV3(nome_robot) == true) {
			r.Reta(-10);
			r.Parar(false);
			//Thread.sleep(10 * 1000);
		}
	}
	
	public void curvar_esquerda(String nome_robot) throws InterruptedException {
		if(r.OpenEV3(nome_robot) == true) {
			r.CurvarEsquerda(20, 60);
			//Thread.sleep(10 * 1000);
		}
	}
	
	public void curvar_direita(String nome_robot) throws InterruptedException {
		if(r.OpenEV3(nome_robot) == true) {
			r.CurvarDireita(20, 60);
			r.Parar(false);
			//Thread.sleep(10 * 1000);
			
		}
	}
	
	public void parar(String nome_robot) throws InterruptedException{
		if(r.OpenEV3(nome_robot) == true) {
			r.Parar(true);
			//r.CloseEV3();
		}
	}
	
	public boolean esta_ligado(String nome_robot) {
		if(r.OpenEV3(nome_robot) == true) {
			return true;
		}
		return false;
	}
	
	//TODO 
	/**
	 * fazer funçoes para guardar raio, angulo e distancia para usar como handler
	 * de modo a poder usar no key pressed enter
	 */

}
