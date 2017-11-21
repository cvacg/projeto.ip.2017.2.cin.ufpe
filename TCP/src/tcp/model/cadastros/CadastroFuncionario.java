package tcp.model.cadastros;

import tcp.model.repositorios.RepositorioFuncionario;
import tcp.model.entidades.Funcionario;
import tcp.model.entidades.PessoaFisica;
import tcp.model.excessoes.FuncionarioJaCadastradoException;
import tcp.model.excessoes.FuncionarioNaoCadastradoException;
import tcp.model.excessoes.FuncionarioNaoEncontradoException;

public class CadastroFuncionario {
 private RepositorioFuncionario funcionarios;
 
 public CadastroFuncionario(RepositorioFuncionario motoristas) {
	 this.funcionarios = motoristas;
 }
 
 public void cadastrar(Funcionario funcionario) throws FuncionarioJaCadastradoException{
		if(funcionarios.igual(funcionario)==false){
			funcionarios.inserir(funcionario);			
		}
		else {
			throw new FuncionarioJaCadastradoException();
		}
	}
	
	public void remover(Funcionario funcionario) throws FuncionarioNaoCadastradoException{
		if(funcionarios.igual(funcionario)==true){
			funcionarios.remover(funcionario);		
		}
		else {
			throw new FuncionarioNaoCadastradoException();
		}
	}
	
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException{
		if(funcionarios.igual(funcionario)==true){
			funcionarios.atualizar(funcionario);		
		}
		else {
			throw new FuncionarioNaoEncontradoException();
		}
	}
	
	public Funcionario obter(Funcionario funcionario) throws FuncionarioNaoEncontradoException{
		if(funcionarios.igual(funcionario)==true){
			return funcionarios.obter(funcionario);
		
		}
		else {
			throw new FuncionarioNaoEncontradoException();
		}
	
	}
}
