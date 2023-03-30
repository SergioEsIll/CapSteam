package org.capgemini.proyecto1.service;

import java.util.List;
import java.util.Optional;

import org.capgemini.proyecto1.model.Juego;

public interface JuegoService {

	public List<Juego> findAll();

	// Para Update & Add
	public void saveJuego(Juego juego);

	/**
	 * 
	 * @param id
	 */
	public void deleteById(int id);

	/**
	 * Buscar juego por id
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Juego> findById(int id);

	/**
	 * 
	 * @param platform
	 * @return
	 */
	public List<Juego> findByPlatform(String platform);

	/**
	 * 
	 * @param genre
	 * @return
	 */
	public List<Juego> findByGenre(String genre);

	/**
	 * 
	 * @return
	 */
	public String[] findAllPlatforms();
	
	/**
	 * 
	 * @return
	 */
	public String[] findAllGenres();

}
