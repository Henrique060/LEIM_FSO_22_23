package fso.trab1.recetor;

import java.util.Objects;

import fso.trab1.canal.CanalComunicacaoMensagens;
import fso.trab1.canal.mensagens.Mensagem;
import fso.trab1.canal.mensagens.MensagemReta;

public class RecetorT {

	private CanalComunicacaoMensagens canal;

	public RecetorT(String[] args) {
		canal = new CanalComunicacaoMensagens();
		this.canal.abrirCanal(args[0]);
	}

	public static void main(String[] args) {
		RecetorT r = new RecetorT( args );
		System.out.println("Recetor (V5): ");
		
		
		r.run();

	}

	private void run() {
		//Mensagem msgAntiga = null;
		
		for(;;) {
			Mensagem msgAtual = this.canal.receberMensagemM();
			if(Objects.nonNull(msgAtual)) {
				System.out.println( msgAtual.toString());
//				if(!msgAtual.compareTo(msgAntiga)) {
//					System.out.println( msgAtual.toString());
//					
//					msgAntiga = msgAtual;
//				}
			}
		}
		
	}
	
	

}
