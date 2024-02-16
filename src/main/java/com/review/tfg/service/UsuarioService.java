package com.review.tfg.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.review.tfg.dto.usuario.response.UsuarioDTO;

public interface UsuarioService {
	UserDetailsService userDetailsService();
	List<UsuarioDTO> obtenerUsuarios();
}
