package tcp.model.entidades;

import tcp.model.repositorios.RepositorioRota;

public class Motorista extends Funcionario {
		
		private String CNH;
		private String categoriaHabilitacao;
		private RepositorioRota rotas;
		
	Motorista (String CNH, String categoriaHabilitacao, RepositorioRota rotas) {	
		
		this.CNH = CNH;
		this.categoriaHabilitacao = categoriaHabilitacao;
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


	public String getCNH() {
		return CNH;
	}

	public void setCNH(String CNH) {
		CNH = CNH;
	}




}