package org.aplicacao.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseObject {
        private PessoaFornecedor data;
        private  int code;
        private boolean error;
        private String message;
        private List<String> errors;
        private int total;
        private int limite;
        private int total_paginas;

}
