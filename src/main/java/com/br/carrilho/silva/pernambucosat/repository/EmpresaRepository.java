package com.br.carrilho.silva.pernambucosat.repository;

import java.util.List;

import com.br.carrilho.silva.pernambucosat.model.Empresa;

public interface EmpresaRepository {

	void persistirEmpresa(Empresa id);
	void apagarProduto(Empresa id);
	void atualizarEmpresa(Empresa id);
	void salvaEmpresa();
    Empresa recuperarEmpresa(Empresa empresa);
    List<Empresa> pesquisarEmpresa(Empresa empresa);
    List<Empresa> pesquisaTodasEmpresas();
}
