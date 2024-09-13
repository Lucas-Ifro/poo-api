package org.aplicacao;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.aplicacao.models.PessoaFornecedor;
import org.aplicacao.models.PessoaFornecedorPost;
import org.aplicacao.services.ApiServices;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^(C|E|A|L|LI|S)$";

        // Criando o pattern e matcher
        Pattern pattern = Pattern.compile(regex);

        String opiton;
        boolean controle = true;
        while (controle) {
            System.out.println("Sistema de Fornecedores - O que deseja fazer?");
            System.out.println("C - Criar");
            System.out.println("E - Excluir");
            System.out.println("A - Atualizar");
            System.out.println("L - Listar");
            System.out.println("LI - Listar por ID");
            System.out.println("S - Sair do Sistema");

            System.out.println("Escolha uma opção entre as acima:");
            opiton = scanner.next();

            ApiServices servicoApi = new ApiServices();
            switch (opiton) {
                case "C":
                    System.out.println("Informe o CNPJ: ");
                    String cnpj = scanner.next();
                    System.out.println("Informe o nome do fornecedor: ");
                    String nome = scanner.next();
                    System.out.println("Informe o e-mail: ");
                    String email = scanner.next();
                    System.out.println("Informe o telefone: ");
                    String telefone = scanner.next();
                    System.out.println("Informe a empresa: ");
                    String empresa = scanner.next();
                    System.out.println("Informe o nome da empresa: ");
                    String nomeEmpresa = scanner.next();
                    System.out.println("Informe o status (Y/N): ");
                    String status = scanner.next();

                    PessoaFornecedorPost novoFornecedor = new PessoaFornecedorPost(
                            cnpj,
                            nome,
                            email,
                            telefone,
                            empresa,
                            nomeEmpresa,
                            status
                    );

                    PessoaFornecedor criado = servicoApi.postPessoaFornecedor("http://localhost:3060/PessoaFornecedor", novoFornecedor);
                    System.out.println("Novo fornecedor criado!");
                    System.out.println(criado);
                    System.out.println("  ");
                    break;

                case "E":
                    System.out.println("Informe o ID do fornecedor a ser excluído: ");
                    int idExcluir = scanner.nextInt();
                    PessoaFornecedor excluido = servicoApi.deletePessoaFornecedor("http://localhost:3060/PessoaFornecedor", idExcluir);
                    System.out.println("Fornecedor excluído:");
                    System.out.println(excluido);
                    System.out.println("  ");
                    break;

                case "S":
                    controle = false;
                    System.out.println("Você saiu do sistema.");
                    break;

                case "A":
                    System.out.println("Informe o ID do fornecedor a ser atualizado: ");
                    int idAtualizado = scanner.nextInt();
                    System.out.println("Informe o CNPJ: ");
                    String cnpjAtualizado = scanner.next();
                    System.out.println("Informe o nome do fornecedor: ");
                    String nomeAtualizado = scanner.next();
                    System.out.println("Informe o e-mail: ");
                    String emailAtualizado = scanner.next();
                    System.out.println("Informe o telefone: ");
                    String telefoneAtualizado = scanner.next();
                    System.out.println("Informe a empresa: ");
                    String empresaAtualizada = scanner.next();
                    System.out.println("Informe o nome da empresa: ");
                    String nomeEmpresaAtualizado = scanner.next();
                    System.out.println("Informe o status (Y/N): ");
                    String statusAtualizado = scanner.next();
                    String dataLancamentoAtualizado = null;

                    PessoaFornecedor fornecedorAtualizado = new PessoaFornecedor(
                            idAtualizado,
                            dataLancamentoAtualizado,
                            statusAtualizado,
                            nomeAtualizado,
                            nomeEmpresaAtualizado,
                            telefoneAtualizado,
                            emailAtualizado,
                            empresaAtualizada,
                            cnpjAtualizado);

                    PessoaFornecedor atualizado = servicoApi.putPessoaFornecedor("http://localhost:3060/PessoaFornecedor", fornecedorAtualizado, idAtualizado);
                    System.out.println("Fornecedor atualizado!");
                    System.out.println(atualizado);
                    System.out.println("  ");
                    break;

                case "L":
                    List<PessoaFornecedor> pessoa = servicoApi.getPessoaFornecedor("http://localhost:3060/PessoaFornecedor");
                    if (pessoa == null || pessoa.isEmpty()) {
                        System.out.println("Não foi possível listar os fornecedores. Verifique o limite e a página!");
                    } else {
                        for (PessoaFornecedor fornecedor : pessoa) {
                            System.out.println(fornecedor);
                            System.out.println("  ");
                        }
                    }
                    break;

                case "LI":
                    System.out.println("Informe o ID: ");
                    int id = scanner.nextInt();
                    PessoaFornecedor fornecedor = servicoApi.getIdPessoaFornecedor("http://localhost:3060/PessoaFornecedor", id);
                    if (fornecedor == null) {
                        System.out.println("Desculpe, mas este fornecedor não existe na base de dados!");
                    } else {
                        System.out.println(fornecedor);
                        System.out.println("  ");
                    }
                    break;

                default:
                    System.out.println("  ");
                    System.out.println("Opção inválida. Estas são as opções disponíveis (A, L, LI, E, C, S)");
                    System.out.println("==============================");
                    System.out.println("  ");
                    break;
            }
        }
    }
}
