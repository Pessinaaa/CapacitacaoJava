package com.livraria.livraria.dto;

import com.livraria.livraria.entity.Livro;

public class LivroDTO {
	private String titulo;
	private Integer ano;
	
	public LivroDTO(String titulo, Integer ano) {
		this.titulo = titulo;
		this.ano = ano;
	}
	public LivroDTO() {
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public static LivroDTO retornaLivroDTO(Livro livro) {
		LivroDTO livroDTO = new LivroDTO(livro.getTitulo(), livro.getAno());
		return livroDTO;
	}
	
	public static Livro retornaLivro(LivroDTO livroDTO) {
		Livro livro = new Livro(livroDTO.getTitulo(), livroDTO.getAno());
		return livro;
	}
}
