package br.com.faspinheiro.projetojavamvc.model.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.faspinheiro.projetojavamvc.model.negocio.Bebida;
import br.com.faspinheiro.projetojavamvc.model.negocio.Computador;
import br.com.faspinheiro.projetojavamvc.model.negocio.Livro;
import br.com.faspinheiro.projetojavamvc.model.negocio.Produto;


@Component
public class ProdutoConversor implements Converter<String, Produto> {

	@Override
	public Produto convert(String tipoProduto) {
		Produto produto = null;
		
		switch(tipoProduto) {
		case "Bebida":
			produto = new Bebida();
			break;
		case "Computador":
			produto = new Computador();
			break;		
		case "Livro":
			produto = new Livro();
			break;
			default:
				throw new IllegalArgumentException("Tipo de produto inválido");
		}
		
		return produto;
	}

}
