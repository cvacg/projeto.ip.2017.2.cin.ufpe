package tcp.model.excessoes;

public class FuncionarioJaCadastradoException extends Exception {
	
	public FuncionarioJaCadastradoException() {
		super ("MOTORISTA JÁ CADASTRADO");
	}
}