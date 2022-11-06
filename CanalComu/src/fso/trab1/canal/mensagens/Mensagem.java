package fso.trab1.canal.mensagens;

public class Mensagem {

	public final static short tipoReta = 0;
	public final static short tipoCurvaDir = 1;
	public final static short tipoCurvaEsq = 2;
	public final static short tipoParar = 3;
	public final static short tipoIniciarWorkflow = 4;
	public final static short tipoFimWorkflow = 5;
	private short mensagemParam1;
	private short mensagemParam2;
	private short mensagemTipo;
	private short id;
	
	public Mensagem(short mensagemTipo, short mensagemParam1, short mensagemParam2, short id) {
		this.mensagemTipo = mensagemTipo;
		this.mensagemParam1 = mensagemParam1;
		this.mensagemParam2 = mensagemParam2;
		this.id = id;
	}
	
	public short getTipo() {
		return mensagemTipo;
	}
	
	public short getParam1() {
		return mensagemParam1;
	}
	
	public short getParam2() {
		return mensagemParam2;
	}
	
	public short getid() {
		return id;
	}
	
	public short setTipo(short tipo) {
		tipo = this.mensagemTipo;
		return tipo;
	}
	
	public short setParam1(short param1) {
		param1 = this.mensagemParam1;
		return param1;
	}
	
	public short setParam2(short param2) {
		param2 = this.mensagemParam2;
		return param2;
	}
	
	public short id(short id) {
		id = this.id;
		return id;
	}
	
	public String toString() {
		return "Tipo: " + Integer.toString(mensagemTipo) + ", Param1: " + Integer.toString(mensagemParam1)+
				", Param2: " + Integer.toString(mensagemParam2) + " id: " + Integer.toString(id);
	}
	
	public boolean compareTo(Mensagem msg) {
		if(this.mensagemTipo == msg.mensagemTipo && this.mensagemParam1 == msg.mensagemParam1 && this.mensagemParam2 == msg.mensagemParam2) {
			return true;
		}
		return false;
	}
}