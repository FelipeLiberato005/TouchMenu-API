package com.example.Testando123.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    public Usuario(String user, String senha, String email) {
        this.user = user;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(String nome, String descricao, double valorTotal, long tempoEstimado) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String user;
    private String senha;
    private String email;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public long getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
