package fso.trab1.canal.mensagens;

public class MensagemParar extends Mensagem{
	public MensagemParar(short estado, short id) {
		super(Mensagem.tipoParar, estado, (short) 0, id);
	}
	
	public short getEstado() {
		return this.getParam1();
	}
	
	@Override
	public String toString() {
		return "Parado: "+ this.getParam1() + " id: " + Integer.toString(super.getid());
	}
}
