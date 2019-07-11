package model;

public class User {
	private int id_user;
	private String nome;
	private String sobreNome;
	private String email;
	
	public User() {
	}
	
	public User(int id_user, String nome, String sobreNome, String email) {
		this.id_user = id_user;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
