package br.com.americanas.polotech.livraria.models;

import br.com.americanas.polotech.livraria.enums.ProdutoEnum;
import br.com.americanas.polotech.livraria.models.*;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.util.*;

public class Livraria {


    private static double saldoCaixa;

    public static double getSaldoCaixa() {
        return saldoCaixa;
    }

    public static String msgNaoExiste = "Produto não existe no estoque";
    public static String msgProtudoEmFalta = "Produto em falta!";
    public static String msgSucess = "Produto removido do carrinho com sucesso!";
    public static String msgNaoHaProdutosCadastrados = "Não há produtos cadastrados deste tipo!";
    public static boolean flagSemProdutosNoEstoque = false;

    public static void setSaldoCaixa(double valor) {
        saldoCaixa = valor;
    }

    public static List<Album> albunsList = new ArrayList<>();
    public static List<Brinquedo> brinquedosList = new ArrayList<>();
    public static List<Jogo> jogosList = new ArrayList<>();
    public static List<Filme> filmesList = new ArrayList<>();
    public static List<Livro> livrosList = new ArrayList<>();



    public void menu(Scanner sc, List<User> users){


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

            switch (Integer.parseInt(sc.nextLine())) {
                case 0 -> {
                    break loopMenuPrincipal;
                }
                case 1 -> {
                    System.out.println("Informe o nome de usuario: ");
                    String nome = sc.nextLine();
                    System.out.println("Informe a senha: ");
                    String senha = sc.nextLine();
                    User.addUser(users, new User(nome, senha));
                    if(!users.isEmpty()){
                        System.out.println("Cadastro realizado com sucesso!");
                    }
                    break;
                }

                case 2 -> {
                    System.out.println("Informe seu login: ");
                    String userName = sc.nextLine();
                    System.out.println("Informe sua senha: ");
                    String senha = sc.nextLine();
                    if (users.size() > 0) {
                        User user = User.loginSystem(userName, senha, users);
                        if (user != null) {
                            loopUserLogged:
                            while (user.isUserLogged()) {
                                menunUserLogged(user);
                                if (user.getTypeUser().equals("ADM")) {
                                    switch (Integer.parseInt(sc.nextLine())) {
                                        case 1 -> {

                                            while (true) {

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
                                                System.out.println("Digite  0 para sair!");
                                                if (Integer.parseInt(sc.nextLine()) == 0) {
                                                    break;
                                                }

                                            }
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
                                                        Album newProduto = albunsList.stream().filter((Album album) ->
                                                                album.getId() == id).toList().get(0);

                                                        if (!newProduto.equals(null)) {
                                                            albunsList.remove(newProduto.getId());
                                                            newProduto.setPreco(preco);
                                                            albunsList.add(newProduto);
                                                            System.out.println("Valor do produtor " + newProduto.getNome() +
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
                                                        Brinquedo newProduto = brinquedosList.stream().filter((Brinquedo toy) ->
                                                                toy.getId() == id).toList().get(0);

                                                        if (!newProduto.equals(null)) {
                                                            brinquedosList.remove(newProduto.getId());
                                                            newProduto.setPreco(preco);
                                                            brinquedosList.add(newProduto);
                                                            System.out.println("Valor do produtor " + newProduto.getNome() +
                                                                    "atualizado com sucesso!");

                                                        } else {
                                                            System.out.println("Produto não encontrado!");
                                                        }
                                                        break;

                                                    }

                                                    case FILME -> {
                                                        System.out.println("Informe o id do album que deseja alterar: ");
                                                        int id = Integer.parseInt(sc.nextLine());
                                                        Filme newProduto = filmesList.stream().filter((Filme filme) ->
                                                                filme.getId() == id).toList().get(0);

                                                        System.out.println("Informe o nomo valor do produto: ");
                                                        double preco = Double.parseDouble(sc.nextLine());

                                                        if (!newProduto.equals(null)) {
                                                            filmesList.remove(newProduto.getId());
                                                            newProduto.setPreco(preco);
                                                            filmesList.add(newProduto);
                                                            System.out.println("Valor do produtor " + newProduto.getNome() +
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
                                                        Jogo newProduto = jogosList.stream().filter((Jogo jogo) ->
                                                                jogo.getId() == id).toList().get(0);

                                                        if (!newProduto.equals(null)) {
                                                            jogosList.remove(newProduto.getId());
                                                            newProduto.setPreco(preco);
                                                            jogosList.add(newProduto);
                                                            System.out.println("Valor do produtor " + newProduto.getNome() +
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
                                                        Livro newProduto = livrosList.stream().filter((Livro livro) ->
                                                                livro.getId() == id).toList().get(0);

                                                        if (!newProduto.equals(null)) {
                                                            livrosList.remove(newProduto.getId());
                                                            newProduto.setPreco(preco);
                                                            livrosList.add(newProduto);
                                                            System.out.println("Valor do produtor " + newProduto.getNome() +
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
                                            listarProdutosPerCategory();
//                                    System.out.println("*----------------------------------------------*");
//                                    System.out.print("|              Menu de remoção                 |\n");
//                                    System.out.print("|----------------------------------------------|\n");
//                                    System.out.print("| 1 - Albuns de músicas:                       |\n");
//                                    System.out.print("| 2 - Brinquedos:                              |\n");
//                                    System.out.print("| 3 - Filmes:                                  |\n");
//                                    System.out.print("| 4 - Jogos:                                   |\n");
//                                    System.out.print("| 5 - Livros:                                  |\n");
//                                    System.out.println("*---------------------------------------------*");
                                            int opcao = Integer.parseInt(sc.nextLine());
                                            switch (opcao) {
                                                case 1 -> {
                                                    System.out.println("Informe o id do produto: ");
                                                    int id = Integer.parseInt(sc.nextLine());
                                                    Album.removeProdutos(albunsList, id);
                                                    break;

                                                }
                                                case 2 -> {
                                                    System.out.println("Informe o id do produto: ");
                                                    int id = Integer.parseInt(sc.nextLine());
                                                    Brinquedo.removeProdutos(brinquedosList, id);
                                                    break;

                                                }
                                                case 3 -> {
                                                    System.out.println("Informe o id do produto: ");
                                                    int id = Integer.parseInt(sc.nextLine());
                                                    Filme.removeProdutos(filmesList, id);
                                                    break;

                                                }
                                                case 4 -> {
                                                    System.out.println("Informe o id do produto: ");
                                                    int id = Integer.parseInt(sc.nextLine());
                                                    Jogo.removeProdutos(jogosList, id);
                                                    break;

                                                }
                                                case 5 -> {
                                                    System.out.println("Informe o id do produto: ");
                                                    int id = Integer.parseInt(sc.nextLine());
                                                    Livro.removeProdutos(livrosList, id);
                                                    break;

                                                }
                                            }
                                        }
                                        case 4 -> {
                                            System.out.println("Itens em Estoque: ");
                                            System.out.println("Lista de Albumns");
                                            if (albunsList.size() > 0) {
                                                for (Album album : albunsList) {
                                                    if(album.getNumProdutos() > 0){
                                                    album.showProtoInfo();
                                                    System.out.println();
                                                    }
                                                }
                                                if(flagSemProdutosNoEstoque) {
                                                    System.out.println(msgProtudoEmFalta);
                                                }

                                            } else {
                                                System.out.println(msgNaoHaProdutosCadastrados);
                                            }


                                            System.out.println("Lista de Briquedos");
                                            if (brinquedosList.size() > 0) {
                                                for (Brinquedo toy : brinquedosList) {
                                                    if(toy.getNumProdutos() > 0){
                                                    toy.showProtoInfo();
                                                    System.out.println();
                                                }
                                                    else {
                                                        System.out.println(msgProtudoEmFalta);
                                                    }
                                            }

                                            } else {
                                                System.out.println(msgNaoHaProdutosCadastrados);
                                            }

                                            System.out.println("Lista de Fimles");
                                            if (filmesList.size() > 0) {

                                                for (Filme filme : filmesList) {
                                                    if (filme.getNumProdutos() > 0) {
                                                        filme.showProtoInfo();
                                                        System.out.println();
                                                    } else {
                                                        System.out.println(msgProtudoEmFalta);
                                                    }
                                                }
                                            }else {
                                                System.out.println(msgNaoHaProdutosCadastrados);
                                            }

                                            System.out.println("Lista de Jogos");
                                            if (jogosList.size() > 0) {
                                                for (Jogo jogo : jogosList) {
                                                    if (jogo.getNumProdutos() > 0) {
                                                        jogo.showProtoInfo();
                                                        System.out.println();
                                                    } else {
                                                        System.out.println(msgProtudoEmFalta);
                                                    }
                                                }
                                            } else {
                                                System.out.println(msgNaoHaProdutosCadastrados);
                                            }

                                            System.out.println("Lista de Livros");
                                            if (livrosList.size() > 0) {
                                                for (Livro livro : livrosList) {
                                                    if (livro.getNumProdutos() > 0) {
                                                        livro.showProtoInfo();
                                                        System.out.println();
                                                    } else {
                                                        System.out.println(msgProtudoEmFalta);
                                                    }
                                                }
                                            }else {
                                                System.out.println(msgNaoHaProdutosCadastrados);
                                            }
                                            break;
                                        }
                                        case 5 -> {
                                            listarProdutosPerCategory();
                                            int opcao = Integer.parseInt(sc.nextLine());
                                            switch (opcao) {
                                                case 1 -> {
                                                    System.out.println("Lista de Albumns");
                                                    if (albunsList.size() > 0) {
                                                        for (Album album : albunsList) {
                                                            if (album.getNumProdutos() > 0) {
                                                                album.showProtoInfo();
                                                                System.out.println();
                                                            } else {
                                                                flagSemProdutosNoEstoque = true;
                                                            }
                                                        }
                                                    }
                                                    if (flagSemProdutosNoEstoque){
                                                        System.out.println(msgProtudoEmFalta);
                                                    }
                                                    break;

                                                }

                                                case 2 -> {
                                                    System.out.println("Lista de Briquedos");
                                                    if (brinquedosList.size() > 0) {
                                                        for (Brinquedo toy : brinquedosList) {
                                                            if(toy.getNumProdutos() > 0) {
                                                                toy.showProtoInfo();
                                                                System.out.println();
                                                            }
                                                            else {
                                                                flagSemProdutosNoEstoque = true;
                                                            }
                                                        }
                                                        if (flagSemProdutosNoEstoque){
                                                            System.out.println(msgProtudoEmFalta);
                                                        }
                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }

                                                    break;
                                                }

                                                case 3 -> {
                                                    System.out.println("Lista de Fimles");
                                                    if (filmesList.size() > 0) {
                                                        for (Filme filme : filmesList) {
                                                            if (filme.getNumProdutos() > 0) {
                                                                filme.showProtoInfo();
                                                                System.out.println();
                                                            }
                                                            else {
                                                                flagSemProdutosNoEstoque = true;
                                                            }
                                                        }
                                                        if (flagSemProdutosNoEstoque){
                                                            System.out.println(msgProtudoEmFalta);
                                                        }

                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }
                                                    break;
                                                }

                                                case 4 -> {
                                                    System.out.println("Lista de Jogos");
                                                    if (jogosList.size() > 0) {
                                                        for (Jogo jogo : jogosList) {
                                                            if(jogo.getNumProdutos() > 0){
                                                            jogo.showProtoInfo();
                                                            System.out.println();
                                                        }
                                                            else {
                                                            flagSemProdutosNoEstoque = true;
                                                        }
                                                    }
                                                    if (flagSemProdutosNoEstoque){
                                                        System.out.println(msgProtudoEmFalta);
                                                    }
                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }
                                                    break;
                                                }

                                                case 5 -> {
                                                    System.out.println("Lista de Livros");
                                                    if (livrosList.size() > 0) {
                                                        for (Livro livro : livrosList) {
                                                            if(livro.getNumProdutos()>0){
                                                            livro.showProtoInfo();
                                                            System.out.println();
                                                            }
                                                            else {
                                                                flagSemProdutosNoEstoque = true;
                                                            }
                                                        }
                                                        if (flagSemProdutosNoEstoque){
                                                            System.out.println(msgProtudoEmFalta);
                                                        }
                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }
                                                    break;
                                                }
                                            }
                                        }
                                        case 6 -> {
                                            listarProdutosPerCategory();
                                            int opcao = Integer.parseInt(sc.nextLine());
                                            switch (opcao) {
                                                case 1 -> {
                                                    System.out.println("Informe o nome do album: ");
                                                    String nome = sc.nextLine();
                                                    for (Album album : albunsList) {
                                                        if (album.getNome().equals(nome)) {
                                                            if (album.getNumProdutos() > 0) {
                                                                user.getCarrinhoDeCompras().add(album);
                                                                album.setNumProdutos(album.getNumProdutos() - 1);
                                                            } else {
                                                                System.out.println(msgProtudoEmFalta);
                                                            }
                                                        } else {
                                                            System.out.println(msgNaoExiste);
                                                        }
                                                    }
                                                    break;

                                                }


                                                case 2 -> {
                                                    System.out.println("Informe o nome do briquedo: ");
                                                    String nome = sc.nextLine();
                                                    for (Brinquedo toy : brinquedosList) {
                                                        if (toy.getNome().equals(nome)) {
                                                            if (toy.getNumProdutos() > 0) {
                                                                user.getCarrinhoDeCompras().add(toy);
                                                                toy.setNumProdutos(toy.getNumProdutos() - 1);
                                                                System.out.println(msgSucess);
                                                            } else {
                                                                System.out.println(msgProtudoEmFalta);
                                                            }
                                                        } else {
                                                            System.out.println(msgNaoExiste);
                                                        }
                                                    }
                                                    break;

                                                }

                                                case 3 -> {
                                                    System.out.println("Informe o nome do Filme: ");
                                                    String nome = sc.nextLine();
                                                    for (Filme filme : filmesList) {
                                                        if (filme.getNome().equals(nome)) {
                                                            if (filme.getNumProdutos() > 0) {
                                                                user.getCarrinhoDeCompras().add(filme);
                                                                filme.setNumProdutos(filme.getNumProdutos() - 1);
                                                            } else {
                                                                System.out.println(msgProtudoEmFalta);
                                                            }
                                                        } else {
                                                            System.out.println(msgNaoExiste);
                                                        }
                                                    }
                                                    break;

                                                }


                                                case 4 -> {
                                                    System.out.println("Informe o nome do Jogo: ");
                                                    String nome = sc.nextLine();
                                                    for (Jogo jogo : jogosList) {
                                                        if (jogo.getNome().equals(nome)) {
                                                            if (jogo.getNumProdutos() > 0) {
                                                                user.getCarrinhoDeCompras().add(jogo);
                                                                jogo.setNumProdutos(jogo.getNumProdutos() - 1);
                                                                System.out.println(msgSucess);
                                                            } else {
                                                                System.out.println(msgProtudoEmFalta);
                                                            }
                                                        } else {
                                                            System.out.println(msgNaoExiste);
                                                        }
                                                    }
                                                    break;
                                                }

                                                case 5 -> {
                                                    System.out.println("Informe o nome do Livro: ");
                                                    String nome = sc.nextLine();
                                                    for (Livro livro : livrosList) {
                                                        if (livro.getNome().equals(nome)) {
                                                            if (livro.getNumProdutos() > 0) {
                                                                user.getCarrinhoDeCompras().add(livro);
                                                                livro.setNumProdutos(livro.getNumProdutos() - 1);
                                                                System.out.println(msgSucess);
                                                            } else {
                                                                System.out.println(msgProtudoEmFalta);
                                                            }
                                                        } else {
                                                            System.out.println(msgNaoExiste);
                                                        }
                                                    }
                                                    break;

                                                }
                                            }
                                        }
                                        case 7 -> {
                                            listarProdutosPerCategory();
                                            int opcao = Integer.parseInt(sc.nextLine());
                                            switch (opcao) {
                                                case 1 -> {
                                                    System.out.println("Informe o nome do album: ");
                                                    String nome = sc.nextLine();
                                                    for (Album album : albunsList) {
                                                        if (album.getNome().equals(nome)) {
                                                            user.getCarrinhoDeCompras().remove(album);
                                                            album.setNumProdutos(album.getNumProdutos() + 1);

                                                        } else {
                                                            System.out.println(msgNaoExiste);
                                                        }
                                                    }
                                                    break;

                                                }


                                                case 2 -> {
                                                    System.out.println("Informe o nome do briquedo: ");
                                                    String nome = sc.nextLine();
                                                    for (Brinquedo toy : brinquedosList) {
                                                        if (toy.getNome().equals(nome)) {
                                                            user.getCarrinhoDeCompras().remove(toy);
                                                            toy.setNumProdutos(toy.getNumProdutos() + 1);

                                                        } else {
                                                            System.out.println(msgNaoExiste);
                                                        }
                                                    }
                                                    break;

                                                }

                                                case 3 -> {
                                                    System.out.println("Informe o nome do Filme: ");
                                                    String nome = sc.nextLine();
                                                    for (Filme filme : filmesList) {
                                                        if (filme.getNome().equals(nome)) {
                                                            user.getCarrinhoDeCompras().remove(filme);
                                                            filme.setNumProdutos(filme.getNumProdutos() + 1);

                                                        } else {
                                                            System.out.println(msgNaoExiste);
                                                        }
                                                    }
                                                    break;

                                                }


                                                case 4 -> {
                                                    System.out.println("Informe o nome do Jogo: ");
                                                    String nome = sc.nextLine();
                                                    for (Jogo jogo : jogosList) {
                                                        if (jogo.getNome().equals(nome)) {
                                                            user.getCarrinhoDeCompras().remove(jogo);
                                                            jogo.setNumProdutos(jogo.getNumProdutos() + 1);

                                                        } else {
                                                            System.out.println(msgNaoExiste);
                                                        }
                                                    }
                                                    break;
                                                }

                                                case 5 -> {
                                                    System.out.println("Informe o nome do Livro: ");
                                                    String nome = sc.nextLine();
                                                    for (Livro livro : livrosList) {
                                                        if (livro.getNome().equals(nome)) {
                                                            user.getCarrinhoDeCompras().remove(livro);
                                                            livro.setNumProdutos(livro.getNumProdutos() + 1);

                                                        } else {
                                                            System.out.println(msgNaoExiste);
                                                        }
                                                    }
                                                    break;
                                                }

                                            }
                                        }
                                        case 8 -> {
                                            System.out.println("Carrinho de compras");
                                            for (Produto carrinho : user.getCarrinhoDeCompras()) {
                                                carrinho.showProtoInfo();

                                            }
                                            break;
                                        }
                                        case 9 -> {
                                            String msgFinalizarCompras = "Compras realizadas com sucesso!";
                                            double totalAPagar = user.totalAPagar();
                                            break;


                                        }
                                        case 0 -> {
                                            break loopUserLogged;
                                        }
                                    }
                                } else {
                                    switch (Integer.parseInt(sc.nextLine())) {
                                        case 1 -> {
                                            System.out.println("Itens em Estoque: ");
                                            System.out.println("Lista de Albumns");
                                            if (albunsList.size() > 0) {
                                                for (Album album : albunsList) {
                                                    if(album.getNumProdutos() > 0){
                                                        album.showProtoInfo();
                                                        System.out.println();
                                                    }
                                                }
                                                if(flagSemProdutosNoEstoque) {
                                                    System.out.println(msgProtudoEmFalta);
                                                }

                                            } else {
                                                System.out.println(msgNaoHaProdutosCadastrados);
                                            }


                                            System.out.println("Lista de Briquedos");
                                            if (brinquedosList.size() > 0) {
                                                for (Brinquedo toy : brinquedosList) {
                                                    if(toy.getNumProdutos() > 0){
                                                        toy.showProtoInfo();
                                                        System.out.println();
                                                    }
                                                    else {
                                                        System.out.println(msgProtudoEmFalta);
                                                    }
                                                }

                                            } else {
                                                System.out.println(msgNaoHaProdutosCadastrados);
                                            }

                                            System.out.println("Lista de Fimles");
                                            if (filmesList.size() > 0) {

                                                for (Filme filme : filmesList) {
                                                    if (filme.getNumProdutos() > 0) {
                                                        filme.showProtoInfo();
                                                        System.out.println();
                                                    } else {
                                                        System.out.println(msgProtudoEmFalta);
                                                    }
                                                }
                                            }else {
                                                System.out.println(msgNaoHaProdutosCadastrados);
                                            }

                                            System.out.println("Lista de Jogos");
                                            if (jogosList.size() > 0) {
                                                for (Jogo jogo : jogosList) {
                                                    if (jogo.getNumProdutos() > 0) {
                                                        jogo.showProtoInfo();
                                                        System.out.println();
                                                    } else {
                                                        System.out.println(msgProtudoEmFalta);
                                                    }
                                                }
                                            } else {
                                                System.out.println(msgNaoHaProdutosCadastrados);
                                            }

                                            System.out.println("Lista de Livros");
                                            if (livrosList.size() > 0) {
                                                for (Livro livro : livrosList) {
                                                    if (livro.getNumProdutos() > 0) {
                                                        livro.showProtoInfo();
                                                        System.out.println();
                                                    } else {
                                                        System.out.println(msgProtudoEmFalta);
                                                    }
                                                }
                                            }else {
                                                System.out.println(msgNaoHaProdutosCadastrados);
                                            }
                                            break;
                                        }
                                        case 2 -> {
                                            listarProdutosPerCategory();
                                            int opcao = Integer.parseInt(sc.nextLine());
                                            switch (opcao) {
                                                case 1 -> {
                                                    System.out.println("Lista de Albumns");
                                                    if (albunsList.size() > 0) {
                                                        for (Album album : albunsList) {
                                                            if (album.getNumProdutos() > 0) {
                                                                album.showProtoInfo();
                                                                System.out.println();
                                                            } else {
                                                                flagSemProdutosNoEstoque = true;
                                                            }
                                                        }
                                                    }
                                                    if (flagSemProdutosNoEstoque){
                                                        System.out.println(msgProtudoEmFalta);
                                                    }
                                                    break;

                                                }

                                                case 2 -> {
                                                    System.out.println("Lista de Briquedos");
                                                    if (brinquedosList.size() > 0) {
                                                        for (Brinquedo toy : brinquedosList) {
                                                            if(toy.getNumProdutos() > 0) {
                                                                toy.showProtoInfo();
                                                                System.out.println();
                                                            }
                                                            else {
                                                                flagSemProdutosNoEstoque = true;
                                                            }
                                                        }
                                                        if (flagSemProdutosNoEstoque){
                                                            System.out.println(msgProtudoEmFalta);
                                                        }
                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }

                                                    break;
                                                }

                                                case 3 -> {
                                                    System.out.println("Lista de Fimles");
                                                    if (filmesList.size() > 0) {
                                                        for (Filme filme : filmesList) {
                                                            if (filme.getNumProdutos() > 0) {
                                                                filme.showProtoInfo();
                                                                System.out.println();
                                                            }
                                                            else {
                                                                flagSemProdutosNoEstoque = true;
                                                            }
                                                        }
                                                        if (flagSemProdutosNoEstoque){
                                                            System.out.println(msgProtudoEmFalta);
                                                        }

                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }
                                                    break;
                                                }

                                                case 4 -> {
                                                    System.out.println("Lista de Jogos");
                                                    if (jogosList.size() > 0) {
                                                        for (Jogo jogo : jogosList) {
                                                            if(jogo.getNumProdutos() > 0){
                                                                jogo.showProtoInfo();
                                                                System.out.println();
                                                            }
                                                            else {
                                                                flagSemProdutosNoEstoque = true;
                                                            }
                                                        }
                                                        if (flagSemProdutosNoEstoque){
                                                            System.out.println(msgProtudoEmFalta);
                                                        }
                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }
                                                    break;
                                                }

                                                case 5 -> {
                                                    System.out.println("Lista de Livros");
                                                    if (livrosList.size() > 0) {
                                                        for (Livro livro : livrosList) {
                                                            if(livro.getNumProdutos()>0){
                                                                livro.showProtoInfo();
                                                                System.out.println();
                                                            }
                                                            else {
                                                                flagSemProdutosNoEstoque = true;
                                                            }
                                                        }
                                                        if (flagSemProdutosNoEstoque){
                                                            System.out.println(msgProtudoEmFalta);
                                                        }
                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }
                                                    break;
                                                }
                                            }
                                        }
                                        case 3 -> {
                                            listarProdutosPerCategory();
                                            int opcao = Integer.parseInt(sc.nextLine());
                                            switch (opcao) {
                                                case 1 -> {
                                                    System.out.println("Informe o nome do album: ");
                                                    String nome = sc.nextLine();
                                                    if (albunsList.size() > 0) {
                                                        for (Album album : albunsList) {
                                                            if (album.getNome().equals(nome)) {
                                                                if (album.getNumProdutos() > 0) {
                                                                    user.getCarrinhoDeCompras().add(album);
                                                                    album.setNumProdutos(album.getNumProdutos() - 1);
                                                                } else {
                                                                    System.out.println(msgProtudoEmFalta);
                                                                }
                                                            } else {
                                                                System.out.println(msgNaoExiste);
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }
                                                    break;

                                                }


                                                case 2 -> {
                                                    System.out.println("Informe o nome do briquedo: ");
                                                    String nome = sc.nextLine();
                                                    if (brinquedosList.size() > 0) {
                                                        for (Brinquedo toy : brinquedosList) {
                                                            if (toy.getNome().equals(nome)) {
                                                                if (toy.getNumProdutos() > 0) {
                                                                    user.getCarrinhoDeCompras().add(toy);
                                                                    toy.setNumProdutos(toy.getNumProdutos() - 1);
                                                                    System.out.println(msgSucess);
                                                                } else {
                                                                    System.out.println(msgProtudoEmFalta);
                                                                }
                                                            } else {
                                                                System.out.println(msgNaoExiste);
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }
                                                    break;

                                                }

                                                case 3 -> {
                                                    System.out.println("Informe o nome do Filme: ");
                                                    String nome = sc.nextLine();
                                                    if (filmesList.size() > 0) {
                                                        for (Filme filme : filmesList) {
                                                            if (filme.getNome().equals(nome)) {
                                                                if (filme.getNumProdutos() > 0) {
                                                                    user.getCarrinhoDeCompras().add(filme);
                                                                    filme.setNumProdutos(filme.getNumProdutos() - 1);
                                                                } else {
                                                                    System.out.println(msgProtudoEmFalta);
                                                                }
                                                            } else {
                                                                System.out.println(msgNaoExiste);
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }
                                                    break;

                                                }


                                                case 4 -> {
                                                    System.out.println("Informe o nome do Jogo: ");
                                                    String nome = sc.nextLine();
                                                    if (jogosList.size() > 0) {
                                                        for (Jogo jogo : jogosList) {
                                                            if (jogo.getNome().equals(nome)) {
                                                                if (jogo.getNumProdutos() > 0) {
                                                                    user.getCarrinhoDeCompras().add(jogo);
                                                                    jogo.setNumProdutos(jogo.getNumProdutos() - 1);
                                                                    System.out.println(msgSucess);
                                                                } else {
                                                                    System.out.println(msgProtudoEmFalta);
                                                                }
                                                            } else {
                                                                System.out.println(msgNaoExiste);
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }
                                                    break;
                                                }

                                                case 5 -> {
                                                    System.out.println("Informe o nome do Livro: ");
                                                    String nome = sc.nextLine();
                                                    if (livrosList.size() > 0) {
                                                        for (Livro livro : livrosList) {
                                                            if (livro.getNome().equals(nome)) {
                                                                if (livro.getNumProdutos() > 0) {
                                                                    user.getCarrinhoDeCompras().add(livro);
                                                                    livro.setNumProdutos(livro.getNumProdutos() - 1);
                                                                    System.out.println(msgSucess);
                                                                } else {
                                                                    System.out.println(msgProtudoEmFalta);
                                                                }
                                                            } else {
                                                                System.out.println(msgNaoExiste);
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }
                                                    break;

                                                }
                                            }
                                        }
                                        case 4 -> {
                                            listarProdutosPerCategory();
                                            int opcao = Integer.parseInt(sc.nextLine());

                                            switch (opcao) {
                                                case 1 -> {
                                                    System.out.println("Informe o nome do album: ");
                                                    String nome = sc.nextLine();
                                                    if (albunsList.size() > 0) {
                                                        for (Album album : albunsList) {
                                                            if (album.getNome().equals(nome)) {
                                                                user.getCarrinhoDeCompras().remove(album);
                                                                album.setNumProdutos(album.getNumProdutos() + 1);

                                                            } else {
                                                                System.out.println(msgNaoExiste);
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }
                                                    break;

                                                }


                                                case 2 -> {
                                                    System.out.println("Informe o nome do briquedo: ");
                                                    String nome = sc.nextLine();
                                                    if (brinquedosList.size() > 0) {
                                                        for (Brinquedo toy : brinquedosList) {
                                                            if (toy.getNome().equals(nome)) {
                                                                user.getCarrinhoDeCompras().remove(toy);
                                                                toy.setNumProdutos(toy.getNumProdutos() + 1);

                                                            } else {
                                                                System.out.println(msgNaoExiste);
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }
                                                    break;

                                                }

                                                case 3 -> {
                                                    System.out.println("Informe o nome do Filme: ");
                                                    String nome = sc.nextLine();
                                                    if (filmesList.size() > 0) {
                                                        for (Filme filme : filmesList) {
                                                            if (filme.getNome().equals(nome)) {
                                                                user.getCarrinhoDeCompras().remove(filme);
                                                                filme.setNumProdutos(filme.getNumProdutos() + 1);

                                                            } else {
                                                                System.out.println(msgNaoExiste);
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }
                                                    break;

                                                }


                                                case 4 -> {
                                                    System.out.println("Informe o nome do Jogo: ");
                                                    String nome = sc.nextLine();
                                                    if (jogosList.size() > 0) {
                                                        for (Jogo jogo : jogosList) {
                                                            if (jogo.getNome().equals(nome)) {
                                                                user.getCarrinhoDeCompras().remove(jogo);
                                                                jogo.setNumProdutos(jogo.getNumProdutos() + 1);

                                                            } else {
                                                                System.out.println(msgNaoExiste);
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }
                                                    break;
                                                }

                                                case 5 -> {
                                                    System.out.println("Informe o nome do Livro: ");
                                                    String nome = sc.nextLine();
                                                    if (livrosList.size() > 0) {
                                                        for (Livro livro : livrosList) {
                                                            if (livro.getNome().equals(nome)) {
                                                                user.getCarrinhoDeCompras().remove(livro);
                                                                livro.setNumProdutos(livro.getNumProdutos() + 1);

                                                            } else {
                                                                System.out.println(msgNaoExiste);
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println(msgNaoHaProdutosCadastrados);
                                                    }
                                                    break;
                                                }

                                            }
                                        }
                                        case 5 -> {
                                            System.out.println("Carrinho de compras");
                                            if (user.getCarrinhoDeCompras().size() > 0) {
                                                for (Produto carrinho : user.getCarrinhoDeCompras()) {
                                                    carrinho.showProtoInfo();

                                                }
                                            } else {
                                                System.out.println("O seu carrinho de compras está vazio!");
                                            }
                                            break;
                                        }
                                        case 6 -> {
                                            String msgFinalizarCompras = "Compras realizadas com sucesso!";
                                            double totalAPagar = user.totalAPagar();
                                            if (getSaldoCaixa() - totalAPagar > 0) {
                                                setSaldoCaixa(getSaldoCaixa() - totalAPagar);
                                            } else {
                                                setSaldoCaixa(0);
                                                System.out.println("Toma o troco em balinha, rsr!");
                                            }
                                            break;


                                        }
                                        case 0 -> {
                                            break loopUserLogged;
                                        }

                                    }

                                }
                            }


                        }
                        else {
                            System.out.println("Usuário não cadastrado!");
                        }
                    }
                    else {
                        System.out.println("Usuário não cadastrado!");
                    }
                }

                case 3 -> {
                    System.out.println("Informe o saldo inicial do caixa");
                    setSaldoCaixa(Double.parseDouble(sc.nextLine()));
                    break;

                }
            }

            }
}





    public static void menunUserLogged(User user) {

        if(user.getTypeUser().equals("ADM")){
            System.out.println("*----------------------------------------------*");
            System.out.print("|               Opções de Administrador        |\n");
            System.out.print("|----------------------------------------------|\n");
            System.out.print("|Registro de caixa: R$ "+getSaldoCaixa()+"|\n");
            System.out.print("|----------------------------------------------|\n");
            System.out.print("| 0 - Sair:                                    |\n");
            System.out.print("| 1 - Adicionar produto ao estoque:            |\n");
            System.out.print("| 2 - Alterar produto no estoque:              |\n");
            System.out.print("| 3 - Remover produto do estoque:              |\n");
            System.out.print("| 4 - Listar todos os itens do estoque:        |\n");
            System.out.print("| 5 - Listar por categoria:                    |\n");
            System.out.print("| 6 - Adicionar produto ao carrinho:           |\n");
            System.out.print("| 7 - Remover produto do carrinho:             |\n");
            System.out.print("| 8 - Ver carrinho de compras:                 |\n");
            System.out.print("| 9 - Finalizar compras:                       |\n");
            System.out.println("*---------------------------------------------*");


        }

        else{
            System.out.println("*----------------------------------------------*");
            System.out.print("|               Opções de usuario              |\n");
            System.out.print("|----------------------------------------------|\n");
            System.out.print("|-----Registro de caixa: R$ "+getSaldoCaixa()+"------------|\n");
            System.out.print("| 0 - Sair:                                    |\n");
            System.out.print("| 1 - Listar todos os itens do estoque:        |\n");
            System.out.print("| 2 - Listar por categoria:                    |\n");
            System.out.print("| 3 - Adicionar produto ao carrinho:           |\n");
            System.out.print("| 4 - Remover produto do carrinho:             |\n");
            System.out.print("| 5 - Ver carrinho de compras:                 |\n");
            System.out.print("| 6 - Finalizar compras:                       |\n");
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
