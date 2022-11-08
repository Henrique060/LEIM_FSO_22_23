package fso.trab1.canal.mensagens;

public class MensagemParar extends Mensagem{
	public MensagemParar(short estado, short id) {
		super(Mensagem.tipoParar, estado, (short) 0, id);
	}
	
	public boolean getEstado() {
		if(this.getParam1() == 0) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Parado: "+ this.getParam1() + " id: " + Integer.toString(super.getid());
	}
}
