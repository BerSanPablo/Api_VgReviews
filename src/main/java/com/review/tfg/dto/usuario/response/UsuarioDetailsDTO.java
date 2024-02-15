package com.review.tfg.dto.usuario.response;

import java.util.Date;

import com.review.tfg.dto.usuario.request.UsuarioFormDTO;

public class UsuarioDetailsDTO extends UsuarioFormDTO {

	private Date fechaCreacion;
	
	public UsuarioDetailsDTO() {}

	public UsuarioDetailsDTO(byte[] imagenPerfil, String nick, String email, String telefono, Date fechaCreacion) {
		super(imagenPerfil, nick, email, telefono);
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}
