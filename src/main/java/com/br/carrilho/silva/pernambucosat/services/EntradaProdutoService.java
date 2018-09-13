package com.br.carrilho.silva.pernambucosat.services;

import java.util.List;

import com.br.carrilho.silva.pernambucosat.model.EntradaProduto;

public interface EntradaProdutoService {

	void persistirEntradaProduto(EntradaProduto id);
	void apagarEntradaProduto(EntradaProduto id);
	void atualizarEntradaProduto(EntradaProduto id);
	void salvaEntradaProduto();
	EntradaProduto recuperarEntradaProduto(EntradaProduto entradaProduto);
    List<EntradaProduto> pesquisarEntradaProduto(EntradaProduto entradaProduto);
    List<EntradaProduto> pesquisaTodasEntradasProduto();
	
	
}
