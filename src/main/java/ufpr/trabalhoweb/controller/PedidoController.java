package ufpr.trabalhoweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ufpr.trabalhoweb.model.Cliente;
import ufpr.trabalhoweb.model.ItemDoPedido;
import ufpr.trabalhoweb.model.Pedido;
import ufpr.trabalhoweb.model.Produto;
import ufpr.trabalhoweb.repository.Clientes;
import ufpr.trabalhoweb.repository.Pedidos;
import ufpr.trabalhoweb.repository.Produtos;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	Pedidos pedidos;
	@Autowired
	Produtos produtos;
	@Autowired
	Clientes clientes;
	
	@RequestMapping
	public ModelAndView novo() {
		List<Produto> todosProdutos = produtos.findAll();
		List<Cliente> todosClientes = clientes.findAll();
		ModelAndView mv = new ModelAndView("CadastroPedido");
		List<ItemDoPedido> listItens = new ArrayList<>();
		Pedido pedido = new Pedido();
		todosProdutos.forEach(p -> {
			ItemDoPedido itemDoPedido = new ItemDoPedido();
			itemDoPedido.setProduto(p);
			itemDoPedido.setQuantidade(0);
			listItens.add(itemDoPedido);
		});
		
		
		pedido.setListItens(listItens);
		mv.addObject("produtos", todosProdutos);
		mv.addObject("clientes", todosClientes);
		mv.addObject("pedido", pedido);
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@ModelAttribute Pedido pedido, Errors errors, RedirectAttributes attributes, Model model) {

		ModelAndView mv = new ModelAndView("CadastroPedido");
//		List<Produto> todosProdutos = produtos.findAll();
//		mv.addObject("produtos", todosProdutos);

		if (errors.hasErrors()) {
			System.out.println("Erro ao salvar");
			System.out.println(errors.toString());
			return "CadastroPedido";
		}
		
		pedido.getListItens().forEach(item -> {
			item.setPedido(pedido);
		});

		System.out.println("Tudo certo!");
		pedidos.save(pedido);
		mv.addObject("mensagem", "Pedido salvo com sucesso!");
		attributes.addFlashAttribute("mensagem", "Pedido salvo com sucesso!");
//		todosProdutos = produtos.findAll();
//		mv.addObject("produtos", todosProdutos);
//		attributes.addFlashAttribute("produtos", todosProdutos);
		return "redirect:/pedidos";
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
	
	@RequestMapping("/lista")
	public ModelAndView listarPedidos() {
		List<Pedido> todosPedidos = pedidos.findAll();

		ModelAndView mv = new ModelAndView("ListaPedidos");
		mv.addObject("pedidos", todosPedidos);

		return mv;
	}
	
}
