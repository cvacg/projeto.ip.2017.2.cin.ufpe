package tcp.model.entidades;


public class Motorista {
		private String nome;
		private String CPF;
		private int idade;
		private String CNH;
		private String categoriaHabilitacao;
		private RepositorioRota rotas;
		
	public Motorista (String nome, String CPF, int idade, String CNH, String categoriaHabilitacao, RepositorioRota rotas) {	
		this.nome = nome;
		this.CPF = CPF;
		this.idade = idade;
		this.CNH = CNH;
		this.categoriaHabilitacao = categoriaHabilitacao;]
		this.rotas = rotas;
	}

	public String getCategoriaHabilitacao() {
		return categoriaHabilitacao;
	}

	public void setCategoriaHabilitacao(String categoriaHabilitacao) {
		this.categoriaHabilitacao = categoriaHabilitacao;
	}

	public RepositorioRota getRotas() {
		return rotas;
	}

	public void setRotas(RepositorioRota rotas) {
		this.rotas = rotas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCNH() {
		return CNH;
	}

	public void setCNH(String CNH) {
		CNH = CNH;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}


}