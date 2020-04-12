package br.com.faspinheiro.projetojavamvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.faspinheiro.projetojavamvc.model.negocio.Empresa;

@Service
public class EmpresaService {
	
	@Autowired
	private RestTemplate rest;
	
	public List<Empresa> obterTodos(){		
		return (List<Empresa>) rest.getForObject("http://localhost:8080/api/empresa", List.class);
	}
	
	public Empresa obterEmpresa(Integer id) {		
		return rest.getForObject("http://localhost:8080/api/empresa/{id}", Empresa.class, id);
	}
	
	public void incluir(Empresa empresa) {
		rest.postForEntity("http://localhost:8080/api/empresa", empresa, String.class);
	}
	
	public void excluir(Integer id) {
		rest.delete("http://localhost:8080/api/empresa/{id}", id);
	}
}
