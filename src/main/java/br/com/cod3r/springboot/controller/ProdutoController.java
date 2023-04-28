package br.com.cod3r.springboot.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.springboot.model.entity.Produto;
import br.com.cod3r.springboot.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping
	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
		
		produtoRepository.save(produto);
		return produto;
	}
	
	@GetMapping
	public Iterable<Produto> obterProdutos() {
	
		return produtoRepository.findAll();//retorna um interável de produto
	}
	
	@GetMapping(path="/{id}")
	public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}
	
	@PutMapping
	public Produto alterarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	//juntando o método PUT E POST
	/*
	 * @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	 * public @ResponseBody Produto salvarProduto(@Valid Produto produto ){
	 * 	produtoRepository.save(produto);
	 * 	return produto;
	 *  */
	
	@DeleteMapping("/{id}")
	public void excluirProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);
	}
	
	@GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
	public Iterable<Produto> obterProdutoPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdePagina){
		Pageable page = PageRequest.of(numeroPagina,qtdePagina);
		return produtoRepository.findAll(page);
		
	}
	
	@GetMapping(path="/nome/{parteNome}")
	public Iterable<Produto> obterProdutoPorNome(@PathVariable String parteNome) {
		return produtoRepository.findByNomeContaining(parteNome);
	}
}
