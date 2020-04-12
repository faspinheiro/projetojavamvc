package br.com.faspinheiro.projetojavamvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.faspinheiro.projetojavamvc.model.negocio.Livro;


@Service
public class LivroService {
	
	@Autowired
	private RestTemplate rest;
	
	public List<Livro> obterTodos(){		
		return (List<Livro>) rest.getForObject("http://localhost:8080/api/livro", List.class);
	}
	
	public Livro obterLivro(Integer id) {		
		return rest.getForObject("http://localhost:8080/api/livro/{id}", Livro.class, id);
	}
	
	public void incluir(Livro livro) {
		rest.postForEntity("http://localhost:8080/api/livro", livro, String.class);
	}
	
	public void excluir(Integer id) {
		rest.delete("http://localhost:8080/api/livro/{id}", id);
	}

}
