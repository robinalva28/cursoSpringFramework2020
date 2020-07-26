package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.stereotype.Component;

@Component("MiServicioSimple")
public class MiServicio implements IServicio{
	
	@Override
	public String operacion() {
		return "Ejecutando un proceso importante";
	}
	
}
