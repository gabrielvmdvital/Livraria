package br.com.americanas.polotech.livraria;

import br.com.americanas.polotech.livraria.enums.ProdutoEnum;
import br.com.americanas.polotech.livraria.models.Album;
import br.com.americanas.polotech.livraria.models.Livro;

public class Main {
    public static void main(String[] args) {
        Livro l1 = new Livro("LIVRO", 1, "O senhor dos aneis", 55.99, 10,
                "J. R. R. Tolkien", "Martins Fontes");

        l1.showLivroInfos();

        Album A1 = new Album("Album", 1, "by the way", 200.00,
                50, "Red hot", "Rock", "melhor dos anos 2000");

        A1.showAlbumInfos();
    }
}