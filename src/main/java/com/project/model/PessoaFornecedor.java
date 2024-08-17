package com.project.model;

import java.time.LocalDate;

public class PessoaFornecedor {
    int id;
    String cnpj;
    String responsavel;
    String contato;
    String telefones;
    String fantasia;
    String razaoSocial;
    char active;
    LocalDate dataLancamento;

    // Construtor
    public PessoaFornecedor(int id, String cnpj, String responsavel, String contato,
                            String telefones, String fantasia, String razaoSocial,
                            char active, LocalDate dataLancamento) {
        this.id = id;
        this.cnpj = cnpj;
        this.responsavel = responsavel;
        this.contato = contato;
        this.telefones = telefones;
        this.fantasia = fantasia;
        this.razaoSocial = razaoSocial;
        this.active = active;
        this.dataLancamento = dataLancamento;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public char getActive() {
        return active;
    }

    public void setActive(char active) {
        this.active = active;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
