package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

	@GetMapping({"/index","/",""})
	public String variables(Model model) {
		
		return "/variables/index";
	}
	
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("titulo", "recibir parametros de la ruta (@PathVariable) ");
		model.addAttribute("resultado", "El texto de la variable es : "+ texto);

		return "/variables/ver";
	}
	//PASAR VARIOS PARAMETROS CON @PathVariable
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto, @PathVariable int numero, Model model) {
		
		model.addAttribute("titulo", "recibir varios parametros por path variable");
		model.addAttribute("resultado", "el resultado recibido por @path variable");
		
		return "/variables/ver";
	}
}
