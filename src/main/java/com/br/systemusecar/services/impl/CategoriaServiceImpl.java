package com.br.systemusecar.services.impl;

import com.br.systemusecar.Exceptions.ExceptionConflict;
import com.br.systemusecar.model.Categoria;
import com.br.systemusecar.repository.CategoriaRepository;
import com.br.systemusecar.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void apagarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Categoria salvaCategoria(Categoria categoria) {

        if (StringUtils.isEmpty(categoria.getNome())) {
            throw new ExceptionConflict("Nome da categoria é obrigatório.");
        }

        try {
            return categoriaRepository.save(categoria);
        } catch (Exception e)
        {
            throw new ExceptionConflict("Categoria já existe.");
        }

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Categoria> recuperarCategoria(Long categoria) {
        return categoriaRepository.findById(categoria);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Categoria> pesquisarCategoria(String termo) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Categoria> pesquisaTodasCategorias(Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }
}
