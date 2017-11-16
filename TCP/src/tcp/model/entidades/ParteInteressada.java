/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp.model.entidades;

import tcp.model.repositorios.RepositorioEndereco;
import tcp.model.repositorios.RepositorioContato;

/**
 *
 * @author alm4
 */
public abstract class ParteInteressada {

    private Pessoa pessoa;
    private RepositorioContato contatos;
    private RepositorioEndereco enderecos;
    private String codigo;
    private String dataInicioRelacao;
    private String dataFimRelacao;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public RepositorioContato getContatos() {
        return contatos;
    }

    public void setContatos(RepositorioContato contatos) {
        this.contatos = contatos;
    }

    public RepositorioEndereco getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(RepositorioEndereco enderecos) {
        this.enderecos = enderecos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDataInicioRelacao() {
        return dataInicioRelacao;
    }

    public void setDataInicioRelacao(String dataInicioRelacao) {
        this.dataInicioRelacao = dataInicioRelacao;
    }

    public String getDataFimRelacao() {
        return dataFimRelacao;
    }

    public void setDataFimRelacao(String dataFimRelacao) {
        this.dataFimRelacao = dataFimRelacao;
    }

    public abstract String gerarCodigo(ParteInteressada parteInteressada);

    public abstract String gerarDataInicioRelacao(ParteInteressada parteInteressada);

    public abstract String gerarDataFimRelacao(ParteInteressada parteInteressada);

}
