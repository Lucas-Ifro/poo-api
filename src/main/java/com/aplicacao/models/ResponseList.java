package org.aplicacao.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseList {

    private List<PessoaFornecedor> data;
    private int code;
    private boolean error;
    private String message;
    private int total;
    private int limite;

    // Getters e Setters
    public List<PessoaFornecedor> getData() {
        return data;
    }

    public void setData(List<PessoaFornecedor> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "ResponseList{" +
                "data=" + data +
                ", code=" + code +
                ", error=" + error +
                ", message='" + message + '\'' +
                ", total=" + total +
                ", limite=" + limite +
                '}';
    }
}
