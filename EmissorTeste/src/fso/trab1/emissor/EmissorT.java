package fso.trab1.emissor;

import java.util.Random;

import fso.trab1.canal.CanalComunicacaoMensagens;
import fso.trab1.canal.mensagens.Mensagem;
import fso.trab1.canal.mensagens.MensagemCurvaDir;
import fso.trab1.canal.mensagens.MensagemReta;

public class EmissorT {
	private CanalComunicacaoMensagens canal;
	private Random rnd;
	//private String msg;
	private Mensagem msg;
	
	public static void main(String[] args) {
		EmissorT e = new EmissorT( args );
		System.out.println("Teste emissor (Vfinal?)....");
		
		
		e.run();
	}
	
	public EmissorT(String[] args) {
		this.rnd = new Random();
		this.canal = this.getCanal(args);
		
		this.canal.abrirCanal(args[0]);
	}
	
	private CanalComunicacaoMensagens getCanal(String[] args) {
		CanalComunicacaoMensagens channel = new CanalComunicacaoMensagens();
		
		return channel;
	}

	public void run() {
		int pos=0;
		for(int i=0;; ++i) {
			this.msg = new MensagemReta((short) 30, (short) i);
			boolean res;
			do {
				res = this.canal.enviarMensagem(this.msg);
			}while(!res);
			
			try {
				Thread.sleep(450 + rnd.nextInt(750));
			}catch(InterruptedException e){
				System.out.println("Fui acordado...");
			}
			
		}
		
	}
}
