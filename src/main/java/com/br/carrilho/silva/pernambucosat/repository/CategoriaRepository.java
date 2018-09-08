package com.br.carrilho.silva.pernambucosat.repository;

import java.util.List;

import com.br.carrilho.silva.pernambucosat.model.Categoria;

public interface CategoriaRepository {

	void persistirCategoria(Categoria id);
	void apagarProduto(Categoria id);
	void atualizarCategoria(Categoria id);
	void salvaCategoria();
    Categoria recuperarCategoria(Categoria categoria);
    List<Categoria> pesquisarCategoria(Categoria id);
    List<Categoria> pesquisaTodassCategorias();
    
}
