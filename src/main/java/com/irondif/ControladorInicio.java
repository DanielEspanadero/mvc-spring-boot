package com.irondif;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		
		Persona persona2 = new Persona();
		persona2.setNombre("Karla");
		persona2.setApellido("Perez");
		persona2.setEmail("karla@gmail.com");
		persona2.setTelefono("633282183");
		
//		ArrayList<Persona> personas = new ArrayList<Persona>();
//		personas.add(persona);
//		personas.add(persona2);

		List<Persona> personas = Arrays.asList(persona, persona2);
//		List<Persona> personas = Arrays.asList();
		
//		log.info("ejecutando el controlador rest");
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("saludo", saludo);
		//model.addAttribute("persona", persona);
		model.addAttribute("personas", personas);
		return "index";
	}
}
