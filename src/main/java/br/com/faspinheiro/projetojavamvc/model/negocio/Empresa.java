package br.com.faspinheiro.projetojavamvc.model.negocio;

public class Empresa{	

	private Integer id;
	private String nome;
	private String endereco;
	private boolean nacional;
	private String email;
		
	public Empresa() {
		
	}
	
	public Empresa(String nome, String endereco, boolean nacional, String email) {		
		this();
		this.nome = nome;
		this.endereco = endereco;
		this.nacional = nacional;
		this.email = email;
	}

	public Empresa(Integer id, String nome, String endereco, boolean nacional, String email) {
		this(nome, endereco, nacional, email);		
		this.id = id;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setNacional(boolean nacional) {
		this.nacional = nacional;
	}
	
	public boolean getNacional() {
		return nacional;
	}

	@Override
	public String toString() {		
		return String.format("Empresa: %s - %s - %s - %s",
				this.getNome(),
				this.getEmail(),
				this.getEndereco(),
				this.getNacional()?"Nacional":"Estrangeira");		
	}
	
	public void exibir() {				
		System.out.println(this);		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Empresa other = (Empresa) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
}
