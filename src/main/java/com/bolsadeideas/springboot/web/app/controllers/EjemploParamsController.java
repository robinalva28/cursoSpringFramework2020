package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping({"/index" , "/"})
	public String index(Model model) {
		
		model.addAttribute("titulo", "Enviar parametros del Request HTTP GET - URL");
		return "params/index";
	}
	
	@RequestMapping("/string")
	public String param(@RequestParam(name="texto", required=false, defaultValue = "Texto por defecto") String texto, Model model) {
		model.addAttribute("titulo", "Recibir parametros del Request HTTP GET - URL");
		model.addAttribute("resultado", "El texto de la peticion es : " + texto);
		return "params/ver";
	}
	
	@RequestMapping("/mix-params")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		int numero;
		try {
		numero = Integer.parseInt(request.getParameter("numero"));
		}catch(NumberFormatException e) {
			numero = 0;
		}
		
		model.addAttribute("titulo", "Enviar varios parametros del Request HTTP GET - URL");
		model.addAttribute("resultado", "El saludo es : '" + saludo + "' y el numero es '" + numero + "'");
		return "params/ver";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
