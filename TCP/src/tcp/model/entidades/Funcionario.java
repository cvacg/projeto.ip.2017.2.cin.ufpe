package tcp.model.entidades;

public class Funcionario extends ParteInteressada{

	
	 Funcionario (String codigo, String dataInicioRelacao, String dataFimRelacao) {
		this.setCodigo(codigo);
		this.setDataInicioRelacao(dataInicioRelacao);
		this.setDataFimRelacao(dataFimRelacao);
	
	}
	
	public String gerarCodigo(ParteInteressada parteInteressada) {
		return "";
	}
	
	public String gerarDataInicioRelacao(ParteInteressada parteInteressada) {
		return "";
	}
	
	public String gerarDataFimRelacao(ParteInteressada parteInteressada) {
		return "";
	}
	
	
	
	
	
	
	
	
	
	

}
