package br.com.americanas.polotech.livraria.models;

import br.com.americanas.polotech.livraria.enums.ProdutoEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
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

    public static void setUsuarios(List<User> usuarios) {
        User.usuarios = usuarios;
    }

    public void setCarrinhoDeCompras(List<Produto> carrinhoDeCompras) {
        this.carrinhoDeCompras = carrinhoDeCompras;
    }

    private boolean userLogged = false;

    private static List<User> usuarios = new ArrayList<>();
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


    public static List<User> getUsuarios() {
        return usuarios;
    }

    public static void addUser(User user){
        getUsuarios().add(user);
    }

    public List<Produto> getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }

    public static User loginSystem(String login, String password){
        boolean loginValidator = false;

        User userLogado = (User) getUsuarios().stream().filter(user -> user.getUserName().equals(login) &&
                user.getPassword().equals(password));

        userLogado.setUserLogged(true);

        if(userLogado.isUserLogged()) {
            System.out.println("Bem-vindo ao AdaTweeter "+ userLogado.getUserName() +"!");
            System.out.println();
            return userLogado;
        }
        else{
            System.out.println("Login ou Senha são invalidos, ou usuário não foi cadastrado!");
            System.out.println();

            return null;
        }


    }

    public void addProductsToCart(Produto produto){
        if(isUserLogged()){
        getCarrinhoDeCompras().add(produto);
        }
    }

}
