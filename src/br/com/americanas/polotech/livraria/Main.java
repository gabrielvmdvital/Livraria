package br.com.americanas.polotech.livraria;
import br.com.americanas.polotech.livraria.models.Livraria;
import br.com.americanas.polotech.livraria.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<User> usuarios = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Livraria livraria = new Livraria();
        //System.out.println(livraria.getSaldoCaixa());
        livraria.menu(sc, usuarios);
    }

}
