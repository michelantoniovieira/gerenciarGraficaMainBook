package br.mic.ggmb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.mic.ggmb.model.Livro;
import br.mic.ggmb.service.LivroService;

@Controller
public class LivroController
{
	private LivroService livroService;

	public LivroController(LivroService livroService)
	{
		super();
		this.livroService = livroService;
	}

	@GetMapping("/livros")
	public String listarLivros(Model model)
	{
		model.addAttribute("livros", livroService.getAllLivros());
		return "livros.html";
	}

	@GetMapping("/livros/cadastro")
	public String cadastrarLivroViaForm(Model model)
	{
		Livro livro = new Livro();
		model.addAttribute("livro", livro);
		return "cadastrarLivro.html";
	}

	@PostMapping("/livros")
	public String salvarLivro(@ModelAttribute("livro") Livro livro)
	{
		livroService.salvarLivro(livro);
		return "redirect:/livros";
	}

	@GetMapping("/livros/editar/{id}")
	public String editarLivroViaForm(@PathVariable Integer id, Model model)
	{
		model.addAttribute("livro", livroService.getLivroById(id));
		return "atualizarLivro.html";
	}

	@PostMapping("/livros/{id}")
	public String atualizarLivro(@PathVariable Integer id, @ModelAttribute("livro") Livro livro, Model model)
	{
		Livro existenciaDoLivro = livroService.getLivroById(id);
		existenciaDoLivro.setId(livro.getId());
		existenciaDoLivro.setTitulo(livro.getTitulo());
		existenciaDoLivro.setAutor(livro.getAutor());
		existenciaDoLivro.setIsbn(livro.getIsbn());
		existenciaDoLivro.setEditora(livro.getEditora());
		livroService.atualizarLivro(existenciaDoLivro);

		return "redirect:/livros";
	}

	@GetMapping("/livros/excluir/{id}")
	public String excluirLivroViaForm(@PathVariable Integer id)
	{
		livroService.excluirLivroById(id);
		return "redirect:/livros";
	}

}
