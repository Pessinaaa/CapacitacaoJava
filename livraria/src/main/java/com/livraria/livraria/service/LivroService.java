package com.livraria.livraria.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.livraria.entity.Livro;
import com.livraria.livraria.exception.LivroNaoEncontradoException;
import com.livraria.livraria.repository.LivroRepository;

@Service
public class LivroService {
	
	private LivroRepository livroRepository;
	
	@Autowired
	public LivroService(LivroRepository livroRepository) {
		super();
		this.livroRepository = livroRepository;
	}

	public Livro cadastrarLivro(Livro livro) {
		return this.livroRepository.save(livro);
	}
	
	public List<Livro> retornarTodosOsLivros() {
		return this.livroRepository.findAll();
	}
	
	public Livro retornarLivro(Long id) throws LivroNaoEncontradoException {
		if (this.livroRepository.existsById(id)) {
			return this.livroRepository.getReferenceById(id);
		}
		throw new LivroNaoEncontradoException(id);
	}
	
	public Livro alterarLivro(Long id, @Valid Livro livro) throws LivroNaoEncontradoException {
		if (this.livroRepository.existsById(id)) {
			Livro LivroASerAlterado = this.livroRepository.getReferenceById(id);
			livro.setId(id);
			if (livro.getTitulo() == null) {
				livro.setTitulo(LivroASerAlterado.getTitulo());
			}
			if (livro.getAno() == null) {
				livro.setAno(LivroASerAlterado.getAno());
			}
			return this.livroRepository.save(livro);
		}
		throw new LivroNaoEncontradoException(id);
	}
	
	public void deletarLivro(Long id) throws LivroNaoEncontradoException {
		if (this.livroRepository.existsById(id)) {
			this.livroRepository.deleteById(id);
		} else {
			throw new LivroNaoEncontradoException(id);
		}
	}
}
