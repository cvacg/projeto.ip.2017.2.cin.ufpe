package tcp.model.repositorios;

import tcp.model.entidades.Funcionario;
import tcp.model.excessoes.FuncionarioJaCadastradoException;
import tcp.model.excessoes.FuncionarioNaoCadastradoException;
import tcp.model.excessoes.FuncionarioNaoEncontradoException;

public interface RepositorioFuncionario {
		
	void inserir(Funcionario funcionario) throws FuncionarioJaCadastradoException;
	void remover(Funcionario funcionario) throws FuncionarioNaoCadastradoException; 
	void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException; 
	Funcionario obter (Funcionario funcionario) throws FuncionarioNaoEncontradoException;
	
}