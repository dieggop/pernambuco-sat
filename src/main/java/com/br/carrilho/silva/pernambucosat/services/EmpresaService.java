package com.br.carrilho.silva.pernambucosat.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.br.carrilho.silva.pernambucosat.model.Empresa;

public interface EmpresaService {

	void apagarEmpresa(Long id);
	Empresa salvaEmpresa(Empresa empresa);
	Optional<Empresa> recuperarEmpresa(Long empresa);
    Page<Empresa> pesquisarEmpresa(String empresa);
    Page<Empresa> pesquisaTodasEmpresas(Pageable pageable);
}
