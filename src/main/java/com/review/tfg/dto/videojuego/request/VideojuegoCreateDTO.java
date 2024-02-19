package com.review.tfg.dto.videojuego.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class VideojuegoCreateDTO {
	
	@NotBlank(message = "El nombre no puede ser nulo")
	private String nombre;
	
	@NotNull(message = "La fecha de creacion no puede ser nula")
	private Date fechaCreacion;
	
	@Size(max = 16000000, message = "La imagen de portada es demasiado grande")
	private byte[] imagenPortada;
	
	@NotBlank(message = "La sinopsis no puede ser nula")
	@Size(max = 5000, message = "La sinópsis es demasiado larga, se permiten hasta 5000 caracteres")
	private String sinopsis;

	public VideojuegoCreateDTO(String nombre, Date fechaCreacion, byte[] imagenPortada, String sinopsis) {
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.imagenPortada = imagenPortada;
		this.sinopsis = sinopsis;
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
}
