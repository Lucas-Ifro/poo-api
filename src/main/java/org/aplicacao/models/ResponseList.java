package org.aplicacao.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseList {

    private List<PessoaFornecedor> data;
    private int code;
    private boolean error;
    private String message;
    private List<String> errors;

    public List<PessoaFornecedor> getData() {
        return data;
    }

    public void setData(List<PessoaFornecedor> data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResponseList{" +
                "data=" + data +
                ", code=" + code +
                ", error=" + error +
                ", message='" + message + '\'' +
                ", errors=" + errors +
                '}';
    }
}
