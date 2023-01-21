package br.com.americanas.polotech.livraria.models;

import br.com.americanas.polotech.livraria.enums.ProdutoEnum;

import java.util.*;
import java.util.stream.Collectors;

public class User {
    private String userName;
    private String password;
    private String typeUser;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isUserLogged() {
        return userLogged;
    }

    public void setUserLogged(boolean userLogged) {
        this.userLogged = userLogged;
    }

   // public void setCarrinhoDeCompras(List<Produto> carrinhoDeCompras) {
  //      this.carrinhoDeCompras = carrinhoDeCompras;
   // }

    private boolean userLogged = false;

    private List<Produto> carrinhoDeCompras = new ArrayList<>();


    public User(String userName, String password){
        if(userName.contains("admin".toLowerCase())){
            this.setTypeUser("ADM");
        }
        else{
            this.setTypeUser("Client");
        }
        this.userName = userName;
        this.password = password;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    public static void addUser(List<User> users, User user){
        users.add(user);
    }

    public List<Produto> getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }

    public static User loginSystem(String login, String password, List<User> users) {
        boolean loginValidator = false;

        User userLogado = users.stream().filter(user -> user.getUserName().equals(login) &&
                user.getPassword().equals(password)).findFirst().orElse(null);
        if (userLogado != null) {
            userLogado.setUserLogged(true);

            if (userLogado.isUserLogged()) {
                System.out.println("Bem-vindo ao AdaTweeter " + userLogado.getUserName() + "!");
                System.out.println();
            }
        } else {
            System.out.println("Login ou Senha são invalidos, ou usuário não foi cadastrado!");
            System.out.println();
        }
        return userLogado;
    }

    public  double totalAPagar() {
        double totalAPagar = 0;
        for (Produto carrinho : this.getCarrinhoDeCompras()) {
            totalAPagar += carrinho.getPreco();

        }
        return totalAPagar;
    }
}

