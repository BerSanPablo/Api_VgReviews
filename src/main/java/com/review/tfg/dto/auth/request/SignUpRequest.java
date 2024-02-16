package com.review.tfg.dto.auth.request;

import com.review.tfg.dto.usuario.request.UsuarioFormDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignUpRequest extends UsuarioFormDTO {

	@NotBlank(message = "La contraseña no se puede dejar en blanco")
	@Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
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
