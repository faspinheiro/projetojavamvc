package br.com.faspinheiro.projetojavamvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.faspinheiro.projetojavamvc.model.negocio.ItemPedido;

@Service
public class ItemPedidoService {
	
	@Autowired
	private RestTemplate rest;
	
	public List<ItemPedido> obterTodos() {		
		return (List<ItemPedido>) rest.getForObject("http://localhost:8080/api/itempedido", List.class);
	}
	
	public ItemPedido obterItemPedido(Integer id){
		return rest.getForObject("http://localhost:8080/api/itempedido/{id}", ItemPedido.class, id);
	}
	
	public void incluir(ItemPedido item) {
		rest.postForEntity("http://localhost:8080/api/itempedido", item, String.class);
	}
	
	public void excluir(Integer id) {
		rest.delete("http://localhost:8080/api/itempedido/{id}", id);
	}
}
