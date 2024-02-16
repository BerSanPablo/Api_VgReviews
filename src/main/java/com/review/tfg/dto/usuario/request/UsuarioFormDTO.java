package com.review.tfg.dto.usuario.request;

import com.review.tfg.dto.usuario.response.UsuarioDTO;

import jakarta.validation.constraints.NotBlank;

public class UsuarioFormDTO extends UsuarioDTO {
	
	@NotBlank(message = "El email no se puede dejar vacío")
	private String email;
	private String telefono;
	
	public UsuarioFormDTO() {}
	
	public UsuarioFormDTO(byte[] imagenPerfil, String nick, String email, String telefono) {
		super(imagenPerfil, nick);
		this.telefono = telefono;
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
