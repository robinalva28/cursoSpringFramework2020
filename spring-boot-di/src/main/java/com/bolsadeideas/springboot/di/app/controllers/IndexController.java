package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;

@Controller
public class IndexController {
	
	//GENERO UNA ISNTANCIA DEL SERVICE PARA LUEGO ENVIAR EL METDO OPERACION A LA VISTA <<-eliminado
	//con autowired aplico la llamada desde la inyeccion al metodo que usa la instancia
	@Autowired()
	private IServicio servicio;
	
	
	@GetMapping({"index","","/"})
	public String index(Model model) {
		
		model.addAttribute("objeto", servicio.operacion());
		return "index";
	}

}
