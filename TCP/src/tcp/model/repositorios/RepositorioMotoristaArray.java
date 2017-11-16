package tcp.model.repositorios;

import ClasseNegocio.Motorista;
import exceptions.MotoristaJaCadastradoException;
import exceptions.MotoristaNaoCadastradoException;
import exceptions.MotoristaNaoEncontradoException;

public class RepositorioMotoristaArray implements RepositorioMotorista {
	private Motorista [] motoristas;
	private int indice;
	
	public RepositorioMotoristaArray() {
		this.motoristas = new Motorista [100];
		this.indice = 0;
	}
	

	public void inserir(Motorista motorista)  throws MotoristaJaCadastradoException{
		if (this.existe(motorista.getCPF())==false) {
			this.motoristas[indice] = motorista;
			if(this.indice>=this.motoristas.length-1) {
				Motorista[] motoristasNovo = new Motorista[2*this.motoristas.length];
				for(int i = 0; i < this.motoristas.length; i++){
					motoristasNovo[i] = this.motoristas[i];
				}
				this.motoristas = motoristasNovo;
			}
			indice++;
		}
		else {
			throw new MotoristaJaCadastradoException();
		}
	}


	
	public void remover(String CPF) throws MotoristaNaoCadastradoException {
		if(this.existe(CPF)==true) {
			if(this.motoristas.equals(CPF)) {
				this.motoristas[this.indice] = this.motoristas[this.indice-1];
				this.indice = this.indice -1;
			}
		} else {
			throw new MotoristaNaoCadastradoException();
		}
		
		
	}


	
	public void atualizar(Motorista motorista) throws MotoristaNaoEncontradoException {
		this.motoristas[this.getIndice(motorista.getCPF())] = motorista;
		
	}


	
	public Motorista procurar(String CPF) throws MotoristaNaoEncontradoException {
		
		return this.motoristas[this.getIndice(CPF)];
	}


	
	public boolean existe(String CPF) {
		for(int i = 0;i < this.indice;i++){
			if(this.motoristas[i].getCPF().equals(CPF)){
				return true;
			}
		}
	
		return false;
	}
	public int getIndice (String CPF) throws MotoristaNaoEncontradoException{
		for(int i = 0;i < this.indice;i++){
			if(this.motoristas[i].getCPF().equals(CPF)){
				return i;
			}
		}
		throw new  MotoristaNaoEncontradoException();
	}
	
}
