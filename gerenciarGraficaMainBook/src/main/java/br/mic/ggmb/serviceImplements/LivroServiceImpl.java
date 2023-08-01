package br.mic.ggmb.serviceImplements;

import java.util.List;

import org.springframework.stereotype.Service;

import br.mic.ggmb.model.Livro;
import br.mic.ggmb.repository.LivroRepository;
import br.mic.ggmb.service.LivroService;

@Service
public class LivroServiceImpl implements LivroService
{

	private LivroRepository livroRepository;

	public LivroServiceImpl(LivroRepository livroRepository)
	{
		super();
		this.livroRepository = livroRepository;
	}

	@Override
	public List<Livro> getAllLivros()
	{
		return livroRepository.findAll();
	}

	@Override
	public Livro salvarLivro(Livro livro)
	{
		return livroRepository.save(livro);
	}

	@Override
	public Livro getLivroById(Integer id)
	{
		return livroRepository.findById(id).get();
	}

	@Override
	public Livro atualizarLivro(Livro livro)
	{
		return livroRepository.save(livro);
	}

	@Override
	public void excluirLivroById(Integer id)
	{
		livroRepository.deleteById(id);
	}
}
