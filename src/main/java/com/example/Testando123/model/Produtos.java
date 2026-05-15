package com.example.Testando123.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produtos {


    public Produtos(String nome, String descricao, double valorTotal, long tempoEstimado) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.tempoEstimado = tempoEstimado;
    }

    public Produtos() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String nome;
    private String descricao;
    private double valorTotal;
    private long tempoEstimado;



    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public long getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(long tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }
}
