package com.irondif;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorInicio {
	
	@Value("${index.saludo}")
	private String saludo;

	@GetMapping("/")
	public String inicio(Model model) {
		String mensaje = "Mensaje con Thymeleaf";
		Persona persona = new Persona();
		persona.setNombre("Daniel");
		persona.setApellido("Espanadero");
		persona.setEmail("d.espanadero@gmail.com");
		persona.setTelefono("633282171");
		
//		log.info("ejecutando el controlador rest");
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("saludo", saludo);
		model.addAttribute("persona", persona);
		return "index";
	}
}
