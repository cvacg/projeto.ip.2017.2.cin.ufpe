package tcp.model.repositorios;

import tcp.model.entidades.Funcionario;
import tcp.model.entidades.PessoaFisica;
import tcp.model.excessoes.FuncionarioJaCadastradoException;
import tcp.model.excessoes.FuncionarioNaoCadastradoException;
import tcp.model.excessoes.FuncionarioNaoEncontradoException;

public class RepositorioFuncionarioArray implements RepositorioFuncionario {
	private Funcionario [] funcionarios;
	private int indice;
	
	public RepositorioFuncionarioArray() {
		this.funcionarios = new Funcionario [100];
		this.indice = 0;
	}
	

	public void inserir(Funcionario funcionario)  throws FuncionarioJaCadastradoException{
		
		if (this.existe(funcionario)==false) {
			this.funcionarios[indice] = funcionario;
			if(this.indice>=this.funcionarios.length-1) {
				Funcionario[] motoristasNovo = new Funcionario[2*this.funcionarios.length];
				for(int i = 0; i < this.funcionarios.length; i++){
					motoristasNovo[i] = this.funcionarios[i];
				}
				this.funcionarios = motoristasNovo;
			}
			indice++;
		}
		else {
			throw new FuncionarioJaCadastradoException();
		}
	}


	
	public void remover(Funcionario funcionario) throws FuncionarioNaoCadastradoException {
		if(this.existe(funcionario)==true) {
			
				this.funcionarios[this.indice] = this.funcionarios[this.indice-1];
				this.indice = this.indice -1;
			
		} else {
			throw new FuncionarioNaoCadastradoException();
		}
		
		
	}


	
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		this.funcionarios[this.getIndice(funcionario)] = funcionario;
		
	}


	
	public Funcionario obter(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		
		return this.funcionarios[this.getIndice(funcionario)];
	}


	
	public boolean existe(Funcionario funcionario) {
		for(int i = 0;i < this.indice;i++){
			if(this.funcionarios[i].equals(funcionario)){
				return true;
			}
		}
	
		return false;
	}
	public int getIndice (Funcionario funcionario) throws FuncionarioNaoEncontradoException{
		for(int i = 0;i < this.indice;i++){
			if(this.funcionarios[i].equals(funcionario)){
				return i;
			}
		}
		throw new  FuncionarioNaoEncontradoException();
	}
	
}
