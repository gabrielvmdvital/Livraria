package br.com.americanas.polotech.livraria.models;

public class Filme extends  Produto{
    private String estudio;
    private String diretores;
    private String produtores;

    private static int qtdFilmes;

    public Filme(String produtoType, int id, String nome, double preco, int numProdutos,
                 String estudio, String diretores, String produtores) {
        super(produtoType, id, nome, preco, numProdutos);
        this.estudio = estudio;
        this.diretores = diretores;
        this.produtores = produtores;
        this.qtdFilmes++;
    }

    public String getDiretores() {
        return this.diretores;
    }

    public String getProdutores() {
        return this.produtores;
    }

    public String getEstudio() {
        return this.estudio;
    }
}
