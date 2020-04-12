package br.com.faspinheiro.projetojavamvc.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.faspinheiro.projetojavamvc.model.negocio.Pedido;

@Service
public class PedidoService {
	
	@Autowired
	private RestTemplate rest;
	
	public List<Pedido> obterTodos() {		
		return (List<Pedido>) rest.getForObject("http://localhost:8080/api/pedido", List.class);
	}
	
	public Pedido obterPedido(Integer id){
		return rest.getForObject("http://localhost:8080/api/pedido/{id}", Pedido.class, id);
	}
	
	public void incluir(Pedido pedido) {
		rest.postForEntity("http://localhost:8080/api/pedido", pedido, String.class);
	}
	
	public void excluir(Integer id) {
		rest.delete("http://localhost:8080/api/pedido/{id}", id);
	}
}
