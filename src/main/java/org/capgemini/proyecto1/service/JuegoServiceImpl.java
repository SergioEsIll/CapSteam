package org.capgemini.proyecto1.service;

import java.util.List;

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

}
