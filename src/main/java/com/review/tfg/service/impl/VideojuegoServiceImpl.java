package com.review.tfg.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.tfg.dto.videojuego.request.VideojuegoCreateDTO;
import com.review.tfg.dto.videojuego.response.VideojuegoResponse;
import com.review.tfg.entity.Tag;
import com.review.tfg.entity.Videojuego;
import com.review.tfg.repository.TagRepository;
import com.review.tfg.repository.VideojuegoRepository;
import com.review.tfg.service.VideojuegoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideojuegoServiceImpl implements VideojuegoService{
	
	@Autowired
	VideojuegoRepository videojuegoRepository;
	
	@Autowired
	TagRepository tagRepository;

	@Override
	public VideojuegoResponse createVideojuego(VideojuegoCreateDTO videojuego) {
		Videojuego entidadInsertar = new Videojuego(videojuego);
		
		videojuego.getTags().forEach(tag -> {
			Tag tagEncontrado = tagRepository.findByNombre(tag);
			entidadInsertar.getTags().add(tagEncontrado);
		});
		
		Videojuego guardado = videojuegoRepository.save(entidadInsertar);
		
		return new VideojuegoResponse(guardado);
	}

	@Override
	public List<VideojuegoResponse> getVideojuegos() {
		return videojuegoRepository.findAll()
									.stream()
									.map(VideojuegoResponse::new)
									.collect(Collectors.toList());
	}

}
