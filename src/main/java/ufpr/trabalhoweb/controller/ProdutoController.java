package ufpr.trabalhoweb.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ufpr.trabalhoweb.model.Cliente;
import ufpr.trabalhoweb.model.Produto;
import ufpr.trabalhoweb.repository.Produtos;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	Produtos produtos;
	
	@RequestMapping
	public ModelAndView novo() {
		List<Produto> todosProdutos = produtos.findAll();
		ModelAndView mv = new ModelAndView("CadastroProduto");
		mv.addObject("produtos", todosProdutos);
		mv.addObject(new Produto());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Produto produto, Errors errors, RedirectAttributes attributes) {

		ModelAndView mv = new ModelAndView("CadastroProduto");
		List<Produto> todosProdutos = produtos.findAll();
		mv.addObject("produtos", todosProdutos);

		if (errors.hasErrors()) {
			return "CadastroProduto";
		}

		produtos.save(produto);
		mv.addObject("mensagem", "Produto salvo com sucesso!");
		attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");
		todosProdutos = produtos.findAll();
		mv.addObject("produtos", todosProdutos);
		attributes.addFlashAttribute("produtos", todosProdutos);
		return "redirect:/produtos";
	}

	@RequestMapping("{id}")
	public ModelAndView edicao(@PathVariable("id") Produto produto) {
		List<Produto> todosProdutos = produtos.findAll();

		ModelAndView mv = new ModelAndView("CadastroProduto");
		mv.addObject("produtos", todosProdutos);
		mv.addObject("produto", produto);

		return mv;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable int id, RedirectAttributes attributes) {
		produtos.deleteById(id);

		attributes.addFlashAttribute("mensagem", "Produto excluído com sucesso!");
		return "redirect:/produtos";
	}
}
