package fso.trab1.canal.mensagens;

public class MensagemFimWorkflow extends Mensagem{

	public MensagemFimWorkflow(short id) {
		super(Mensagem.tipoFimWorkflow, (short)0, (short)0, id);
		
	}
	
	@Override
	public String toString() {
		return "Fim do Workflow " + " id: " + Integer.toString(super.getid());
	}

}
