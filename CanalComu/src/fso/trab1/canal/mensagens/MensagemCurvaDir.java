package fso.trab1.canal.mensagens;

public class MensagemCurvaDir extends Mensagem{

	public MensagemCurvaDir(short raio, short angulo, short id) {
		super(Mensagem.tipoCurvaDir, raio, angulo, id);
	}
	
	public short getRaio() {
		return this.getParam1();
	}
	
	public short getAngulo() {
		return this.getParam2();
	}
	
	@Override
	public String toString() {
		return "Curva Direita, Raio: "+ getRaio() + " Angulo: " + getAngulo() + " id: " + Integer.toString(super.getid());
	}
}
