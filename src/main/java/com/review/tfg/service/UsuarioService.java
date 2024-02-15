package com.review.tfg.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.review.tfg.dto.auth.response.TokenDTO;
import com.review.tfg.entity.Usuario;

public interface UsuarioService {
	UserDetailsService userDetailsService();
}
