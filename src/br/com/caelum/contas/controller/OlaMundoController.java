package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {

	
	@RequestMapping("/olamundo")
	public String ola() {
		System.out.println("Ola mundo");
		
		return "ola";
	}
}
