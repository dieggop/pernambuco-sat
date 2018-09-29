package com.br.carrilho.silva.pernambucosat.services.impl;

import com.br.carrilho.silva.pernambucosat.Exceptions.ExceptionConflict;
import com.br.carrilho.silva.pernambucosat.model.Produto;
import com.br.carrilho.silva.pernambucosat.repository.ProdutoRepository;
import com.br.carrilho.silva.pernambucosat.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProdutoServiceImpl implements ProdutoService {


    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public void apagarProduto(Long codigo) {

        produtoRepository.deleteById(codigo);
    }

    @Override
    public Produto salvaProduto(Produto produto) {
        try {
            return produtoRepository.save(produto);
        } catch (Exception e)
        {
            throw new ExceptionConflict("Produto já existe.");
        }
    }

    @Override
    public Optional<Produto> recuperarProduto(Long codigo) {
        return produtoRepository.findById(codigo);
    }

    @Override
    public Page<Produto> pesquisarProduto(Produto codigo, Pageable pageable) {
        return produtoRepository.findByDescricaoContainingIgnoreCase(codigo, pageable);
    }

    @Override
    public Page<Produto> pesquisaTodosProdutos(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

}
