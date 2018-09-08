package com.br.carrilho.silva.pernambucosat.repository;

import java.util.List;

import com.br.carrilho.silva.pernambucosat.model.Produto;

public interface ProdutoRepository {
	
	void persistirProduto(Produto id);
	void apagarProduto(Produto codigo);
	void atualizarProduto(Produto codigo);
	void salvaProduto();
    Produto recuperarProduto(String codigo);
    List<Produto> pesquisarProduto(Produto codigo);
    List<Produto> pesquisaTodosProdutos();
    
}
