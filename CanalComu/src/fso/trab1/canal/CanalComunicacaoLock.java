package fso.trab1.canal;

import java.io.IOException;
import java.nio.channels.FileLock;

public class CanalComunicacaoLock extends Canalcomunicacao{

	@Override
	public void enviarMensagem(String msg) {
		FileLock fl = null;
		try {
			fl = this.canal.lock();
			super.enviarMensagem(msg);
			
		} catch (IOException e) {
			throw new IllegalArgumentException("Erro ao fazer lock");
		}finally {
			if(fl!=null) {
				try {
					fl.release();
				}catch(IOException e) {
					throw new IllegalArgumentException("Erro ao fazer unlock");
				}
			}
		}
	}
	
	@Override
	public String receberMensagem() {
		FileLock fl = null;
		String res = "";
		try {
			fl = this.canal.lock();
			res = super.receberMensagem();
			
		} catch (IOException e) {
			throw new IllegalArgumentException("Erro ao fazer lock");
		}finally {
			if(fl!=null) {
				try {
					fl.release();
				}catch(IOException e) {
					throw new IllegalArgumentException("Erro ao fazer unlock");
				}
			}
		}
		return res;
	}
}
