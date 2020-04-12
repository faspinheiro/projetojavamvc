package br.com.faspinheiro.projetojavamvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.faspinheiro.projetojavamvc.model.negocio.Empresa;
import br.com.faspinheiro.projetojavamvc.model.service.EmpresaService;

@Controller
public class EmpresaController {
	
	@Autowired
	private EmpresaService servico;
	
	@RequestMapping(value = "/empresas", method = RequestMethod.GET)
	public String empresaIndex(Model model) {
		
		model.addAttribute("listaEmpresas", servico.obterTodos());
		
		return "empresa/index";
	}
	
	@RequestMapping(value = "/empresa/detalhes/{id}", method = RequestMethod.GET)
	public String empresaDetalhes(Model model, @PathVariable Integer id) {		
		
		model.addAttribute("empresa", servico.obterEmpresa(id));		
		
		return "empresa/empresadetalhes";
	}	
	
	
	@RequestMapping(value = "/empresa/new", method = RequestMethod.GET)
	public String empresaCadastro(Model model) {		
		
		return "empresa/empresacadastro";
	}
	
	@RequestMapping(value = "/empresa/new", method = RequestMethod.POST)
	public String empresaSalvar(Model model, Empresa empresa) {		
		
		servico.incluir(empresa);				
		
		return this.empresaIndex(model);
	}
	
	@RequestMapping(value = "/empresa/excluir/{id}", method = RequestMethod.GET)
	public String empresaExcluir(Model model, @PathVariable Integer id) {		
		
		model.addAttribute("empresa", servico.obterEmpresa(id));
		
		return "empresa/empresaexcluir";
	}
	
	@RequestMapping(value = "/empresa/excluir", method = RequestMethod.POST)
	public String empresaExcluirConfirmado(Model model, Integer id) {
		
		servico.excluir(id);
		
		return this.empresaIndex(model);
	}
	

}
