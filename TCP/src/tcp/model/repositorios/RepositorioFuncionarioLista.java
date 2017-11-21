package tcp.model.repositorios;

import tcp.model.entidades.Funcionario;
import tcp.model.entidades.PessoaFisica;
import tcp.model.excessoes.FuncionarioJaCadastradoException;
import tcp.model.excessoes.FuncionarioNaoCadastradoException;
import tcp.model.excessoes.FuncionarioNaoEncontradoException;

public class RepositorioFuncionarioLista implements RepositorioFuncionario {
	private Funcionario funcionario;
	private RepositorioFuncionarioLista proximo;
	
	public RepositorioFuncionarioLista() {
		this.funcionario = null;
		this.proximo = null;
		
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public RepositorioFuncionarioLista getProximo() {
		return proximo;
	}

	public void setProximo(RepositorioFuncionarioLista proximo) {
		this.proximo = proximo;
	}

	public void inserir (Funcionario funcionario) throws FuncionarioJaCadastradoException{ {
		if(this.igual(funcionario)==false){
		if (this.proximo == null) {
			this.funcionario = funcionario;
			this.proximo = new RepositorioFuncionarioLista();
		} else {
			this.proximo.inserir(funcionario);
		}
		} else {
			throw new FuncionarioJaCadastradoException();
		}
	}
	}
	


	
	public void remover(Funcionario funcionario) throws FuncionarioNaoCadastradoException {
		if(this.igual(funcionario)==true){
			if(this.funcionario.equals(funcionario)){
				this.funcionario = this.proximo.funcionario;
				this.proximo = this.proximo.proximo;
			}else {
				this.proximo.remover(funcionario);
			}
		}
		else {
			throw new FuncionarioNaoCadastradoException();
		}
		
	}

	
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		if(this.igual(funcionario)==true){
			if(this.funcionario.equals(funcionario)){
				this.funcionario = funcionario;
			} else {
				this.proximo.atualizar(funcionario);
			}
		}else {
			throw new FuncionarioNaoEncontradoException();
		}
		
	}

	
	public Funcionario obter(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		if(this.igual(funcionario)==true){
			if((funcionario).equals(funcionario)){
				return this.funcionario;
			}else {
				return this.proximo.obter(funcionario);
			}
		}
		throw new FuncionarioNaoEncontradoException();
	}

	
	

}
