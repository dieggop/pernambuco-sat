package com.br.carrilho.silva.pernambucosat.repository;

import java.util.List;

import com.br.carrilho.silva.pernambucosat.model.ItemProduto;;

public interface ItemProdutoRepository {

	void persistirItemProduto(ItemProduto id);
	void apagarProduto(ItemProduto id);
	void atualizarItemProduto(ItemProduto id);
	void salvaItemProduto();
    ItemProduto recuperarItemProduto(ItemProduto id);
    List<ItemProduto> pesquisarItemProduto(ItemProduto nomeItemProduto);
    List<ItemProduto> pesquisaTodosItemProdutoes();
	
}
