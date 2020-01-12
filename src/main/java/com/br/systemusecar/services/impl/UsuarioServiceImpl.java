package com.br.systemusecar.services.impl;

import com.br.systemusecar.Exceptions.ExceptionConflict;
import com.br.systemusecar.model.Usuario;
import com.br.systemusecar.repository.UserRepository;
import com.br.systemusecar.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import java.util.Optional;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UserRepository usuarioRepository;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void apagarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Usuario salvaUsuario(Usuario Usuario) {

        if (StringUtils.isEmpty(Usuario.getFirstName())) {
            throw new ExceptionConflict("Nome da Usuario é obrigatório.");
        }

        try {
            return usuarioRepository.save(Usuario);
        } catch (Exception e)
        {
            throw new ExceptionConflict("Usuario já existe.");
        }

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> recuperarUsuario(Long Usuario) {
        return usuarioRepository.findById(Usuario);
    }

    @Transactional(readOnly = true)
    public Page<Usuario> pesquisarUsuario(Long id) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Usuario> pesquisaTodasUsuarios(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }
}
