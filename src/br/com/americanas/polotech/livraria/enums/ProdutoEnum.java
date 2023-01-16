package br.com.americanas.polotech.livraria.enums;

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
