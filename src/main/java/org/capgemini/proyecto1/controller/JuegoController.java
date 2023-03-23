package org.capgemini.proyecto1.controller;

import org.capgemini.proyecto1.model.Juego;
import org.capgemini.proyecto1.service.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	// Nuevo Juego
	@GetMapping("/new")
	public String newJuego(Juego juego, Model m) {
		m.addAttribute("juego", juego);
		return "formularioJuego";
	}

	// Guardar Juego
	@PostMapping("/save")
	public String saveJuego(Juego juego) {
		juegoService.saveJuego(juego);
		return ("redirect:/");
	}
	
	// Editar Juego
	@GetMapping("/edit")
	public String editJuego(@RequestParam("id") int id, Model m) {
		try {
			m.addAttribute("juego", juegoService.findById(id));
			return "formularioJuego";
		} catch (Exception e) {
			System.out.print("El juego no existe");
			return ("redirect:/");
		}
		
	}

	// Borrar Juego
	@GetMapping("/delete")
	public String deleteJuego(@RequestParam("id") int id) {
		try {
			juegoService.deleteById(id);
		} catch (Exception e) {
			System.out.print("El juego no existe");
		}

		return ("redirect:/");
	}

}
