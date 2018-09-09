package com.br.carrilho.silva.pernambucosat.services;

import java.util.List;

import com.br.carrilho.silva.pernambucosat.model.Fornecedor;

public interface FornecedorService {

	void persistirFornecedor(Fornecedor id);
	void apagarProduto(Fornecedor id);
	void atualizarFornecedor(Fornecedor id);
	void salvaFornecedor();
    Fornecedor recuperarFornecedor(Fornecedor id);
    List<Fornecedor> pesquisarFornecedor(Fornecedor nomeFornecedor);
    List<Fornecedor> pesquisaTodosFornecedores();
	
}
