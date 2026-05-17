package com.example.Testando123.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    public Usuario(String user, String senha, String email) {
        this.user = user;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(String user, String senha, String email, List<Pedido> pedidos) {
        this.user = user;
        this.senha = senha;
        this.email = email;
        this.pedidos = pedidos;
    }

    public Usuario() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String user;
    private String senha;
    private String email;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();


    public long getId() {
        return id;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
