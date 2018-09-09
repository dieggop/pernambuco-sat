package com.br.carrilho.silva.pernambucosat.services;

import java.util.List;

import com.br.carrilho.silva.pernambucosat.model.Empresa;

public interface EmpresaService {

	void persistirEmpresa(Empresa id);
	void apagarProduto(Empresa id);
	void atualizarEmpresa(Empresa id);
	void salvaEmpresa();
    Empresa recuperarEmpresa(Empresa empresa);
    List<Empresa> pesquisarEmpresa(Empresa empresa);
    List<Empresa> pesquisaTodasEmpresas();
}
