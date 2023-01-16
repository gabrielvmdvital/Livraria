package br.com.americanas.polotech.livraria.models;

public class Jogo extends  Produto{
    private String distribuidora;
    private String estudio;
    private static int qtdJogos;

    public Jogo(String produtoType, int id, String nome, double preco, int numProdutos,
                 String distribuidora, String estudio) {
        super(produtoType, id, nome, preco, numProdutos);
        this.distribuidora = distribuidora;
        this.estudio = estudio;
        this.qtdJogos++;
    }
}
