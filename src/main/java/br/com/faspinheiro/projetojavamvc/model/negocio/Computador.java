package br.com.faspinheiro.projetojavamvc.model.negocio;

public class Computador extends Produto{

	private String fabricante;	
	private String modelo;
	
	public Computador() {
		this.setTipoProduto("Computador");
	}
	
	public Computador(String fabricante, String modelo) {
		this();
		this.fabricante = fabricante;
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void exibir() {
		System.out.println(this);
		
	}
	
	@Override
	public String toString() {		
		return String.format("Computador: %s\nModelo: %s\nFabricante: %s\nPreço: R$ %.2f",				
				this.getDescricao(),
				this.getModelo(),
				this.getFabricante(),				
				this.getPreco());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
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
		Computador other = (Computador) obj;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		return true;
	}
}
