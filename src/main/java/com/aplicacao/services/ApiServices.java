package org.aplicacao.services;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aplicacao.models.PessoaFornecedor;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;

import org.aplicacao.models.PessoaFornecedorPost;
import org.aplicacao.models.ResponseList;
import org.aplicacao.models.ResponseObject;

public class ApiServices {


    @lombok.SneakyThrows
    private  HttpResponse<String> httpGet(String endereco) {
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
    private  HttpResponse<String> httpPost(String endereco, String body) {
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
    private  HttpResponse<String> httpDelete(String endereco) {
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
    private  HttpResponse<String> httpPut(String endereco,String body) {
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

    public PessoaFornecedor getIdPessoaFornecedor(String  endereco, int id)  {
        PessoaFornecedor PessoaFornecedor = null;
        String enderecoConcatenado = String.format("%s/%d", endereco ,id);
        try {

            HttpResponse<String> response = httpGet(enderecoConcatenado);

            ObjectMapper mapper = new ObjectMapper();
            ResponseObject responseList = mapper.readValue(response.body(), ResponseObject.class);
            PessoaFornecedor = responseList.getData();

        } catch (Exception e){
            System.out.println("Ocorreu um erro ao deserializar os elementos");
        }
        return PessoaFornecedor;
    }

    public PessoaFornecedor postPessoaFornecedor(String  endereco, PessoaFornecedorPost compra)  {
        PessoaFornecedor PessoaFornecedor = null;
        try {
            //Serializando o objeto para enviar ao http
            ObjectMapper mapper = new ObjectMapper();
            String jsonData = mapper.writeValueAsString(compra);

            //Fazendo a requisicao
            HttpResponse<String> response = httpPost(endereco,jsonData);
            //Lendo a resposta
            ResponseObject responseList = mapper.readValue(response.body(), ResponseObject.class);
            PessoaFornecedor = responseList.getData();

        } catch (Exception e){
            System.out.println("Ocorreu um erro ao deserializar os elementos");
        }
        return PessoaFornecedor;
    }

    public PessoaFornecedor putPessoaFornecedor(String  endereco, PessoaFornecedor compra, int id)  {
        PessoaFornecedor PessoaFornecedor = null;
        String enderecoConcatenado = String.format("%s/%d", endereco ,id);
        try {
            //Construindo o json convertendo de objeto para string
            ObjectMapper mapper = new ObjectMapper();
            String jsonData = mapper.writeValueAsString(compra);

            //Chamando o metodo http para enviar o objeto
            HttpResponse<String> response = httpPut(enderecoConcatenado,jsonData);
            //Lendo a resposta
            ResponseObject responseList = mapper.readValue(response.body(), ResponseObject.class);

            //Atribuido o objeto
            PessoaFornecedor = responseList.getData();

        } catch (Exception e){
            System.out.println("Ocorreu um erro ao deserializar os elementos no put erro: "+ e.getMessage());
        }
        return PessoaFornecedor;
    }
    public PessoaFornecedor deletePessoaFornecedor(String  endereco, int id)  {
        PessoaFornecedor PessoaFornecedor = null;
        String enderecoConcatenado = String.format("%s/%d", endereco ,id);
        try {

            HttpResponse<String> response = httpDelete(enderecoConcatenado);

            ObjectMapper mapper = new ObjectMapper();
            ResponseObject responseList = mapper.readValue(response.body(), ResponseObject.class);
            PessoaFornecedor = responseList.getData();

        } catch (Exception e){
            System.out.println("Ocorreu um erro ao deserializar os elementos");
        }
        return PessoaFornecedor;
    }
}
