package br.com.americanas.polotech.livraria.models;

public class Album extends  Produto{
    private String musicosEBandas;
    private String genero;
    private String selos;
    private static int qtdAlbuns;
    public Album(String produtoType, int id, String nome, double preco, int numProdutos,
                 String musicosEBandas, String genero, String selos) {
        super(produtoType, id, nome, preco, numProdutos);
        this.musicosEBandas = musicosEBandas;
        this.genero = genero;
        this.selos = selos;
        this.qtdAlbuns++;
    }

    public String getGenero() {
        return genero;
    }

    public String getSelos() {
        return selos;
    }

    public String getMusicosEBandas() {
        return musicosEBandas;
    }

    public void showAlbumInfos(){
        System.out.printf("Id: %d\nNome do Album: %s\nBanda/Musicos: %s\nGenero: %s\n" +
                        "Selos: %s\nPreço: R$ %.2f\nQuantidade em estoque: %d\n",
                        getId(), getNome(), this.getMusicosEBandas(), this.getGenero(),
                        this.getSelos(), getPreco(), getNumProdutos());

    }
}
