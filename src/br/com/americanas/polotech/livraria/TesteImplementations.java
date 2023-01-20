package br.com.americanas.polotech.livraria;

import br.com.americanas.polotech.livraria.enums.ProdutoEnum;
import br.com.americanas.polotech.livraria.models.Album;
import br.com.americanas.polotech.livraria.models.Livro;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Livro l1 = new Livro(ProdutoEnum.LIVRO,"O senhor dos aneis", "Ficção/Magia e aventura",55.99, 10,
                "J. R. R. Tolkien", "Martins Fontes");

        l1.showProtoInfo();
        System.out.println();
        l1.setPreco(99.99);
        l1.showProtoInfo();

        Album A1 = new Album( ProdutoEnum.ALBUNS_DE_MUSICA,"by the way", "Rock",200.00
                ,10, "Red hot", "melhor dos anos 2000");

        A1.showProtoInfo();

        Livro l2 = new Livro(ProdutoEnum.LIVRO,"livro 2", "Magia",100.0, 10, "autor 2",
                "editora 2");

        List<Livro> livros = new ArrayList<>();
        livros.add(l1);
        livros.add(l2);
        System.out.println("Antes de remover itens -> Quantidade de tipos livros: " + Livro.size);
        Livro.removeProdutos(livros, 1);
        System.out.println("Depois de remover itens -> Quantidade de tipos livros: " + Livro.size);

        livros.stream().forEach((Livro livro) -> livro.showProtoInfo());

    }


}