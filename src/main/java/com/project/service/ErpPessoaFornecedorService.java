package com.project.service;

import com.project.repository.ErpPessoaFornecedorRepository;

public class ErpPessoaFornecedorService {

    private final ErpPessoaFornecedorRepository repository = new ErpPessoaFornecedorRepository();

    public String listar(String active, String cnpj, String razaoSocial, String dataLancamento) {
        try {
            return repository.listar(active, cnpj, razaoSocial, dataLancamento);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching data from repository", e);
        }
    }
}