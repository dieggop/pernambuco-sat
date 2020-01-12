package com.br.systemusecar.services;

import com.br.systemusecar.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UsuarioService {

		
	Page<Usuario> pesquisaTodasUsuarios(Pageable pageable);
	Usuario salvaUsuario(Usuario usuario);
	Optional<Usuario> recuperarUsuario(Long Usuario);
	void apagarUsuario(Long id);
	
	
    
}
