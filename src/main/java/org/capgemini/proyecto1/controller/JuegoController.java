package org.capgemini.proyecto1.controller;

import org.capgemini.proyecto1.helper.CSVHelper;
import org.capgemini.proyecto1.message.ResponseMessage;
import org.capgemini.proyecto1.model.Juego;
import org.capgemini.proyecto1.service.CSVService;
import org.capgemini.proyecto1.service.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class JuegoController {

	@Autowired
	JuegoService juegoService;
	
	@Autowired
	CSVService fileService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (CSVHelper.hasCSVFormat(file)) {
			try {
				fileService.save(file);

				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}

		message = "Please upload a csv file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}
	
	@GetMapping("/index")
	public String addCsv() {
		return "index.html";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String listJuego(Model model) {
		model.addAttribute("listadoJuego", juegoService.findAll());
		model.addAttribute("listadoGenero", juegoService.findAllGenres());
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
	
	@GetMapping("/findByPlatform")
	public String listJuegoFilteredByPlatform(@RequestParam("platform") String platform, Model m) {
		m.addAttribute("listadoJuego", juegoService.findByPlatform(platform));
		return "listadoJuego.html";
	}

	@GetMapping("/findByGenre")
	public String listJuegoFilteredByGenre(@RequestParam("genre") String genre, Model m) {
		m.addAttribute("listadoJuego", juegoService.findByGenre(genre));
		return "listadoJuego.html";
	}

}
