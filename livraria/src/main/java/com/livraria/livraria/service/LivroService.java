package com.livraria.livraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.livraria.entity.Livro;
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
}
