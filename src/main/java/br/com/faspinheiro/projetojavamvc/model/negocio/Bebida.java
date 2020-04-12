package br.com.faspinheiro.projetojavamvc.model.negocio;

public class Bebida extends Produto{

	private String fabricante;	
	private String rotulo;
	
	public Bebida() {
		this.setTipoProduto("Bebida");
	}
	
	public Bebida(String fabricante, String rotulo) {
		this();
		this.fabricante = fabricante;
		this.rotulo = rotulo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public void exibir() {
		System.out.println(this);
		
	}
	
	@Override
	public String toString() {		
		return String.format("Bebida: %s\nRótulo: %s\nFabricante: %s\nPreço: R$ %.2f",				
				this.getDescricao(),
				this.getRotulo(),
				this.getFabricante(),				
				this.getPreco());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((rotulo == null) ? 0 : rotulo.hashCode());
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
		Bebida other = (Bebida) obj;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (rotulo == null) {
			if (other.rotulo != null)
				return false;
		} else if (!rotulo.equals(other.rotulo))
			return false;
		return true;
	}

}
