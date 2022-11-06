package fso.trab1.vaguear;

import java.util.Random;
import fso.trab1.canal.CanalComunicacaoMensagens;
import fso.trab1.canal.mensagens.Mensagem;
import fso.trab1.canal.mensagens.MensagemCurvaDir;
import fso.trab1.canal.mensagens.MensagemCurvaEsq;
import fso.trab1.canal.mensagens.MensagemReta;


public class Vaguear {
	
	private CanalComunicacaoMensagens canal;
	private Random rnd;
	private Mensagem msg;
	
	public Vaguear(String[] args) {
		this.rnd = new Random();
		this.canal = this.getCanal(args);
		this.canal.abrirCanal(args[0]);
		
	}
	
	private CanalComunicacaoMensagens getCanal(String[] args) {
		CanalComunicacaoMensagens channel = new CanalComunicacaoMensagens();
		return channel;
	}
	
	public void run() {
		int pos = 0;
		
		for(;;) {
			//criar os random ints dentro do for para que
			//cada iteração tenha o seu numero proprio
			int rand_int = rnd.nextInt(50);
			int rand_angulo = rnd.nextInt(360);
			int rand_raio = rnd.nextInt(50);
			
			//random para decidir qual a mensagem
			int msg_escolhida = rnd.nextInt(3);
			
			switch(msg_escolhida) {
				
			case 0:
				this.msg = new MensagemReta((short) rand_int,(short) 1);
				break;
			case 1:
				this.msg = new MensagemCurvaDir((short) rand_raio, (short) rand_angulo, (short) 2);
				break;
			case 2:
				this.msg = new MensagemCurvaEsq((short) rand_raio, (short) rand_angulo, (short) 3);
				break;
			}
			
			
			boolean res;
			do {
				res = this.canal.enviarMensagem(this.msg);
			} while(!res);
			
			try {
				Thread.sleep(450 + rnd.nextInt(750));
			} catch (InterruptedException e) {
				System.out.println("Fui acordado...");
			}
		}
	}
	
	public static void main(String[] args) {
		Vaguear v = new Vaguear(args);
		System.out.println("Teste vaguear...");
		v.run();
	}
	
}
