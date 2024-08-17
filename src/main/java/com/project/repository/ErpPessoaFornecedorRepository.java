package com.project.repository;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.stream.Collectors;

public class ErpPessoaFornecedorRepository {

    private final HttpClient client = HttpClient.newHttpClient();
    private final String apiUrl = "http://localhost:3000/api/pessoafornecedor"; // URL base da sua API Node.js

    public String listar(String active, String cnpj, String razaoSocial, String dataLancamento) throws Exception {
        // Montar os parâmetros da consulta
        Map<String, String> params = Map.of(
                "active", active,
                "cnpj", cnpj,
                "razao_social", razaoSocial,
                "data_lancamento", dataLancamento
        );

        String queryString = params.entrySet().stream()
                .filter(e -> e.getValue() != null && !e.getValue().isEmpty())
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));

        // Construir a URL completa com parâmetros
        String url = apiUrl + "?" + queryString;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("Failed: HTTP error code : " + response.statusCode());
        }
    }
}

