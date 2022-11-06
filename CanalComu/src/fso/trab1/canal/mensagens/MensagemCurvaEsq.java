package fso.trab1.canal.mensagens;

public class MensagemCurvaEsq extends Mensagem{

	public MensagemCurvaEsq(short raio, short angulo, short id) {
		super(Mensagem.tipoCurvaEsq, raio, angulo, id);
	}
	
	public short getRaio() {
		return this.getParam1();
	}
	
	public short getAngulo() {
		return this.getParam2();
	}
	
	@Override
	public String toString() {
		return "Curva Esquerda, Raio: "+ getRaio() + " Angulo: " + getAngulo() + " id: " + Integer.toString(super.getid());
	}
}
