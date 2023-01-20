package br.com.americanas.polotech.livraria.models;

import br.com.americanas.polotech.livraria.enums.ProdutoEnum;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class Brinquedo extends  Produto {
    private String tipo;
    private String genero;
    public static int size;
    public static int brinquedoId = 1;
    private int id;

    public Brinquedo(ProdutoEnum category, String nome, double preco, int numProdutos, String tipo) {
        super(category,nome, preco, numProdutos);
        this.tipo = tipo;
        this.id = brinquedoId;
        ++size;
        brinquedoId++;
    }

    public String getTipo() {
        return tipo;
    }


    @Override
    public String toString() {
        return "Id: BRI#" + this.getId() + "\nNome do brinquedo: " + getNome() + "\nTipo: " + this.getTipo()
                + "\nPreço: R$ " + getPreco() + "\nQuantidade em estoque: "+ getNumProdutos();
    }

    @Override
    public void showProInfo() {
        System.out.println(this.toString());
        System.out.println();
    }

    public static void addProduto(List<Brinquedo> toys, Scanner sc){

        System.out.println("Informe o nome do brinquedo: ");
        String nome = sc.nextLine();
        System.out.println("Informe o tipo do brinquedo: ");
        String tipo = sc.nextLine();
        System.out.println("Informe o preço: ");
        double preco = Double.parseDouble(sc.nextLine());
        System.out.println("Informe a quantidade");
        int numProdutos = Integer.parseInt(sc.nextLine());
        Brinquedo brinquedo1 = new Brinquedo(ProdutoEnum.BRINQUEDO, nome, preco, numProdutos, tipo);
        Optional<Brinquedo> brinquedo = toys.stream().filter((Brinquedo toy) ->
            brinquedo1.equals(toy)).findFirst();

        if(brinquedo.isPresent()){
            int numAtualProdutos = brinquedo.get().getNumProdutos();
            brinquedo.get().setNumProdutos(numAtualProdutos+numProdutos);
            toys.remove(brinquedo.get().getId());
            toys.add(brinquedo.get());
            size--;
        }
        else{
            toys.add(brinquedo1);
        }

    }

    public static void removeProdutos(List<Brinquedo> toys, int id) {
        toys.stream().forEach((Brinquedo toy) -> {
            if (id == toy.getId()) {
                if (toy.getNumProdutos() >= 0) {
                    toy.setNumProdutos(0);
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
        if (!(o instanceof Brinquedo brinquedo)) return false;
        return Objects.equals(getTipo(), brinquedo.getTipo()) && genero.equals(brinquedo.genero) &&
                Objects.equals(getNome(), brinquedo.getNome());
    }

}
