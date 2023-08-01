package br.mic.ggmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mic.ggmb.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>
{

}
