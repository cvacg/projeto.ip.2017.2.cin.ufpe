package tcp.model.cadastros;

import tcp.model.repositorios.RepositorioMotorista;
import tcp.model.entidades.Motorista;
import tcp.model.entidades.PessoaFisica;
import tcp.model.excessoes.MotoristaJaCadastradoException;
import tcp.model.excessoes.MotoristaNaoCadastradoException;
import tcp.model.excessoes.MotoristaNaoEncontradoException;

public class CadastroMotorista {
 private RepositorioMotorista motoristas;
 
 public CadastroMotorista(RepositorioMotorista motoristas) {
	 this.motoristas = motoristas;
 }
 
 public void cadastrar(Motorista motorista) throws MotoristaJaCadastradoException{
		if(motoristas.existe(motorista.getCNH())==false){
			motoristas.inserir(motorista);			
		}
		else {
			throw new MotoristaJaCadastradoException();
		}
	}
	
	public void remover(String CPF) throws MotoristaNaoCadastradoException{
		if(motoristas.existe(CPF)==true){
			motoristas.remover(CPF);		
		}
		else {
			throw new MotoristaNaoCadastradoException();
		}
	}
	
	public void atualizar(String CPF, Motorista motorista) throws MotoristaNaoEncontradoException{
		if(motoristas.existe(CPF)==true){
			motoristas.atualizar(motorista);		
		}
		else {
			throw new MotoristaNaoEncontradoException();
		}
	}
	
	public Motorista procurar(String CNH) throws MotoristaNaoEncontradoException{
		if(motoristas.existe(CNH)==true){
			return motoristas.procurar(CNH);
		
		}
		else {
			throw new MotoristaNaoEncontradoException();
		}
	
	}
}
