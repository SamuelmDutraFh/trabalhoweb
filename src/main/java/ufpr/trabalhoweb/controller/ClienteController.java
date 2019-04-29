package ufpr.trabalhoweb.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
import ufpr.trabalhoweb.repository.Clientes;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	Clientes clientes;

	@RequestMapping
	public ModelAndView novo() {
		List<Cliente> todosClientes = clientes.findAll();
		ModelAndView mv = new ModelAndView("CadastroCliente");
		mv.addObject("clientes", todosClientes);
		mv.addObject(new Cliente());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Cliente cliente, Errors errors, RedirectAttributes attributes) {

		ModelAndView mv = new ModelAndView("CadastroCliente");
		List<Cliente> todosClientes = clientes.findAll();
		mv.addObject("clientes", todosClientes);

		if (errors.hasErrors()) {
			return "CadastroCliente";
		}

		clientes.save(cliente);
		mv.addObject("mensagem", "Cliente salvo com sucesso!");
		attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
		todosClientes = clientes.findAll();
		mv.addObject("clientes", todosClientes);
		attributes.addFlashAttribute("clientes", todosClientes);
		return "redirect:/clientes";
	}

	@RequestMapping("{id}")
	public ModelAndView edicao(@PathVariable("id") Cliente cliente) {
		List<Cliente> todosClientes = clientes.findAll();

		ModelAndView mv = new ModelAndView("CadastroCliente");
		mv.addObject("clientes", todosClientes);
		mv.addObject("cliente", cliente);

		return mv;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable int id, RedirectAttributes attributes) {
		clientes.deleteById(id);

		attributes.addFlashAttribute("mensagem", "Cliente excluído com sucesso!");
		return "redirect:/clientes";
	}
}
