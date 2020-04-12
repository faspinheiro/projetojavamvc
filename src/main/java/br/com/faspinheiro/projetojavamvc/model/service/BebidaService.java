package br.com.faspinheiro.projetojavamvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.faspinheiro.projetojavamvc.model.negocio.Bebida;

@Service
public class BebidaService {
	
	@Autowired
	private RestTemplate rest;
	
	public List<Bebida> obterTodos(){		
		return (List<Bebida>) rest.getForObject("http://localhost:8080/api/bebida", List.class);
	}
	
	public Bebida obterBebida(Integer id) {		
		return rest.getForObject("http://localhost:8080/api/bebida/{id}", Bebida.class, id);
	}
	
	public void incluir(Bebida bebida) {
		rest.postForEntity("http://localhost:8080/api/bebida",bebida,String.class);
	}
	
	public void excluir(Integer id) {
		rest.delete("http://localhost:8080/api/bebida/{id}", id);
	}
	
}
