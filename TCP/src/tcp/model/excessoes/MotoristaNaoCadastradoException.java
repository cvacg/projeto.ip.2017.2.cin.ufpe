package tcp.model.excessoes;

public class MotoristaNaoCadastradoException extends Exception {
	
	public MotoristaNaoCadastradoException() {
		super ("MOTORISTA NÃO CADASTRADO");
	}
}