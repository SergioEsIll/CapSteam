package org.capgemini.proyecto1.controller;

import org.capgemini.proyecto1.model.Juego;
import org.capgemini.proyecto1.service.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JuegoController {
	
	@Autowired
	JuegoService juegoService;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String listJuego(Model model) {
		model.addAttribute("listadoJuego", juegoService.findAll());
		return "listadoJuego.html";
	}
	
	//Nuevo Juego
	@GetMapping("/new")
	public String newJuego(Juego juego, Model m) {
		m.addAttribute("juego",juego);
		return "formularioJuego";
	}

}
