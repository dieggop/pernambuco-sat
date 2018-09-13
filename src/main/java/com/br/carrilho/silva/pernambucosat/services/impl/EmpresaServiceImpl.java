package com.br.carrilho.silva.pernambucosat.services.impl;


import com.br.carrilho.silva.pernambucosat.Exceptions.ExceptionConflict;
import com.br.carrilho.silva.pernambucosat.model.Empresa;
import com.br.carrilho.silva.pernambucosat.repository.EmpresaRepository;
import com.br.carrilho.silva.pernambucosat.services.EmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import java.util.Optional;


@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void apagarEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Empresa salvaEmpresa(Empresa empresa) {

        if (StringUtils.isEmpty(empresa.getNomeEmpresa())) {
            throw new ExceptionConflict("Nome da empresa é obrigatório.");
        }

        try {
            return empresaRepository.save(empresa);
        } catch (Exception e)
        {
            throw new ExceptionConflict("empresa já existe.");
        }

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Empresa> recuperarEmpresa(Long empresa) {
        return empresaRepository.findById(empresa);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Empresa> pesquisarEmpresa(String empresa) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Empresa> pesquisaTodasEmpresas(Pageable pageable) {
        return empresaRepository.findAll(pageable);
    }
}
