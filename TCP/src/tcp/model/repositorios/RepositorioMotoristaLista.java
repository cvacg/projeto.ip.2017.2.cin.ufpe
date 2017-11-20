package tcp.model.repositorios;

import tcp.model.entidades.Motorista;
import tcp.model.entidades.PessoaFisica;
import tcp.model.excessoes.MotoristaJaCadastradoException;
import tcp.model.excessoes.MotoristaNaoCadastradoException;
import tcp.model.excessoes.MotoristaNaoEncontradoException;

public class RepositorioMotoristaLista implements RepositorioMotorista {
	private Motorista motorista;
	private RepositorioMotoristaLista proximo;
	
	public RepositorioMotoristaLista() {
		this.motorista = null;
		this.proximo = null;
		
	}
	
	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public RepositorioMotoristaLista getProximo() {
		return proximo;
	}

	public void setProximo(RepositorioMotoristaLista proximo) {
		this.proximo = proximo;
	}

	public void inserir (Motorista motorista) throws MotoristaJaCadastradoException{ {
		if(this.existe(motorista.getCNH())==false){
		if (this.proximo == null) {
			this.motorista = motorista;
			this.proximo = new RepositorioMotoristaLista();
		} else {
			this.proximo.inserir(motorista);
		}
		} else {
			throw new MotoristaJaCadastradoException();
		}
	}
	}
	


	
	public void remover(String CNH) throws MotoristaNaoCadastradoException {
		if(this.existe(CNH)==true){
			if(this.motorista.equals(CNH)){
				this.motorista = this.proximo.motorista;
				this.proximo = this.proximo.proximo;
			}else {
				this.proximo.remover(CNH);
			}
		}
		else {
			throw new MotoristaNaoCadastradoException();
		}
		
	}

	
	public void atualizar(Motorista motorista) throws MotoristaNaoEncontradoException {
		if(this.existe(motorista.getCNH())==true){
			if(this.motorista.equals((((PessoaFisica) motorista.getPessoa()).getCpf()))==true){
				this.motorista = motorista;
			}else {
				this.proximo.atualizar(motorista);
			}
		}
		else {
			throw new MotoristaNaoEncontradoException();
		}
		
	}

	
	public Motorista procurar(String CNH) throws MotoristaNaoEncontradoException {
		if(this.existe(CNH)==true){
			if((motorista.getCNH()).equals(CNH)){
				return this.motorista;
			}else {
				return this.proximo.procurar(CNH);
			}
		}
		throw new MotoristaNaoEncontradoException();
	}

	
	public boolean existe(String CNH) {
		boolean encontrou = false;
		if(this.motorista != null){
			if(((((PessoaFisica) motorista.getPessoa()).getCpf())).equals(CNH)){
				encontrou = true;
			}else {
				this.proximo.existe(CNH);
			}
		}
		return encontrou;
	}

}
