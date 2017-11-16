package tcp.model.repositorios;

import ClasseNegocio.Motorista;
import exceptions.MotoristaJaCadastradoException;
import exceptions.MotoristaNaoCadastradoException;
import exceptions.MotoristaNaoEncontradoException;

public interface RepositorioMotorista {
		
	void inserir(Motorista motorista) throws MotoristaJaCadastradoException;
	void remover(String CPF) throws MotoristaNaoCadastradoException; 
	void atualizar(Motorista motorista) throws MotoristaNaoEncontradoException; 
	Motorista procurar (String CPF) throws MotoristaNaoEncontradoException;
	boolean existe(String CPF);
}