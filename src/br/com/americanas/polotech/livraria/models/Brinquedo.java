package br.com.americanas.polotech.livraria.models;

public class Brinquedo extends  Produto {
    private String tipo;

    private static int qtdBrinquedos;

    public Brinquedo(String produtoType, int id, String nome, double preco, int numProdutos, String tipo) {
        super(produtoType, id, nome, preco, numProdutos);
        this.tipo = tipo;
        this.qtdBrinquedos++;

    }

    public String getTipo() {
        return tipo;
    }
}
