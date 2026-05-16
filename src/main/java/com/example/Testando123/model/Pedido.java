package com.example.Testando123.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pedido")
public class Pedido {


    public Pedido(String status, double valorTotal, long tempoEstimado, String dataHora) {
        this.status = status;
        this.valorTotal = valorTotal;
        this.tempoEstimado = tempoEstimado;
        this.dataHora = dataHora;
    }

    public Pedido() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String status;
    private double valorTotal;
    private long tempoEstimado;
    private String dataHora;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}
