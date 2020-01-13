package com.br.systemusecar.services;

import java.util.List;

import com.br.systemusecar.model.EntradaProduto;

public interface EntradaProdutoService {

	void persistirEntradaProduto(EntradaProduto id);
	void apagarEntradaProduto(EntradaProduto id);
	void atualizarEntradaProduto(EntradaProduto id);
	void salvaEntradaProduto();
	EntradaProduto recuperarEntradaProduto(EntradaProduto entradaProduto);
    List<EntradaProduto> pesquisarEntradaProduto(EntradaProduto entradaProduto);
    List<EntradaProduto> pesquisaTodasEntradasProduto();
	
	
}
