package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;
// setxkbmap -layout us

//ruta del controlador
@Controller
//agregar ruta de primer nivel del controlador
@RequestMapping("/app")
public class IndexController {
 
	@GetMapping({"index" , "/" , "" , "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Bienvenido a Spring");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		//se crea una instancia del modelo Usuario
		Usuario usuario = new Usuario();
		usuario.setNombre("Robinson");
		usuario.setApellido("Alvarez");
		//usuario.setEmail("email@correo.com");
		model.addAttribute("titulo", "Perfil del usuario: " .concat(usuario.getNombre()));
		model.addAttribute("usuario", usuario);
		//se llama a la vista perfil
		return "perfil";
	}
	
	@GetMapping({"listar"})
	public String listar(Model model) {
		model.addAttribute("titulo", "Lista de usuarios");
		return "index";
	}
	
	
	
	
	
	
	
}
