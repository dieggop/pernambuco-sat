package com.br.systemusecar.services;

import java.util.List;

import com.br.systemusecar.model.Entrada;

public interface EntradaService {
	
	void persistirEntrada(Entrada id);
	void apagarEntrada(Entrada id);
	void atualizarEntrada(Entrada id);
	void salvaEntrada();
	Entrada recuperarEntrada(Entrada entrada);
    List<Entrada> pesquisarEntrada(Entrada entrada);
    List<Entrada> pesquisaTodasEntrada();
}
