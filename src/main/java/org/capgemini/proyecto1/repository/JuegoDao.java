package org.capgemini.proyecto1.repository;

import java.util.List;

import org.capgemini.proyecto1.model.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoDao extends JpaRepository<Juego, Integer>{

	public List<Juego> findByPlatform(String platform);

	public List<Juego> findByGenre(String genre);
	
	@Query("SELECT DISTINCT j.platform FROM Juego j")
	public String[] findAllPlatforms();
	
}
