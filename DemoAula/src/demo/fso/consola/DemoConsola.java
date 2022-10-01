package demo.fso.consola;

import robot.RobotLegoEV3;

public class DemoConsola {

	public static void main(String[] args) throws InterruptedException {
		RobotLegoEV3 r = new RobotLegoEV3();
		if(r.OpenEV3("EV3") == true) {
			r.Reta(10);
			r.CurvarDireita(360, 0);
			r.Reta(-10);
			r.Parar(false);
			
			Thread.sleep(30 * 1000); //fazer uma pausa de 30 segundos
			
			r.CloseEV3();
		}

	}

}
