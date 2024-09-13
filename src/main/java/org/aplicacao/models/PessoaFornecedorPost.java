package org.aplicacao.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PessoaFornecedorPost {

    private String cnpj;
    private String responsavel;
    private String contato;
    private String telefones;
    private String fantasia;
    private String razao_social;
    private String active;



    public PessoaFornecedorPost() {
    }

    public PessoaFornecedorPost(String cnpj, String responsavel, String contato, String telefones, String fantasia, String razao_social, String active) {
        this.cnpj = cnpj;
        this.responsavel = responsavel;
        this.contato = contato;
        this.telefones = telefones;
        this.fantasia = fantasia;
        this.razao_social = razao_social;
        this.active = active;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTelefones() {
        return telefones;
    }

    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "PessoaFornecedorPost{" +
                "cnpj='" + cnpj + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", contato='" + contato + '\'' +
                ", telefones='" + telefones + '\'' +
                ", fantasia='" + fantasia + '\'' +
                ", razao_social='" + razao_social + '\'' +
                ", active='" + active + '\'' +
                '}';
    }
}
