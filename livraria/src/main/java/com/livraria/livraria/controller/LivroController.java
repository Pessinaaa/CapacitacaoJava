package com.livraria.livraria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.livraria.dto.LivroDTO;
import com.livraria.livraria.entity.Livro;
import com.livraria.livraria.exception.LivroNaoEncontradoException;
import com.livraria.livraria.service.LivroService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/livraria/livros")
public class LivroController {
	
	private LivroService livroService;
	
	@Autowired
	public LivroController(LivroService livroService) {
		super();
		this.livroService = livroService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro cadastraLivro(@Valid @RequestBody Livro livro) {
		Livro livroSalvo = this.livroService.cadastrarLivro(livro);
		return livroSalvo;
	}
	
	@GetMapping
	public List<Livro> retornarTodosOsLivros() {
		List<Livro> retorno = this.livroService.retornarTodosOsLivros();
		return retorno;
	}
	
	@GetMapping("/{id}")
	public Livro retornarLivro(@PathVariable Long id) throws LivroNaoEncontradoException {
		Livro livroRetorno = this.livroService.retornarLivro(id);
		return livroRetorno;
	}
	
	@PutMapping("/{id}")
	public LivroDTO alterarLivro(@PathVariable Long id, @Valid @RequestBody LivroDTO livro) throws LivroNaoEncontradoException {
		Livro livroRequest = LivroDTO.retornaLivro(livro);
		Livro livroAlterado = this.livroService.alterarLivro(id, livroRequest);
		return LivroDTO.retornaLivroDTO(livroAlterado);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarLivro(@PathVariable Long id) throws LivroNaoEncontradoException {
		this.livroService.deletarLivro(id);
	}
	
	@GetMapping("/teste")
	public String teste() {
		return "TESTE";
	}
}
