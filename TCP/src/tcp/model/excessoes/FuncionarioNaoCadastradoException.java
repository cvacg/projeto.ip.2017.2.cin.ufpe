package tcp.model.excessoes;

public class FuncionarioNaoCadastradoException extends Exception {
	
	public FuncionarioNaoCadastradoException() {
		super ("MOTORISTA NÃO CADASTRADO");
	}
}