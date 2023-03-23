package org.capgemini.proyecto1.service;

import java.util.List;

import org.capgemini.proyecto1.model.Juego;

import com.ejemplos.spring.model.User;

public interface JuegoService {
	
	public List<Juego> findAll();
	
	// Para Update & Add
	public void saveJuego(Juego juego);

}
