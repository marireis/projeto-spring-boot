package br.com.cod3r.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {

	@GetMapping(path = {"/ola", "saudacao"})//protocolo de requisição do tipo GET
	public String ola() {
		return "Olá Spring Boot!";
	}
	

}
