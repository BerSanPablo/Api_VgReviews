package com.review.tfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.review.tfg.dto.videojuego.request.VideojuegoCreateDTO;
import com.review.tfg.dto.videojuego.response.VideojuegoResponse;
import com.review.tfg.service.VideojuegoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/videojuego")
@RequiredArgsConstructor
@CrossOrigin
public class VideojuegoController {

	@Autowired
	VideojuegoService videojuegoService;
	
	@PostMapping("")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<VideojuegoResponse> postVideojuego(@RequestBody @Valid VideojuegoCreateDTO videojuego) {
        return ResponseEntity.ok(videojuegoService.createVideojuego(videojuego));
    }
	
	@GetMapping("")
    public ResponseEntity<List<VideojuegoResponse>> getVideojuegos(@RequestParam(required = false) String nombre,
			  													   @RequestParam(required = false) String[] tag) {
        
        return ResponseEntity.ok(videojuegoService.getVideojuegos(nombre, tag));
    }
	
	@GetMapping("/{nombre}")
    public ResponseEntity<VideojuegoResponse> getVideojuegoByName(@PathVariable String nombre) {
        return ResponseEntity.ok(videojuegoService.getVideojuegoByName(nombre));
    }
}
