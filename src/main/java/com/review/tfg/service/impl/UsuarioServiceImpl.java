package com.review.tfg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.review.tfg.dto.auth.response.TokenDTO;
import com.review.tfg.entity.Usuario;
import com.review.tfg.repository.UsuarioRepository;
import com.review.tfg.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioRepository repo;

	@Override
	public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
            	Usuario user = repo.findByEmail(username);
            	if (user == null) {
            		//TODO Lanzar excepcion
            	}
                return user;
            }
        };
    }

}
