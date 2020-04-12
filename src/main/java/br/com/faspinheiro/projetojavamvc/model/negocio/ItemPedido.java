package br.com.faspinheiro.projetojavamvc.model.negocio;

public class ItemPedido{	
	
	
	private Integer id;	
	private Integer quantidade;	
	private Produto produto;	
	private Pedido pedido;
	
	public ItemPedido() {
		
	}

	public ItemPedido(Integer quantidade, Produto produto, Pedido pedido) {
		super();
		this.quantidade = quantidade;
		this.produto = produto;
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void incluiProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void associaPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public double getValor() {		
		return produto.getPreco() * this.quantidade;
	}
	
	@Override
	public String toString() {
		return String.format("%s\nQuantidade: %d\nValor do item: R$ %.2f", 
				this.getProduto(),
				this.getQuantidade(),
				this.getValor());
	}
	
}
	
