package com.br.carrilho.silva.pernambucosat.services;

import java.util.List;
import com.br.carrilho.silva.pernambucosat.model.Estoque;

public interface EstoqueService {

	void persistirEstoque(Estoque id);
	void apagarEstoque(Estoque id);
	void atualizarEstoque(Estoque id);
	void salvaEstoque();
	Estoque recuperarEstoque(Estoque estoque);
    List<Estoque> pesquisarEstoque(Estoque estoque);
    List<Estoque> pesquisaTodasEstoque();
	
}
