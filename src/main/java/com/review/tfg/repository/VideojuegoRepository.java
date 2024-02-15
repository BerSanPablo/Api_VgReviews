package com.review.tfg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.review.tfg.entity.Videojuego;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
	public Videojuego findByNombre(String nombre);
}

