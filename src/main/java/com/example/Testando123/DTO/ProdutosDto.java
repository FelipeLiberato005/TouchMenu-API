package com.example.Testando123.DTO;

public class ProdutosDto {
    public record ProdutosRequestDTO(String nome, String descricao, double valorTotal, long tempoEstimado) {}
}
