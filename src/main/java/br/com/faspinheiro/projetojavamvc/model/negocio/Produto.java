package br.com.faspinheiro.projetojavamvc.model.negocio;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "tipoProduto")
@JsonSubTypes({
	@Type(value = Bebida.class, name = "Bebida"),
	@Type(value = Computador.class, name = "Computador"),
	@Type(value = Livro.class, name = "Livro")
})
public abstract class Produto{		
	
	private Integer id;
	private String descricao;
	private String tipoProduto;
	private float preco;
	
	public Produto() {
		
	}

	public Produto(String descricao, float preco) {
		this();		
		this.descricao = descricao;
		this.preco = preco;		
	}
	
	public Produto(String descricao, float preco, String tipoProduto) {
		this(descricao, preco);
		this.setTipoProduto(tipoProduto);
	}
	
	public Produto(String Id, String descricao, float preco, String tipoProduto) {
		this(descricao, preco, tipoProduto);
		this.setId(id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	
}
	
