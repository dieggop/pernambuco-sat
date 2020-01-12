package com.br.systemusecar.security.service;

import com.br.systemusecar.model.Regras;
import com.br.systemusecar.model.Usuario;
import com.br.systemusecar.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustomUserDetailsService  implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        Usuario usuario = Optional.ofNullable(userRepository.findByUsername(username))
        		.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado");
        		
        List<GrantedAuthority> authorityListsUer = null;

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Regras role : usuario.getRegras()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRegra()));
            System.out.println(role.getRegra());
        }

        return new User(usuario.getUsername(), usuario.getPassword(), grantedAuthorities);

    }
}
