package tcp.model.cadastros;

import tcp.model.repositorios.RepositorioMotorista;
import tcp.model.entidades.Motorista;
import tcp.model.excessoes.MotoristaJaCadastradoException;
import tcp.model.excessoes.MotoristaNaoCadastradoException;
import tcp.model.excessoes.MotoristaNaoEncontradoException;

public class CadastroMotorista {
 private RepositorioMotorista motoristas;
 
 public CadastroMotorista(RepositorioMotorista motoristas) {
	 this.motoristas = motoristas;
 }
 public void cadastrar(Motorista motorista) throws MotoristaJaCadastradoException{
		if(!motoristas.existe(motorista.getCPF())){
			motoristas.inserir(motorista);			
		}
		else {
			throw new MotoristaJaCadastradoException();
		}
	}
	
	public void remover(String CPF) throws MotoristaNaoCadastradoException{
		if(motoristas.existe(CPF)){
			motoristas.remover(CPF);		
		}
		else {
			throw new MotoristaNaoCadastradoException();
		}
	}
	
	public void atualizar(String CPF, Motorista motorista) throws MotoristaNaoEncontradoException{
		if(motoristas.existe(CPF)){
			motoristas.atualizar(motorista);		
		}
		else {
			throw new MotoristaNaoEncontradoException();
		}
	}
	
	public Motorista procurar(String CPF) throws MotoristaNaoEncontradoException{
		if(motoristas.existe(CPF)){
			return motoristas.procurar(CPF);
		
		}
		else {
			throw new MotoristaNaoEncontradoException();
		}
	
	}
}
