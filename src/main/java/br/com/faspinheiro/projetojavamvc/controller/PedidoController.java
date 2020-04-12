package br.com.faspinheiro.projetojavamvc.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.faspinheiro.projetojavamvc.model.negocio.ItemPedido;
import br.com.faspinheiro.projetojavamvc.model.negocio.Pedido;
import br.com.faspinheiro.projetojavamvc.model.service.EmpresaService;
import br.com.faspinheiro.projetojavamvc.model.service.PedidoService;
import br.com.faspinheiro.projetojavamvc.model.service.ProdutoService;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService servico;
	@Autowired
	private ProdutoService produtoServico;
	@Autowired
	private EmpresaService empresaServico;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		List<Pedido> pedidos = servico.obterTodos();
		
		model.addAttribute("Lista", pedidos);		
		
		return "home";
	}
	
	@RequestMapping(value = "/pedidos", method = RequestMethod.GET)
	public String pedidos(Model model) {
		return this.home(model);
	}
	
	@RequestMapping(value = "/pedido/detalhes/{id}", method = RequestMethod.GET)
	public String pedidoDetalhes(Model model, @PathVariable Integer id) {
		
		Pedido pedido = servico.obterPedido(id);
		
		model.addAttribute("pedido", pedido);
		//model.addAttribute("listaItens", new Gson().toJson(pedido.getItens()));
		
		return "pedido/pedidodetalhes";
	}
	
	@RequestMapping(value = "/pedido/new", method = RequestMethod.GET)
	public String pedidoCadastro(Model model) {
		
		model.addAttribute("produtos", produtoServico.obterTodos());
		model.addAttribute("empresas", empresaServico.obterTodos());
		
		return "pedido/pedidocadastro";
	}
	
	@RequestMapping(value = "/pedido/new", method = RequestMethod.POST)
	public String pedidoSalvar(Model model, Pedido pedido, Integer empresaId, Integer[] produtosId, Integer[] prodQuantidade) {
		
		Set<ItemPedido> items = new HashSet<ItemPedido>() ;
		
		int i = 0;
		
		for(Integer id : produtosId) {
			ItemPedido item = new ItemPedido();
			item.incluiProduto(produtoServico.obterProduto(id));
			item.setQuantidade(prodQuantidade[i]);
			i++;
			items.add(item);
		}
		
		pedido.setDescricao("Pedido de " +items.size()+" itens." );		
		pedido.setItens(items);
		pedido.associa(empresaServico.obterEmpresa(empresaId));
		servico.incluir(pedido);
				
		return this.home(model);
	}
	
	@RequestMapping(value = "/pedido/excluir/{id}", method = RequestMethod.GET)
	public String pedidoExcluir(Model model, @PathVariable Integer id) {		
		
		model.addAttribute("pedido", servico.obterPedido(id));
		
		return "pedido/pedidoexcluir";
	}
	
	@RequestMapping(value = "/pedido/excluir", method = RequestMethod.POST)
	public String pedidoExcluirConfirmado(Model model, Integer id) {
		
		servico.excluir(id);
		
		return this.home(model);
	}
	
	

}
