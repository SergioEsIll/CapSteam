package org.capgemini.proyecto1;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.capgemini.proyecto1.service.JuegoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;



@WebMvcTest(CapSteamApplication.class)
class CapSteamApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;
	
	
    
	
	//test que comprueba si se imprime la vista y si esta todo correcto
	@Test
	void comprobarEstiloFormulario() throws Exception {
		mockMvc.perform(get("/css/formularioJuego.css"))
			   .andDo(print())
			   .andExpect(status().isOk());
			   
	}
	
	@Test
	void comprobarEstiloCSV() throws Exception {
		mockMvc.perform(get("/css/index.css"))
			   .andDo(print())
			   .andExpect(status().isOk());
			   
	}
	
	@Test
	void estiloListadojuego() throws Exception {
		mockMvc.perform(get("/css/listadoJuego.css"))
			   .andDo(print())
			   .andExpect(status().isOk());
			   
	}
	
	
	
	@MockBean
	private JuegoService juegoserv;
	
	@Test
	//Comprueba listado
	public void compruebaListado() throws Exception {
		mockMvc.perform(get("/"))
		.andDo(print())
		.andExpect(status().isOk());
		
	}
	/*
	@Test
	public void comprobarIndex() throws Exception {
		mockMvc.perform(get("/index"))
		.andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Test
	//Comprueba listado
	public void compruebaNuevoJuego() throws Exception {
		mockMvc.perform(get("/new"))
		.andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Test
	//Comprueba listado
	public void compruebaCarga() throws Exception {
		mockMvc.perform(post("/upload"))
		.andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Test
	//Comprueba listado
	public void compruebaNuevoJuego() throws Exception {
		mockMvc.perform(get("/new"))
		.andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Test
	//Comprueba listado
	public void compruebaGuardarJuego() throws Exception {
		mockMvc.perform(post("/save"))
		.andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Test
	//Comprueba listado
	public void compruebaEditar() throws Exception {
		mockMvc.perform(get("/edit"))
		.andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Test
	//Comprueba listado
	public void compruebaDelete() throws Exception {
		mockMvc.perform(get("/delete"))
		.andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Test
	//Comprueba listado
	public void comprobarBuscarPorPlataforma() throws Exception {
		mockMvc.perform(get("/findByPlatform"))
		.andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Test
	//Comprueba listado
	public void comprobarBuscarPorGenero() throws Exception {
		mockMvc.perform(get("/findByGenre"))
		.andDo(print())
		.andExpect(status().isOk());
		
	}
	*/
}
