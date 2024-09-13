package org.aplicacao;

import java.util.List;
import org.aplicacao.models.PessoaFornecedorPost;

import org.aplicacao.services.ApiServices;
import org.aplicacao.models.PessoaFornecedor;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ApiServices servicoApi = new ApiServices();

        // Remover paginação e obter a lista completa de fornecedores
        PessoaFornecedor listaFornecedor = servicoApi.getPessoaFornecedor("http://localhost:3060/PessoaFornecedor");

        // Obter um fornecedor por ID
        int id = 300;
        PessoaFornecedor listadaPorId = servicoApi.getIdPessoaFornecedor("http://localhost:3060/PessoaFornecedor", id);

        // Atualizar um fornecedor
        listadaPorId.setCnpj("12.345.678/0001-95"); // Atualize o CNPJ como exemplo
        PessoaFornecedor atualizada = servicoApi.putPessoaFornecedor("http://localhost:3060/PessoaFornecedor", listadaPorId, id);

        // Criar um novo elemento
        //int comprasId = listaFornecedor.get(3).getErp_compras_id();
        //int produtosId = listaFornecedor.get(5).getErp_produtos_id();

        // Criar a data no padrão ISO
        LocalDateTime now = LocalDateTime.now();
        String iso8601Date = now.format(DateTimeFormatter.ISO_DATE_TIME);

        // Criar o objeto PessoaFornecedorPost
        PessoaFornecedorPost novoElemento = new PessoaFornecedorPost(
                "12.345.678/0001-95", // Exemplo de CNPJ
                "Maria Oliveira",     // Exemplo de Responsável
                "maria.oliveira@exemplo.com", // Exemplo de Contato
                "(11) 98765-4321",   // Exemplo de Telefones
                "Loja Nova",         // Exemplo de Fantasia
                "Loja Nova Ltda",    // Exemplo de Razão Social
                "Y",                 // Status ativo
                LocalDateTime.now()  // Data de Lançamento
        );

        PessoaFornecedor apiCriado = servicoApi.postPessoaFornecedor("http://localhost:3060/PessoaFornecedor", novoElemento);

        // Excluir um elemento
        PessoaFornecedor elementoExcluido = servicoApi.deletePessoaFornecedor("http://localhost:3060/PessoaFornecedor", apiCriado.getId());

        // Exibir os resultados
        System.out.println("Fornecedor paginado:");
        System.out.println(listaFornecedor.toString());
        System.out.println("Fornecedor por ID:");
        System.out.println(listadaPorId.toString());
        System.out.println("Fornecedor atualizado:");
        System.out.println(atualizada.toString());
        System.out.println("Fornecedor criado:");
        System.out.println(apiCriado.toString());
        System.out.println("Fornecedor excluído:");
        System.out.println(elementoExcluido.toString());
    }
}
