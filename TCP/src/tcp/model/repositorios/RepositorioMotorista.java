package tcp.model.repositorios;

import tcp.model.entidades.Motorista;
import tcp.model.excessoes.MotoristaJaCadastradoException;
import tcp.model.excessoes.MotoristaNaoCadastradoException;
import tcp.model.excessoes.MotoristaNaoEncontradoException;

public interface RepositorioMotorista {
		
	void inserir(Motorista motorista) throws MotoristaJaCadastradoException;
	void remover(String CPF) throws MotoristaNaoCadastradoException; 
	void atualizar(Motorista motorista) throws MotoristaNaoEncontradoException; 
	Motorista procurar (String CPF) throws MotoristaNaoEncontradoException;
	boolean existe(String CPF);
}