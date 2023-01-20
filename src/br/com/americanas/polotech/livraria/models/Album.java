package br.com.americanas.polotech.livraria.models;

import br.com.americanas.polotech.livraria.enums.ProdutoEnum;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Album extends Produto {
    private String musicosEBandas;
    private String genero;
    private String selos;
    public static int albumId = 1;
    public static int size;
    private int id;

    public Album(ProdutoEnum category, String nome, String genero, double preco, int numProdutos, String musicosEBandas, String selos) {
        super(category, nome, preco, numProdutos);
        this.musicosEBandas = musicosEBandas;
        this.genero = genero;
        this.selos = selos;
        ++size;
        this.id = albumId++;
    }

    public String getGenero() {
        return this.genero;
    }

    public String getSelos() {
        return this.selos;
    }

    public String getMusicosEBandas() {
        return this.musicosEBandas;
    }


    public String toString() {
        int var10000 = this.getId();
        return "Id: ALB#" + var10000 + "\nNome do Album: " + this.getNome() + "\nBanda/musicos: " + this.getMusicosEBandas() + "\nGenero: " + this.getGenero() + "\nSelos: " + this.getSelos() + "\nPreço: R$ " + this.getPreco() + "\nQuantidade em estoque: " + this.getNumProdutos();
    }

    public void showAlbumInfos() {
        System.out.printf("Id: %d\nNome do Album: %s\nBanda/Musicos: %s\nGenero: %s\nSelos: %s\nPreço: R$ %.2f\nQuantidade em estoque: %d\n", this.getId(), this.getNome(), this.getMusicosEBandas(), this.getGenero(), this.getSelos(), this.getPreco(), this.getNumProdutos());
    }

    public void showProtoInfo() {
        System.out.println(this.toString());
        System.out.println();
    }

    public static void addProduto(List<Album> albumns, Scanner sc) {
        System.out.println("Informe o nome do album: ");
        String nome = sc.nextLine();
        System.out.println("Informe o nome da Banda/musicos: ");
        String musicosEBandas = sc.nextLine();
        System.out.println("Informe o genero musical: ");
        String genero = sc.nextLine();
        System.out.println("Informe os selos: ");
        String selos = sc.nextLine();
        System.out.println("Informe o preço: ");
        double preco = Double.parseDouble(sc.nextLine());
        System.out.println("Informe a quantidade");
        int numProdutos = Integer.parseInt(sc.nextLine());
        Album album1 = new Album(ProdutoEnum.ALBUNS_DE_MUSICA, nome, genero, preco, numProdutos, musicosEBandas, selos);
        Optional<Album> ab = albumns.stream().filter((album) -> album.equals(album1)).findFirst();
        if (ab.isPresent()) {
            int numAtualProdutos = ((Album)ab.get()).getNumProdutos();
            ((Album)ab.get()).setNumProdutos(numAtualProdutos + numProdutos);
            albumns.remove(((Album)ab.get()).getId());
            albumns.add((Album)ab.get());
            --size;
        } else {
            albumns.add(album1);
        }

    }

    public static void removeProdutos(List<Album> albumns, int id) {
        albumns.stream().forEach((album) -> {
            if (id == album.getId()) {
                if (album.getNumProdutos() >= 0) {
                    album.setNumProdutos(0);
                    System.out.println("Produto removido!");
                    --size;
                } else {
                    System.out.println("Produto não encontrado.");
                }
            }

        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Album)) {
            return false;
        } else {
            Album album = (Album)o;
            return this.getNome().equals(album.getNome()) && this.getMusicosEBandas().equals(album.getMusicosEBandas()) && this.getGenero().equals(album.getGenero()) && this.getSelos().equals(album.getSelos());
        }
    }
}
