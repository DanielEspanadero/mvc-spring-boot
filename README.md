# ♻️👨🏻‍💻 MVC CON SPRING BOOT | HOLA MUNDO CON THYMELEAF

_Configurar un archivo MVC usando thymeleaf._

## 📂 APLICATION.PROPERTIES
```
server.port=8080
spring.main.banner-mode=off 
spring.thymeleaf.cache=false
index.saludo=Saludos desde application.properties
```

## 📂 CLASE PERSONA
```
package com.irondif;

public class Persona {
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
```

## 📂 CLASE CONTROLADOR INICIO
```
package com.irondif;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
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
		
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("saludo", saludo);
		model.addAttribute("persona", persona);
		return "index";
	}
}
```

## 📂 INDEX.HTML
_El archivo index.html tiene que ir dentro de la carpeta src/main/resources → templates_
```
<!DOCTYPE html>
<html xmlns:th="http://thymeleaf.org">
<head>
	<meta charset="UTF-8" />
	<title>Pagina web de prueba</title>
</head>
<body>
	<h1>Inicio</h1>
	<p th:text="${mensaje}"></p>
	<p th:text="${saludo}"></p>
	<br/>
	Nombre: <span th:text="${persona.nombre}">Mostrar Nombre</span>
	<br/>
	Apellido: <span th:text="${persona.apellido}">Mostrar Apellido</span>
	<br/>
	Email: <span th:text="${persona.email}">Mostrar Email</span>
	<br/>
	Telefono: <span th:text="${persona.telefono}">Mostrar Telefono</span>
</body>
</html>
```