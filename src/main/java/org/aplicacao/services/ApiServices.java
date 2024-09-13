package org.aplicacao.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aplicacao.models.PessoaFornecedor;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.List;

import org.aplicacao.models.PessoaFornecedorPost;
import org.aplicacao.models.ResponseObject;
import org.aplicacao.models.ResponseList;

public class ApiServices {


    @lombok.SneakyThrows
    private  HttpResponse<String> httpGet(String endereco) throws IOException, InterruptedException {
        HttpResponse<String> response = null;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .GET()
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;

    }
    @lombok.SneakyThrows
    private  HttpResponse<String> httpPost(String endereco, String body) throws IOException, InterruptedException {
        HttpResponse<String> response = null;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header("Content-Type", "application/json")
                .uri(URI.create(endereco))
                .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;

    }

    @lombok.SneakyThrows
    private  HttpResponse<String> httpDelete(String endereco) throws IOException, InterruptedException {
        HttpResponse<String> response = null;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create(endereco))
                .header("Content-Type", "application/json")
                .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());


        return response;

    }

    @lombok.SneakyThrows
    private  HttpResponse<String> httpPut(String endereco,String body)  throws IOException, InterruptedException {
        HttpResponse<String> response = null;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(endereco))
                .header("Content-Type", "application/json")
                .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;

    }

    public List<PessoaFornecedor> getPessoaFornecedor(String endereco) {
        List<PessoaFornecedor> pessoaFornecedorList = null;
        try {
            HttpResponse<String> response = httpGet(endereco);
            ObjectMapper mapper = new ObjectMapper();
            ResponseList responseList = mapper.readValue(response.body(), ResponseList.class);
            pessoaFornecedorList = responseList.getData();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao deserializar os elementos: " + e.getMessage());
        }
        return pessoaFornecedorList;
    }


    public PessoaFornecedor getIdPessoaFornecedor(String  endereco, int id) {
        PessoaFornecedor pessoaFornecedor = null;
        String enderecoConcatenado = String.format("%s/%d", endereco ,id);
        try {

            HttpResponse<String> response = httpGet(enderecoConcatenado);
            ObjectMapper mapper = new ObjectMapper();

            ResponseObject responseObject = mapper.readValue(response.body(), ResponseObject.class);
            pessoaFornecedor = responseObject.getData();

        } catch (Exception e){
            System.out.println("Ocorreu um erro ao deserializar os elementos");
        }
        return pessoaFornecedor;
    }

    public PessoaFornecedor postPessoaFornecedor(String  endereco, PessoaFornecedorPost pessoa)  {
        PessoaFornecedor pessoaFornecedor = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonData = mapper.writeValueAsString(pessoa);

            HttpResponse<String> response = httpPost(endereco,jsonData);
            System.out.println("Resposta da API: " + response.body());
            ResponseObject responseObject = mapper.readValue(response.body(), ResponseObject.class);
            pessoaFornecedor = responseObject.getData();

        } catch (Exception e){
            System.out.println("Ocorreu um erro ao deserializar os elementos");
        }
        return pessoaFornecedor;
    }

    public PessoaFornecedor putPessoaFornecedor(String  endereco, PessoaFornecedor pessoa, int id)  {
        PessoaFornecedor pessoaFornecedor = null;
        String enderecoConcatenado = String.format("%s/%d", endereco ,id);
        try {

            ObjectMapper mapper = new ObjectMapper();
            String jsonData = mapper.writeValueAsString(pessoa);

            HttpResponse<String> response = httpPut(enderecoConcatenado,jsonData);
            ResponseObject responseObject = mapper.readValue(response.body(), ResponseObject.class);
            pessoaFornecedor = responseObject.getData();

        } catch (Exception e){
            System.out.println("Ocorreu um erro ao deserializar os elementos no put erro: "+ e.getMessage());
        }
        return pessoaFornecedor;
    }
    public PessoaFornecedor deletePessoaFornecedor(String  endereco, int id)  {
        PessoaFornecedor PessoaFornecedor = null;
        String enderecoConcatenado = String.format("%s/%d", endereco ,id);
        try {

            HttpResponse<String> response = httpDelete(enderecoConcatenado);

            ObjectMapper mapper = new ObjectMapper();
            ResponseObject responseObject = mapper.readValue(response.body(), ResponseObject.class);
            PessoaFornecedor = responseObject.getData();

        } catch (Exception e){
            System.out.println("Ocorreu um erro ao deserializar os elementos");
        }
        return PessoaFornecedor;
    }
}
