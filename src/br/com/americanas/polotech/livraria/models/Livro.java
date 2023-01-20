package br.com.americanas.polotech.livraria.models;

import br.com.americanas.polotech.livraria.enums.ProdutoEnum;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class Livro extends  Produto {

    private String escritor;
    private String editora;
    private String genero;

    public static int livroId = 1;
    public static int size = 0;

    public Livro(ProdutoEnum category, String nome, String genero, double preco, int numProdutos,
                 String escritor, String editora) {
        super(category,nome, preco, numProdutos);
        this.escritor = escritor;
        this.genero = genero;
        this.editora = editora;
        ++size;
        livroId++;
    }

    public String getGenero() {
        return genero;
    }

    public String getEditora() {
        return editora;
    }

    public String getEscritor(){
        return this.escritor;
    }



    @Override
    public String toString() {
        return "Id: LIV#"+ this.getId() +"\nNome do Livro: " + getNome() + "\nGenero: "+ this.getGenero() + "\nEscrito por: "+ this.getEscritor()
                +"\nEditora: "+getEditora() + "Preco: R$ " + getPreco()
                + "\nQuantidade em estoque: "+ getNumProdutos();
    }

    @Override
    public void showProtoInfo() {
        System.out.println(this.toString());
    }

    public static void addProduto(List<Livro> livros, Scanner sc){
        System.out.println("Informe o nome do Livro: ");
        String nome = sc.nextLine();
        System.out.println("Informe o genero: ");
        String genero = sc.nextLine();
        System.out.println("Informe a(o) escritor: ");
        String escritor = sc.nextLine();
        System.out.println("Informe a Editora: ");
        String editora = sc.nextLine();
        System.out.println("Informe o preço: ");
        double preco = Double.parseDouble(sc.nextLine());
        System.out.println("Informe a quantidade");
        int numProdutos = Integer.parseInt(sc.nextLine());
        Livro l1 = new Livro(ProdutoEnum.LIVRO, nome, genero, preco, numProdutos, escritor, editora);
        Optional<Livro> liv = livros.stream().filter((Livro livro) ->
              livro.equals(l1)).findFirst();

        if(liv.isPresent()){
            int numAtualProdutos = liv.get().getNumProdutos();
            liv.get().setNumProdutos(numAtualProdutos+numProdutos);
            livros.remove(liv.get().getId());
            livros.add(liv.get());
            size--;
        }
        else{
            livros.add(l1);

        }
    }


    public static void removeProdutos(List<Livro> livros, int id) {
        System.out.println("Informe o id do produto que deseja remover: ");
        livros.stream().forEach((Livro livro) -> {
            if (id == livro.getId()) {
                if (livro.getNumProdutos() >= 0) {
                    livro.setNumProdutos(0);
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
        if (!(o instanceof Livro livro)) return false;
        return getNome().equals(livro.getNome()) && getEscritor().equals(livro.getEscritor()) &&
                getEditora().equals(livro.getEditora()) && getGenero().equals(livro.getGenero());
    }
}

