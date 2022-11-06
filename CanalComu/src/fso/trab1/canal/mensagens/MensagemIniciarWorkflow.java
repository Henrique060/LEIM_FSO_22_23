package fso.trab1.canal.mensagens;

public class MensagemIniciarWorkflow extends Mensagem{

	public MensagemIniciarWorkflow(short id) {
		super(Mensagem.tipoIniciarWorkflow, (short)0, (short)0, id);
		
	}
	
	@Override
	public String toString() {
		return "Iniciar Workflow " + " id: " + Integer.toString(super.getid());
	}

}
