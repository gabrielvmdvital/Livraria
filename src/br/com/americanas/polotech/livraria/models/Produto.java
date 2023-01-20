package br.com.americanas.polotech.livraria.models;

import br.com.americanas.polotech.livraria.enums.ProdutoEnum;

abstract public class Produto {

    public String produtoType;
    private String nome;
    private double preco;

    private int numProdutos;
    private int id;
    private static int countId = 0;

    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Produto(ProdutoEnum category, String nome, double preco, int numProdutos){
        this.nome = nome;
        this.preco = (double) preco;
        this.numProdutos = numProdutos;
        id = countId++;

    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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



    public abstract void showProtoInfo();



}
