package org.aplicacao.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PessoaFornecedor {

    private int id;
    private String cnpj;
    private String responsavel;
    private String contato;
    private String telefones;
    private String fantasia;
    private String razao_social;
    private String active;
    private String data_lancamento;

    public PessoaFornecedor(int id, String data_lancamento, String active, String razao_social, String fantasia, String telefones, String contato, String responsavel, String cnpj) {
        this.id = id;
        this.data_lancamento = data_lancamento;
        this.active = active;
        this.razao_social = razao_social;
        this.fantasia = fantasia;
        this.telefones = telefones;
        this.contato = contato;
        this.responsavel = responsavel;
        this.cnpj = cnpj;
    }

    public PessoaFornecedor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getTelefones() {
        return telefones;
    }

    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "PessoaFornecedor{" +
                "id=" + id +
                ", cnpj='" + cnpj + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", contato='" + contato + '\'' +
                ", telefones='" + telefones + '\'' +
                ", fantasia='" + fantasia + '\'' +
                ", razao_social='" + razao_social + '\'' +
                ", active='" + active + '\'' +
                ", data_lancamento=" + data_lancamento +
                '}';
    }
}
