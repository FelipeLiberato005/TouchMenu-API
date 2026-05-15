package com.example.Testando123.DTO;

public class PedidoDto {
    public record ProdutosRequestDTO(String status, double valorTotal, long tempoEstimado, String dataHora) {}
}
