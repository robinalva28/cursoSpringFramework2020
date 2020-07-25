package com.bolsadeideas.springboot.web.app.controllers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

//ruta del controlador
@Controller
//agregar ruta de primer nivel del controlador
@RequestMapping("/app")
public class IndexController {
 
	//INYECTAR TEXTO DESDE application.properties CON @VALUE
	@Value("${controllers.indexcontroller.tituloindex}")
	private String tituloIndex;
	
	@Value("${controllers.indexcontroller.tituloperfil}")
	private String tituloPerfil;
	
	@Value("${controllers.indexcontroller.titulolistar}")
	private String tituloListar;
	
	
	@GetMapping({"index" , "/" , "" })
	public String index(Model model) {
		model.addAttribute("titulo", tituloIndex);
		return "index";
	}
	
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		//se crea una instancia del modelo Usuario
		Usuario usuario = new Usuario();
		usuario.setNombre("Robinson");
		usuario.setApellido("Alvarez");
		
		model.addAttribute("titulo", tituloPerfil .concat(usuario.getNombre()));
		model.addAttribute("usuario", usuario);
		//se llama a la vista perfil
		return "perfil";
	}
	
	
	@RequestMapping({"/listar"})
	public String listar(Model model) {
		
		
		model.addAttribute("titulo", tituloListar);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		//se crea una lista para mostrar en la vista
				List<Usuario> usuarios = Arrays.asList(new Usuario("Robinson","Alvarez","correo@gmail.com"),
								new Usuario("Pedro","Perez","pedro@gmail.com"),
								new Usuario("Maria","Acacantara","maria@gmail.com"),
								new Usuario("Marcos","Alberca","marcos@gmail.com"));
				
				return usuarios;
	}
	
	
}
