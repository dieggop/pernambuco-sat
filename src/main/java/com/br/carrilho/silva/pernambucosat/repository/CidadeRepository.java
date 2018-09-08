package com.br.carrilho.silva.pernambucosat.repository;

import java.util.List;

import com.br.carrilho.silva.pernambucosat.model.Cidade;

public interface CidadeRepository {

	void persistirCidade(Cidade ciadde);
	void apagarProduto(Cidade ciadde);
	void atualizarCidade(Cidade ciadde);
	void salvaCidade();
    Cidade recuperarCidade(Cidade ciadde);
    List<Cidade> pesquisarCidade(Cidade ciadde);
    List<Cidade> pesquisaTodasCidades();
	
	
}
