package br.com.americanas.polotech.livraria.models;

import br.com.americanas.polotech.livraria.enums.ProdutoEnum;

abstract class Produto {

    public enum ProdutoEnum {

        LIVRO(1), JOGO(2), FILME(3), ALBUNS_DE_MUSICA(4), BRINQUEDO(5);
        private Integer productTypeId;
        ProdutoEnum(Integer productId){
            this.productTypeId = productTypeId;
        }

        public Integer getIdType(){
            return this.productTypeId;
        }

    }

    public String produtoType;
    private int id;
    private String nome;
    private double preco;

    private int numProdutos;

    public Produto(String produtoType, int id, String nome, double preco, int numProdutos){
        this.produtoType = produtoType;
        this.nome = nome;
        this.id = id;
        this.preco = preco;
        this.numProdutos = numProdutos;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public double getPreco(){
        return this.preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getNumProdutos() {
        return numProdutos;
    }

    public void setNumProdutos(int numProdutos) {
        this.numProdutos = numProdutos;
    }

    public String getProdutoType() {
        return produtoType;
    }
}
