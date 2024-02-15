package com.review.tfg.dto.usuario.response;

import com.review.tfg.entity.Usuario;

public class UsuarioDTO {
	
	private byte[] imagenPerfil;
	private String nick;
	
	public UsuarioDTO() {}
	
	public UsuarioDTO(Usuario usuario) {
		this.imagenPerfil = usuario.getImagenPerfil();
		this.nick = usuario.getNick();
	}

	public UsuarioDTO(byte[] imagenPerfil, String nick) {
		this.imagenPerfil = imagenPerfil;
		this.nick = nick;
	}

	public byte[] getImagenPerfil() {
		return imagenPerfil;
	}

	public void setImagenPerfil(byte[] imagenPerfil) {
		this.imagenPerfil = imagenPerfil;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
}
