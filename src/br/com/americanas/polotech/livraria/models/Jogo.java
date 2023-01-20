package br.com.americanas.polotech.livraria.models;

import br.com.americanas.polotech.livraria.enums.ProdutoEnum;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class Jogo extends  Produto{

    private String distribuidora;
    private String estudio;

    public String getGenero() {
        return genero;
    }

    private String genero;
    public static int jogoId = 1;
    public static int size = 0;
    private int id;

    public Jogo(ProdutoEnum category, String nome, String genero, double preco, int numProdutos,
                String distribuidora, String estudio){
        super(category, nome, preco, numProdutos);
        this.distribuidora = distribuidora;
        this.estudio = estudio;
        this.id = jogoId;
        ++size;
        jogoId++;

    }

    public String getDistribuidora() {
        return this.distribuidora;
    }

    public String getEstudio() {
        return this.estudio;
    }



    @Override
    public String toString() {
        return "Id: JOG#" + this.getId() + "\nNome do jogo: " + getNome() + "\nGenero: "+ this.getGenero() +"\nEstudio: " + this.getEstudio()
                + "\ndistribuidora: " + this.getDistribuidora() + "\nPreço: R$ " + getPreco()
                + "\nQuantidade em estoque: "+ getNumProdutos();
    }

    @Override
    public void showProtoInfo() {
        System.out.println(this.toString());
    }

    public static void addProduto(List<Jogo> games, Scanner sc){
        System.out.println("Informe o nome do Jogo: ");
        String nome = sc.nextLine();
        System.out.println("Informe o genero do jogo: ");
        String genero = sc.nextLine();
        System.out.println("Informe a distribuidora do jogo: ");
        String distribuidora = sc.nextLine();
        System.out.println("Informe o estudio de criação do jogo: ");
        String estudio = sc.nextLine();
        System.out.println("Informe o preço: ");
        double preco = Double.parseDouble(sc.nextLine());
        System.out.println("Informe a quantidade");
        int numProdutos = Integer.parseInt(sc.nextLine());
        Jogo jogo1 = new Jogo(ProdutoEnum.JOGO, nome, genero, preco, numProdutos, distribuidora, estudio);
        Optional<Jogo> jogo2 = games.stream().filter((Jogo jogo) ->
                jogo.equals(jogo1)).findFirst();
        if(jogo2.isPresent()){
            int numAtualProdutos = jogo2.get().getNumProdutos();
            jogo2.get().setNumProdutos(numAtualProdutos+numProdutos);
            games.remove(jogo2.get().getId());
            games.add(jogo2.get());
            size--;
        }
        else{
            games.add(jogo1);
        }
    }

    public static void removeProdutos(List<Jogo> jogos, int id) {
        jogos.stream().forEach((Jogo jogo) -> {
            if (id == jogo.getId()) {
                if (jogo.getNumProdutos() >= 0) {
                    jogo.setNumProdutos(0);
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
        if (!(o instanceof Jogo jogo)) return false;
        return getDistribuidora().equals(jogo.getDistribuidora()) && getEstudio().equals(jogo.getEstudio()) &&
                getNome().equals(jogo.getNome()) && getGenero().equals(jogo.getGenero());
    }


}

