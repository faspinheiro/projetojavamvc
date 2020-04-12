package br.com.faspinheiro.projetojavamvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.faspinheiro.projetojavamvc.model.negocio.Produto;

@Service
public class ProdutoService {
	
	@Autowired
	private RestTemplate rest;
	
	public List<Produto> obterTodos() {		
		return (List<Produto>) rest.getForObject("http://localhost:8080/api/produto", List.class);
	}
	
	public Produto obterProduto(Integer id){
		return rest.getForObject("http://localhost:8080/api/produto/{id}", Produto.class, id);
	}
	
	public void incluir(Produto produto) {
		rest.postForEntity("http://localhost:8080/api/produto", produto, String.class);
	}
	
	public void excluir(Integer id) {
		rest.delete("http://localhost:8080/api/produto/{id}", id);
	}
}
