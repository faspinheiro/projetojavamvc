package br.com.faspinheiro.projetojavamvc.model.negocio;

import java.util.Set;

public class Pedido{
	
	private Integer id;
	private boolean entregue;	
	private String observacao;
	private String descricao;		
	private Set<ItemPedido> itens;	
	private Empresa empresa;	
	
	public Pedido() {
	}
	
	public Pedido(Integer id, String descricao, String observacao, boolean entregue) {		
		this(descricao, observacao);
		this.id = id;			
		this.entregue = entregue;
	}
	
	
	public Pedido(Integer id, String observacao, String descricao, boolean entregue, Integer idEmpresa, String nome, String endereco, boolean nacional, String email) {
		this(id, descricao, observacao, entregue);			
		this.empresa = new Empresa(idEmpresa, nome, endereco, nacional, email);
	}
	
	public Pedido(String descricao, String observacao) {
		this.observacao = observacao;
		this.descricao = descricao;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isEntregue() {
		return entregue;
	}

	public void setEntregue(boolean entregue) {
		this.entregue = entregue;
	}

	public double getValor() {	
		
		double valor = 0.0;
		
		if(itens.size() < 1) {
			return valor;
		}else {
			for(ItemPedido item : itens) {
				valor += item.getValor();
			}			
			return valor;
		}
	}	

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Empresa getEmpresa() {
		return this.empresa;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void adicionaItem(ItemPedido item) {
		itens.add(item);
	}
	
	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	public String listaItens() {
		String temp = "Não há itens";
		
		if(itens.size() >= 1) {
			temp = "";
			int contador = 1;
			
			for(ItemPedido item : itens) {
				temp += "Item "+contador+": \n" + item +"\n";
				contador++;
			}
		}
		
		return temp;
	}
	
	@Override
	public String toString() {
		
		return String.format("-Pedido %d: %s\n-Observação: %s\n-Valor do pedido: R$ %.2f\n-Requisitante: %s\n-Status: %s\n <==Itens==>:\n%s",
				this.getId(),
				this.getDescricao(),
				this.getObservacao(),
				this.getValor(),
				this.getEmpresa().getNome(),
				this.isEntregue() ? "Entregue" : "A caminho",
				this.listaItens()); 
	}
	
	public void exibir() {
		System.out.println(this);		
		empresa.exibir();
	}
	
	public void associa(Empresa empresa){
		this.empresa = empresa;		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
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
		Pedido other = (Pedido) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		return true;
	}
	
}
