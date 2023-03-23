package org.capgemini.proyecto1.service;

import java.io.IOException;
import java.util.List;

import org.capgemini.proyecto1.helper.CSVHelper;
import org.capgemini.proyecto1.model.Juego;
import org.capgemini.proyecto1.repository.JuegoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CSVService {

	@Autowired
	JuegoDao juegoRepository;

	public void save(MultipartFile file) {
		try {
			List<Juego> juegos = CSVHelper.csvToJuegos(file.getInputStream());
			juegoRepository.saveAll(juegos);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}

}
