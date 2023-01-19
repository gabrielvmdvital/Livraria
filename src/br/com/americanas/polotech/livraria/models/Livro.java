package br.com.americanas.polotech.livraria.models;

public class Livro extends  Produto {
    private String escritor;
    private String editora;

    private static int qtdLivros = 0;

    public Livro(String produtoType, int id, String nome, double preco, int numProdutos,
                 String escritor, String editora) {
        super(produtoType, id, nome, preco, numProdutos);
        this.escritor = escritor;
        this.editora = editora;
        this.qtdLivros++;

    }

   public void alterarDadosDosLivros(int id, String nome, double preco,
                        int numProdutos, String escritor, String editora) {

        setId(id);
        setNome(nome);
        setPreco(preco);
        setNumProdutos(numProdutos);
        this.escritor = escritor;
        this.editora = editora;
   }

    public String getEditora() {
        return editora;
    }

    public String getEscritor(){
        return this.escritor;
    }

    public void showLivroInfos(){
       System.out.printf("Id: %d\nNome do Livro: %s\nEscrito por: " +
               "%s \nEditora: %s\nPreço: R$ %.2f\nQuantidade em estoque: %d\n",
               getId(), getNome(), this.getEscritor(), this.getEditora(), getPreco(), getNumProdutos());
   }


}
