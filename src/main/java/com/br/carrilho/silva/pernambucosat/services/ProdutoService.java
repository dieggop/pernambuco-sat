package com.br.carrilho.silva.pernambucosat.services;

import com.br.carrilho.silva.pernambucosat.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProdutoService {
	
	void apagarProduto(Long codigo);
    Produto salvaProduto(Produto produto);
    Optional<Produto> recuperarProduto(Long codigo);
    Page<Produto> pesquisarProduto(Produto codigo, Pageable pageable);
    Page<Produto> pesquisaTodosProdutos(Pageable Pageable);
}
