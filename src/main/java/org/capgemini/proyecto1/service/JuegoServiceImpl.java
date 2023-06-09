package org.capgemini.proyecto1.service;

import java.util.List;
import java.util.Optional;

import org.capgemini.proyecto1.model.Juego;
import org.capgemini.proyecto1.repository.JuegoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JuegoServiceImpl implements JuegoService {
	
	@Autowired
	JuegoDao juegoDao;

	/**
	 * Buscar todos los juegos
	 */
	@Override
	public List<Juego> findAll() {
		return juegoDao.findAll();
	}

	@Override
	public void saveJuego(Juego juego) {
		juegoDao.save(juego);
	}

	@Override
	public void deleteById(int id) {
		juegoDao.deleteById(id);
	}

	@Override
	public Optional<Juego> findById(int id) {
		return juegoDao.findById(id);
	}
	
	@Override
	public List<Juego> findByPlatform(String platform) {
		return juegoDao.findByPlatform(platform);
	}

	@Override
	public List<Juego> findByGenre(String genre) {
		return juegoDao.findByGenre(genre);
	}

	@Override
	public String[] findAllPlatforms() {
		return juegoDao.findAllPlatforms();
	}

	@Override
	public String[] findAllGenres() {
		return juegoDao.findAllGenres();
	}

}
