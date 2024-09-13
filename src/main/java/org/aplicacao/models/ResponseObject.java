package org.aplicacao.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseObject {
        private PessoaFornecedor data;
        private int code;

        public PessoaFornecedor getData() {
                return data;
        }

        public void setData(PessoaFornecedor data) {
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

        public List<String> getErrors() {
                return errors;
        }

        public void setErrors(List<String> errors) {
                this.errors = errors;
        }

        private boolean error;
        private String message;
        private List<String> errors;

        @Override
        public String toString() {
                return "ResponseObject{" +
                        "data=" + data +
                        ", code=" + code +
                        ", error=" + error +
                        ", message='" + message + '\'' +
                        ", errors=" + errors +
                        '}';
        }
}
