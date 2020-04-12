package br.com.faspinheiro.projetojavamvc.controller;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.faspinheiro.projetojavamvc.model.negocio.Produto;
import br.com.faspinheiro.projetojavamvc.model.service.ProdutoService;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService servico;	
	
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public String produtosIndex(Model model) {		
		
		model.addAttribute("listaProdutos", servico.obterTodos());		
		
		return "produto/index";
	}
	
	@RequestMapping(value = "/produto/detalhes/{id}", method = RequestMethod.GET)
	public String produtoDetalhes(Model model, @PathVariable Integer id) {
		
		Produto produto = servico.obterProduto(id);
		
		model.addAttribute("produto", produto);
	
		model.addAttribute("camposProduto", this.pegaCamposProduto(produto));
		
		return "produto/produtodetalhes";
	}
	
	
	@RequestMapping(value = "/produto/new", method = RequestMethod.GET)
	public String produtoCadastro(Model model) {		
		return "produto/produtocadastro";		
	}
	
	@RequestMapping(value = "/produto/new", method = RequestMethod.POST)
	public String produtoSalvar(Model model, @ModelAttribute("tipoProduto") Produto produto, BindingResult result) {	
		
		servico.incluir(produto);
		
		return this.produtosIndex(model);		
	}	
	
	
	@RequestMapping(value = "/produto/excluir/{id}", method = RequestMethod.GET)
	public String produtoExcluir(Model model, @PathVariable Integer id) {
		
		Produto produto = servico.obterProduto(id);
		
		model.addAttribute("produto", produto);
	
		model.addAttribute("camposProduto", this.pegaCamposProduto(produto));
		
		return "produto/produtoexcluir";
	}
	
	@RequestMapping(value = "/produto/excluir", method = RequestMethod.POST)
	public String produtoExcluirConfirmado(Model model, Integer id) {
		
		servico.excluir(id);
		
		return this.produtosIndex(model);
	}
	
	
	
	private Map<String, String> pegaCamposProduto(Produto produto){
		
		Map<String, String> campos = new HashMap<String,String>();
		
		for(Field field : produto.getClass().getDeclaredFields()) {
			try {
				field.setAccessible(true);
				campos.put(field.getName().substring(0,1).toUpperCase() + field.getName().substring(1),
						field.get(produto).toString());
			} catch(Exception e) {
				
			}
		}
		
		return campos;
		
	}
}
