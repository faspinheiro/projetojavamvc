package br.com.faspinheiro.projetojavamvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.faspinheiro.projetojavamvc.model.negocio.Computador;

@Service
public class ComputadorService {
	
	@Autowired
	private RestTemplate rest;
	
	public List<Computador> obterTodos(){		
		return (List<Computador>) rest.getForObject("http://localhost:8080/api/computador", List.class);
	}
	
	public Computador obterComputador(Integer id) {		
		return rest.getForObject("http://localhost:8080/api/computador/{id}", Computador.class, id);
	}
	
	public void incluir(Computador computador) {
		rest.postForEntity("http://localhost:8080/api/computador", computador, String.class);
	}
	
	public void excluir(Integer id) {
		rest.delete("http://localhost:8080/api/computador/{id}", id);
	}
}
