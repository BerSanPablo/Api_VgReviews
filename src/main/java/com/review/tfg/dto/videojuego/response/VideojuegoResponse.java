package com.review.tfg.dto.videojuego.response;

import java.util.Date;
import java.util.Set;

import com.review.tfg.entity.Tag;
import com.review.tfg.entity.Videojuego;

public class VideojuegoResponse {

	private String nombre;
	private Date fechaCreacion;
	private byte[] imagenPortada;
	private String sinopsis;
	private Set<Tag> tags;
	
	public VideojuegoResponse(Videojuego videojuego) {
		this.nombre = videojuego.getNombre();
		this.fechaCreacion = videojuego.getFechaCreacion();
		this.imagenPortada = videojuego.getImagenPortada();
		this.sinopsis = videojuego.getSinopsis();
		this.tags = videojuego.getTags();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public byte[] getImagenPortada() {
		return imagenPortada;
	}

	public void setImagenPortada(byte[] imagenPortada) {
		this.imagenPortada = imagenPortada;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
}
