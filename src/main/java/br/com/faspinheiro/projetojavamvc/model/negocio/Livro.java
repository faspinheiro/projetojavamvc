package br.com.faspinheiro.projetojavamvc.model.negocio;

public class Livro extends Produto{

	private String titulo;
	private String autor;	
	private String editora;
	private Integer anoEdicao;
	
	public Livro() {
		this.setTipoProduto("Livro");		
	}
	
	public Livro(String titulo, String autor, String editora, Integer anoEdicao) {
		this();
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.anoEdicao = anoEdicao;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Integer getAnoEdicao() {
		return anoEdicao;
	}

	public void setAnoEdicao(Integer anoEdicao) {
		this.anoEdicao = anoEdicao;
	}

	@Override
	public String toString() {		
		return String.format("Livro: %s\nDescrição: %s\nAutor: %s\nEditora: %s\nAno de edição: %s\nPreço: R$%.2f",				
				this.getTitulo(),
				this.getDescricao(),
				this.getAutor(),
				this.getEditora(),
				this.getAnoEdicao(),
				this.getPreco());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((anoEdicao == null) ? 0 : anoEdicao.hashCode());
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((editora == null) ? 0 : editora.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (anoEdicao == null) {
			if (other.anoEdicao != null)
				return false;
		} else if (!anoEdicao.equals(other.anoEdicao))
			return false;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (editora == null) {
			if (other.editora != null)
				return false;
		} else if (!editora.equals(other.editora))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
}
