package br.mic.ggmb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.mic.ggmb.model.Livro;

@Service
public interface LivroService
{
	List<Livro> getAllLivros();

	Livro salvarLivro(Livro livro);

	Livro getLivroById(Integer id);

	Livro atualizarLivro(Livro livro);

	void excluirLivroById(Integer id);
}
