package fso.trab1.canal.mensagens;

public class MensagemReta extends Mensagem{
	
	public MensagemReta(short distancia, short id) {
		super(Mensagem.tipoReta, distancia, (short) 0, id);
		this.setParam1(distancia);
	}

	public short getDistancia() {
		return this.getParam1();
	}
	
	@Override
	public String toString() {
		return "Reta: "+ this.getParam1() + " id: " + Integer.toString(super.getid());
	}
}
