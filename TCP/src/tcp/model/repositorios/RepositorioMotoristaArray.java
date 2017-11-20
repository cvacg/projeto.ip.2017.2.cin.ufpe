package tcp.model.repositorios;

import tcp.model.entidades.Motorista;
import tcp.model.entidades.PessoaFisica;
import tcp.model.excessoes.MotoristaJaCadastradoException;
import tcp.model.excessoes.MotoristaNaoCadastradoException;
import tcp.model.excessoes.MotoristaNaoEncontradoException;

public class RepositorioMotoristaArray implements RepositorioMotorista {
	private Motorista [] motoristas;
	private int indice;
	
	public RepositorioMotoristaArray() {
		this.motoristas = new Motorista [100];
		this.indice = 0;
	}
	

	public void inserir(Motorista motorista)  throws MotoristaJaCadastradoException{
		
		if (this.existe(motorista.getCNH())==false) {
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


	
	public void remover(String CNH) throws MotoristaNaoCadastradoException {
		if(this.existe(CNH)==true) {
			
				this.motoristas[this.indice] = this.motoristas[this.indice-1];
				this.indice = this.indice -1;
			
		} else {
			throw new MotoristaNaoCadastradoException();
		}
		
		
	}


	
	public void atualizar(Motorista motorista) throws MotoristaNaoEncontradoException {
		this.motoristas[this.getIndice(motorista.getCNH())] = motorista;
		
	}


	
	public Motorista procurar(String CNH) throws MotoristaNaoEncontradoException {
		
		return this.motoristas[this.getIndice(CNH)];
	}


	
	public boolean existe(String CNH) {
		for(int i = 0;i < this.indice;i++){
			if(this.motoristas[i].getCNH().equals(CNH)){
				return true;
			}
		}
	
		return false;
	}
	public int getIndice (String CNH) throws MotoristaNaoEncontradoException{
		for(int i = 0;i < this.indice;i++){
			if(this.motoristas[i].getCNH().equals(CNH)){
				return i;
			}
		}
		throw new  MotoristaNaoEncontradoException();
	}
	
}
