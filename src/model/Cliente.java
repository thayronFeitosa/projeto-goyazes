package model;

public class Cliente {
	private int id_cliente;
	private String nome;
	private String sobreNome;
	private String cpf;
	private String sexo;
	private String email;
	

	
	public Cliente() {
		
	}
	public Cliente(String nome, String sobreNome, String cpf, String sexo) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
		this.sexo = sexo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobreNome() {
		return sobreNome;
	}


	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	

}
