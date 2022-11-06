package fso.trab1.canal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Canalcomunicacao {
// ficheiro
	private File ficheiro;
// canal que liga o conte�do do ficheiro ao Buffer
	protected FileChannel canal;
// buffer
	protected MappedByteBuffer buffer;
// dimens�o m�xima em bytes do buffer
	final int BUFFER_MAX = 55;

// construtor onde se cria o canal
	public Canalcomunicacao() {
		ficheiro = null;
		canal = null;
		buffer = null;
	}

// abre o canal de comunica��o
	public boolean abrirCanal(String fichName) {
		// cria um ficheiro com o nome comunicacao.dat
		ficheiro = new File(fichName);
		// cria um canal de comunica��o de leitura e escrita
		try {
			canal = new RandomAccessFile(ficheiro, "rw").getChannel();
		} catch (FileNotFoundException e) {
			return false;
		}
		// mapeia para mem�ria o conte�do do ficheiro
		try {
			buffer = canal.map(FileChannel.MapMode.READ_WRITE, 0, BUFFER_MAX);
		} catch (IOException e) {
			return false;
		}
		
		//Iniciar o buffer circular
		buffer.position(0);
		//primeiro espa�o - n�mero de mensagens
		buffer.putShort((short) 0);
		//segundo espa�o - idPut
		buffer.putShort((short) 6);
		//terceiro espa�o - idGet
		buffer.putShort((short) 6);
		System.out.println("Buffer inicializado ");
		return true;
	}

// recebe uma mensagem convertendo-a numa String
	public String receberMensagem() {
		String msg = new String();
		char c;
		buffer.position(0);
		while ((c = buffer.getChar()) != '\0')
			msg += c;
		return msg;
	}

// envia uma String como mensagem
	public void enviarMensagem(String msg) {
		char c;
		buffer.position(0);
		for (int i = 0; i < msg.length(); ++i) {
			c = msg.charAt(i);
			buffer.putChar(c);
		}
		buffer.putChar('\0');

	}

// fecha o canal de comunica��o
	public void fecharCanal() {
		if (canal != null)
			try {
				canal.close();
			} catch (IOException e) {
				canal = null;
			}
	}

}
