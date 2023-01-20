package br.com.americanas.polotech.livraria.models;

import br.com.americanas.polotech.livraria.enums.ProdutoEnum;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class Filme extends  Produto {
    private String estudio;
    private String diretores;
    private String produtores;
    private String genero;
    public static int size = 0;
    public static int filmeId = 1;
    private int id;


    public Filme(ProdutoEnum category, String nome, String genero, double preco, int numProdutos,
                 String estudio, String diretores, String produtores) {
        super(category, nome, preco, numProdutos);
        this.estudio = estudio;
        this.genero = genero;
        this.diretores = diretores;
        this.produtores = produtores;
        this.id = filmeId;
        ++size;
        filmeId++;
    }

    public String getDiretores() {
        return this.diretores;
    }

    public String getProdutores() {
        return this.produtores;
    }

    public String getGenero() {
        return genero;
    }

    public String getEstudio() {
        return this.estudio;
    }


    @Override
    public String toString() {
        return "Id: FIL#" + this.getId() + "\nNome do filme: " + getNome() + "\nGenero: " + this.getGenero() + "\nEstudio: " + this.getEstudio()
                + "\nDiretores: " + this.getDiretores() + "\nProdutores: " + this.getProdutores() + "\nPreço: R$ " + getPreco()
                + "\nQuantidade em estoque: " + getNumProdutos();
    }

    @Override
    public void showProtoInfo() {
        System.out.println(this.toString());
    }

    public static void addProduto(List<Filme> filmes, Scanner sc) {
        System.out.println("Informe o nome do Filme: ");
        String nome = sc.nextLine();
        System.out.println("Informe o genero do Filme: ");
        String genero = sc.nextLine();
        System.out.println("Informe a distribuidora: ");
        String distribuidores = sc.nextLine();
        System.out.println("Informe o nome do editor: ");
        String editor = sc.nextLine();
        System.out.println("Informe o nome do estudio: ");
        String estudio = sc.nextLine();
        System.out.println("Informe o preço: ");
        double preco = Double.parseDouble(sc.nextLine());
        System.out.println("Informe a quantidade");
        int numProdutos = Integer.parseInt(sc.nextLine());

        Filme filme1 = new Filme(ProdutoEnum.FILME, nome, genero, preco, numProdutos, estudio, distribuidores, editor);
        Optional<Filme> filme2 = filmes.stream().filter((Filme filme) ->
                filme.equals(filme1)).findFirst();
        if (filme2.isPresent()) {
            int numAtualProdutos = filme2.get().getNumProdutos();
            filme2.get().setNumProdutos(numAtualProdutos + numProdutos);
            filmes.remove(filme2.get().getId());
            filmes.add(filme2.get());
            size--;;
        }
        else{
            filmes.add(filme1);
    }

}

    public static void removeProdutos(List<Filme> filmes, int id) {
        filmes.stream().forEach((Filme filme) -> {
            if (id == filme.getId()) {
                if (filme.getNumProdutos() >= 0) {
                    filme.setNumProdutos(0);
                    System.out.println("Produto removido!");
                    size--;
                } else {
                    System.out.println("Produto não encontrado.");
                }
            }
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Filme filme)) return false;
        return getEstudio().equals(filme.getEstudio()) && getDiretores().equals(filme.getDiretores())&&
                getProdutores().equals(filme.getProdutores()) && getGenero().equals(filme.getGenero()) &&
                getNome().equals(filme.getNome());
    }

}
