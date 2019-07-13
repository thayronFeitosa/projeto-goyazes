package model;

import model.Mysql.UserDao;

public class User {
	private int id_user;
	private String nome;
	private String email;
	private String senha;
	private int acesso; // controla o tipo de acesso do usuario. sento 1 basico e 2 administrador
	private static IUser dao = new UserDao();
	
	public User() {
	}
	
	public User(String nome, String email, String senha, int acesso) {
	
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.acesso = acesso;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	  public static User login(String email, String senha){
	        return dao.login(email, senha);
	    }

	public int getAcesso() {
		return acesso;
	}

	public void setAcesso(int acesso) {
		this.acesso = acesso;
	}

}
