package com.br.carrilho.silva.pernambucosat.repository;

import java.util.List;

import com.br.carrilho.silva.pernambucosat.model.Fornecedor;

public interface FornecedorRepository {

	void persistirFornecedor(Fornecedor id);
	void apagarProduto(Fornecedor id);
	void atualizarFornecedor(Fornecedor id);
	void salvaFornecedor();
    Fornecedor recuperarFornecedor(Fornecedor id);
    List<Fornecedor> pesquisarFornecedor(Fornecedor nomeFornecedor);
    List<Fornecedor> pesquisaTodosFornecedores();
	
}
