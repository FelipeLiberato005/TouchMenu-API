package com.example.Testando123.service;

import com.example.Testando123.model.Produtos;
import com.example.Testando123.repository.ProdutosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosService {

    private final ProdutosRepository produtosRepository;

    public ProdutosService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }


    public List<Produtos> listar()
    {
      return produtosRepository.findAll();
    }

    public Produtos salvar(String nome, String descricao, double valorTotal, long tempoEstimado)
    {
        Produtos produtos = new Produtos(nome, descricao, valorTotal, tempoEstimado);

        return produtosRepository.save(produtos);
    }

    public void deletar(Long id)
    {
        produtosRepository.deleteById(id);
    }


}
