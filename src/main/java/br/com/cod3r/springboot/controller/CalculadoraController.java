package br.com.cod3r.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	//path variable insere na url http://localhost:8083/calculadora/somar/2/3
	@GetMapping("/somar/{a}/{b}")
	public int somar(@PathVariable int a, @PathVariable int b) {
		
		return a + b;
	}
	

	//request param insere direto o valor de a e b http://localhost:8083/calculadora/subtrair?b=100&a=30
	@GetMapping("/subtrair")
	public int subtrair(@RequestParam(name = "a") int a, @RequestParam(name = "b") int b) {
		
		return a - b;
	}
	
}
