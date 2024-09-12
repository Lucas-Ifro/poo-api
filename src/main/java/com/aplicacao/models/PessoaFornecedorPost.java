package org.aplicacao.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PessoaFornecedorPost {

    private String cnpj;
    private String responsavel;
    private String contato;
    private String telefones;
    private String fantasia;
    private String razaoSocial;
    private String active;
    private LocalDateTime dataLancamento;

    // Construtor
    public PessoaFornecedorPost(String cnpj, String responsavel, String contato, String telefones,
                                String fantasia, String razaoSocial, String active, LocalDateTime dataLancamento) {
        this.cnpj = cnpj;
        this.responsavel = responsavel;
        this.contato = contato;
        this.telefones = telefones;
        this.fantasia = fantasia;
        this.razaoSocial = razaoSocial;
        this.active = active;
        this.dataLancamento = dataLancamento;
    }

    // Getters e Setters
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

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public LocalDateTime getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDateTime dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return "PessoaFornecedorPost{" +
                "cnpj='" + cnpj + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", contato='" + contato + '\'' +
                ", telefones='" + telefones + '\'' +
                ", fantasia='" + fantasia + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", active='" + active + '\'' +
                ", dataLancamento=" + dataLancamento +
                '}';
    }
}
