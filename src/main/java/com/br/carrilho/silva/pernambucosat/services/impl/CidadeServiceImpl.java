package com.br.carrilho.silva.pernambucosat.services.impl;

import com.br.carrilho.silva.pernambucosat.Exceptions.ExceptionConflict;
import com.br.carrilho.silva.pernambucosat.model.Cidade;
import com.br.carrilho.silva.pernambucosat.repository.CidadeRepository;
import com.br.carrilho.silva.pernambucosat.services.CidadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import java.util.Optional;


@Service
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    CidadeRepository cidadeRepository;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void apagarCidade(Long id) {
        cidadeRepository.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Cidade salvaCidade(Cidade cidade) {

        if (StringUtils.isEmpty(cidade.getNome())) {
            throw new ExceptionConflict("Nome da cidade é obrigatório.");
        }

        try {
            return cidadeRepository.save(cidade);
        } catch (Exception e)
        {
            throw new ExceptionConflict("cidade já existe.");
        }

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Cidade> recuperarCidade(Long cidade) {
        return cidadeRepository.findById(cidade);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Cidade> pesquisarCidade(String cidade) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Cidade> pesquisaTodasCidades(Pageable pageable) {
        return cidadeRepository.findAll(pageable);
    }
}
