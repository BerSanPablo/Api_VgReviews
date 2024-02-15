package com.review.tfg.dto.auth.request;

import com.review.tfg.dto.usuario.request.UsuarioFormDTO;

public class SignUpRequest extends UsuarioFormDTO {

	private String password;

	public SignUpRequest() {}

	public SignUpRequest(String password, byte[] imagenPerfil, String nick, String email, String telefono) {
		super(imagenPerfil, nick, email, telefono);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
