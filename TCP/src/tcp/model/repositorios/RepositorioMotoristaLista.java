package tcp.model.repositorios;

import ClasseNegocio.Motorista;
import exceptions.MotoristaJaCadastradoException;
import exceptions.MotoristaNaoCadastradoException;
import exceptions.MotoristaNaoEncontradoException;

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
		if(!this.existe(motorista.getCPF())){
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
	
	public void remover (Motorista motorista) {
		if (this.motorista.equals(motorista)) {
			this.motorista = this.proximo.motorista;
			this.proximo = this.proximo.proximo;
			
		} else {
			this.proximo.remover(motorista);
		}
	}
	

	
	public void remover(String CPF) throws MotoristaNaoCadastradoException {
		if(this.existe(CPF)){
			if(this.motorista.equals(CPF)){
				this.motorista = this.proximo.motorista;
				this.proximo = this.proximo.proximo;
			}else {
				this.proximo.remover(CPF);
			}
		}
		else {
			throw new MotoristaNaoCadastradoException();
		}
		
	}

	
	public void atualizar(Motorista motorista) throws MotoristaNaoEncontradoException {
		if(this.existe(motorista.getCPF())){
			if(this.motorista.equals(motorista.getCPF())){
				this.motorista = motorista;
			}else {
				this.proximo.atualizar(motorista);
			}
		}
		else {
			throw new MotoristaNaoEncontradoException();
		}
		
	}

	
	public Motorista procurar(String CPF) throws MotoristaNaoEncontradoException {
		if(this.existe(CPF)){
			if(this.motorista.getCPF().equals(CPF)){
				return this.motorista;
			}else {
				return this.proximo.procurar(CPF);
			}
		}
		throw new MotoristaNaoEncontradoException();
	}

	
	public boolean existe(String CPF) {
		boolean encontrou = false;
		if(this.motorista != null){
			if(this.motorista.getCPF().equals(CPF)){
				encontrou = true;
			}else {
				this.proximo.existe(CPF);
			}
		}
		return encontrou;
	}

}
