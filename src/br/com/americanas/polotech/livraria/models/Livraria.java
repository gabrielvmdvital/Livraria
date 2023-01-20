package br.com.americanas.polotech.livraria.models;

import br.com.americanas.polotech.livraria.enums.ProdutoEnum;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.util.*;

public class Livraria {

    private  BigDecimal saldoCaixa;

    public static List<Album> albunsList = new ArrayList<>();
    public static List<Brinquedo> brinquedosList = new ArrayList<>();
    public static List<Jogo> jogosList = new ArrayList<>();
    public static List<Filme> filmesList = new ArrayList<>();
    public static List<Livro> livrosList = new ArrayList<>();



    public static void menu(Scanner sc, Produto produto){


        loopMenuPrincipal:
        while(true){
            System.out.println("*----------------------------------------------*");
            System.out.print("|               Livaria - Menu de opções       |\n");
            System.out.print("|----------------------------------------------|\n");
            System.out.print("| 0 - Sair:                                    |\n");
            System.out.print("| 1 - Cadastrar na loja:                       | \n");
            System.out.print("| 2 - Entrar no sistema:                       | \n");
            System.out.print("| 3 - Registrar Caixa em R$:                   | \n");
            System.out.println("*---------------------------------------------*");

            switch (Integer.parseInt(sc.nextLine())){
                case 0 -> {
                    break loopMenuPrincipal;
                }
                case 1-> {
                    System.out.println("Informe o nome de usuario: ");
                    String nome = sc.nextLine();
                    System.out.println("Informe a senha: ");
                    String senha = sc.nextLine();
                    User u = new User(nome, senha);
                    System.out.println("Cadastro realizado com sucesso!");
                    break;
                }

                case 2-> {
                    System.out.println("Informe seu login: ");
                    String userName = sc.nextLine();
                    System.out.println("Informe sua senha: ");
                    String senha = sc.nextLine();

                    User user = User.loginSystem(userName, senha);
                    loopUserLogged:
                    while (user.isUserLogged()) {
                            menunUserLogged(user);
                            if (user.getTypeUser().equals("ADM")) {
                                switch (Integer.parseInt(sc.nextLine())) {
                                    case 1 -> {
                                        loopAddProduto:
                                        do {
                                            System.out.println("Deseja sair do menur de adição de produtos?: (S ou N)");
                                            if (sc.nextLine().equals("S".toLowerCase())) {
                                                break loopAddProduto;
                                            }
                                            System.out.println("Informe o tipo do produto: ");
                                            switch (ProdutoEnum.valueOf(sc.nextLine().toUpperCase())) {
                                                case ALBUNS_DE_MUSICA -> {
                                                    Album.addProduto(albunsList, sc);
                                                    System.out.println("Produto adicionado com sucesso!");
                                                    break;
                                                }

                                                case BRINQUEDO -> {
                                                    Brinquedo.addProduto(brinquedosList, sc);
                                                    System.out.println("Produto adicionado com sucesso!");
                                                    break;

                                                }

                                                case FILME -> {
                                                    Filme.addProduto(filmesList, sc);
                                                    System.out.println("Produto adicionado com sucesso!");
                                                    break;
                                                }

                                                case JOGO -> {
                                                    Jogo.addProduto(jogosList, sc);
                                                    System.out.println("Produto adicionado com sucesso!");
                                                    break;
                                                }

                                                case LIVRO -> {
                                                    Livro.addProduto(livrosList, sc);
                                                    System.out.println("Produto adicionado com sucesso!");
                                                    break;
                                                }
                                            }

                                        } while (true);
                                    }
                                    case 2 -> {
                                        loopAlteraProduto:
                                        do {
                                            System.out.println("Deseja sair do menur de adição de produtos?: (S ou N)");
                                            if (sc.nextLine().equals("S".toLowerCase())) {
                                                break loopAlteraProduto;
                                            }
                                            System.out.println("Informe o tipo do produto que deseja alterar: ");
                                            switch (ProdutoEnum.valueOf(sc.nextLine().toUpperCase())) {
                                                case ALBUNS_DE_MUSICA -> {
                                                    System.out.println("Informe o id do album que deseja alterar: ");
                                                    int id = Integer.parseInt(sc.nextLine());
                                                    System.out.println("Informe o nomo valor do produto: ");
                                                    double preco = Double.parseDouble(sc.nextLine());
                                                    Optional<Album> newProduto = albunsList.stream().filter((Album album) ->
                                                            album.getId() == id).findFirst();

                                                    if (newProduto.isPresent()) {
                                                        albunsList.remove(newProduto.get().getId());
                                                        newProduto.get().setPreco(preco);
                                                        albunsList.add(newProduto.get());
                                                        System.out.println("Valor do produtor " + newProduto.get().getNome() +
                                                                "atualizado com sucesso!");

                                                    } else {
                                                        System.out.println("Produto não encontrado!");
                                                    }
                                                    break;

                                                }

                                                case BRINQUEDO -> {

                                                    System.out.println("Informe o id do album que deseja alterar: ");
                                                    int id = Integer.parseInt(sc.nextLine());
                                                    System.out.println("Informe o nomo valor do produto: ");
                                                    double preco = Double.parseDouble(sc.nextLine());
                                                    Optional<Brinquedo> newProduto = brinquedosList.stream().filter((Brinquedo toy) ->
                                                            toy.getId() == id).findFirst();

                                                    if (newProduto.isPresent()) {
                                                        brinquedosList.remove(newProduto.get().getId());
                                                        newProduto.get().setPreco(preco);
                                                        brinquedosList.add(newProduto.get());
                                                        System.out.println("Valor do produtor " + newProduto.get().getNome() +
                                                                "atualizado com sucesso!");

                                                    } else {
                                                        System.out.println("Produto não encontrado!");
                                                    }
                                                    break;

                                                }

                                                case FILME -> {
                                                    System.out.println("Informe o id do album que deseja alterar: ");
                                                    int id = Integer.parseInt(sc.nextLine());
                                                    Optional<Filme> newProduto = filmesList.stream().filter((Filme filme) ->
                                                            filme.getId() == id).findFirst();

                                                    System.out.println("Informe o nomo valor do produto: ");
                                                    double preco = Double.parseDouble(sc.nextLine());

                                                    if (newProduto.isPresent()) {
                                                        filmesList.remove(newProduto.get().getId());
                                                        newProduto.get().setPreco(preco);
                                                        filmesList.add(newProduto.get());
                                                        System.out.println("Valor do produtor " + newProduto.get().getNome() +
                                                                "atualizado com sucesso!");
                                                    } else {
                                                        System.out.println("Produto não encontrado!");
                                                    }
                                                    break;

                                                }

                                                case JOGO -> {

                                                    System.out.println("Informe o id do album que deseja alterar: ");
                                                    int id = Integer.parseInt(sc.nextLine());
                                                    System.out.println("Informe o nomo valor do produto: ");
                                                    double preco = Double.parseDouble(sc.nextLine());
                                                    Optional<Jogo> newProduto = jogosList.stream().filter((Jogo jogo) ->
                                                            jogo.getId() == id).findFirst();

                                                    if (newProduto.isPresent()) {
                                                        jogosList.remove(newProduto.get().getId());
                                                        newProduto.get().setPreco(preco);
                                                        jogosList.add(newProduto.get());
                                                        System.out.println("Valor do produtor " + newProduto.get().getNome() +
                                                                "atualizado com sucesso!");

                                                    } else {
                                                        System.out.println("Produto não encontrado!");
                                                    }
                                                    break;

                                                }

                                                case LIVRO -> {

                                                    System.out.println("Informe o id do album que deseja alterar: ");
                                                    int id = Integer.parseInt(sc.nextLine());
                                                    System.out.println("Informe o nomo valor do produto: ");
                                                    double preco = Double.parseDouble(sc.nextLine());
                                                    Optional<Livro> newProduto = livrosList.stream().filter((Livro livro) ->
                                                            livro.getId() == id).findFirst();

                                                    if (newProduto.isPresent()) {
                                                        livrosList.remove(newProduto.get().getId());
                                                        newProduto.get().setPreco(preco);
                                                        livrosList.add(newProduto.get());
                                                        System.out.println("Valor do produtor " + newProduto.get().getNome() +
                                                                "atualizado com sucesso!");

                                                    } else {
                                                        System.out.println("Produto não encontrado!");
                                                    }

                                                    break;

                                                }
                                            }

                                        } while (true);
                                    }
                                    case 3 -> {

                                        System.out.println("*----------------------------------------------*");
                                        System.out.print("|              Menu de remoção                 |\n");
                                        System.out.print("|----------------------------------------------|\n");
                                        System.out.print("| 1 - Albuns de músicas:                       |\n");
                                        System.out.print("| 2 - Brinquedos:                              |\n");
                                        System.out.print("| 3 - Filmes:                                  |\n");
                                        System.out.print("| 4 - Jogos:                                   |\n");
                                        System.out.print("| 5 - Livros:                                  |\n");
                                        System.out.println("*---------------------------------------------*");
                                        int opcao = Integer.parseInt(sc.nextLine());
                                        switch (opcao) {
                                            case 1 -> {
                                                System.out.println("Informe o id do produto: ");
                                                int id = Integer.parseInt(sc.nextLine());
                                                Album.removeProdutos(albunsList, id);

                                            }
                                            case 2 -> {
                                                System.out.println("Informe o id do produto: ");
                                                int id = Integer.parseInt(sc.nextLine());
                                                Brinquedo.removeProdutos(brinquedosList, id);

                                            }
                                            case 3 -> {
                                                System.out.println("Informe o id do produto: ");
                                                int id = Integer.parseInt(sc.nextLine());
                                                Filme.removeProdutos(filmesList, id);

                                            }
                                            case 4 -> {
                                                System.out.println("Informe o id do produto: ");
                                                int id = Integer.parseInt(sc.nextLine());
                                                Jogo.removeProdutos(jogosList, id);

                                            }
                                            case 5 -> {
                                                System.out.println("Informe o id do produto: ");
                                                int id = Integer.parseInt(sc.nextLine());
                                                Livro.removeProdutos(livrosList, id);

                                            }
                                        }
                                    }
                                    case 4 -> {
                                        System.out.println("Itens em Estoque: ");
                                        System.out.println();

                                        System.out.println("Lista de Albumns");
                                        for (Album album : albunsList) {
                                            album.showProtoInfo();
                                            System.out.println();
                                        }

                                        System.out.println("Lista de Briquedos");
                                        for (Brinquedo toy : brinquedosList) {
                                            toy.showProtoInfo();
                                            System.out.println();
                                        }

                                        System.out.println("Lista de Fimles");
                                        for (Filme filme : filmesList) {
                                            filme.showProtoInfo();
                                            System.out.println();
                                        }

                                        System.out.println("Lista de Jogos");
                                        for (Jogo jogo : jogosList) {
                                            jogo.showProtoInfo();
                                            System.out.println();
                                        }

                                        System.out.println("Lista de Livros");
                                        for (Livro livro : livrosList) {
                                            livro.showProtoInfo();
                                            System.out.println();
                                        }
                                    }
                                }
                            }


                    }
                }

            }
        }


    }










    public static void menunUserLogged(User user) {

        if(user.getTypeUser().equals("ADM")){
            System.out.println("*----------------------------------------------*");
            System.out.print("|               Opções de Administrador        |\n");
            System.out.print("|----------------------------------------------|\n");
            System.out.print("|     Registro de caixa: R$                ----|\n");
            System.out.print("|----------------------------------------------|\n");
            System.out.print("| 0 - Sair:                                    |\n");
            System.out.print("| 1 - Adicionar produto ao estoque:            |\n");
            System.out.print("| 2 - Alterar produto no estoque:              |\n");
            System.out.print("| 3 - Remover produto do estoque:              |\n");
            System.out.print("| 4 - Listar todos os itens do estoque:        |\n");
            System.out.print("| 5 - Listar por categoria:                    |\n");
            System.out.print("| 6 - Adicionar produto ao carrinho:           |\n");
            System.out.print("| 7 - Adicionar produto ao carrinho:           |\n");
            System.out.print("| 8 - Ver carrinho de compras:                 |\n");
            System.out.print("| 9 - Finalizar compras:                       |\n");
            System.out.println("*---------------------------------------------*");


        }

        else{
            System.out.println("*----------------------------------------------*");
            System.out.print("|               Opções de usuario              |\n");
            System.out.print("|----------------------------------------------|\n");
            System.out.print("| 0 - Sair:                                    |\n");
            System.out.print("| 1 - Listar todos os itens do estoque:        |\n");
            System.out.print("| 2 - Listar por categoria:                    |\n");
            System.out.print("| 3 - Listar por categoria:                    |\n");
            System.out.print("| 4 - Adicionar produto ao carrinho:           |\n");
            System.out.print("| 5 - Ver carrinho de compras:                 |\n");
            System.out.print("| 5 - Finalizar compras:                       |\n");
            System.out.println("*---------------------------------------------*");
        }
    }

    public static void listarProdutosPerCategory(){
        System.out.println("*----------------------------------------------*");
        System.out.print("|        Escolha uma categoria de produto      |\n");
        System.out.print("|----------------------------------------------|\n");
        System.out.print("| 1 - Albuns de músicas:                       |\n");
        System.out.print("| 2 - Brinquedos:                              |\n");
        System.out.print("| 3 - Filmes:                                  |\n");
        System.out.print("| 4 - Jogos:                                   |\n");
        System.out.print("| 5 - Livros:                                  |\n");
        System.out.println("*---------------------------------------------*");

    }



}
