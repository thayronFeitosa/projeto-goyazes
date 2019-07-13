package model;

public class Telefone {
	private int idFone;
	private int idCliente;
	private String celular1;
	private String celular2;
	private String fixo;
	private String recado;
	
	
	
	public Telefone(int idFone, int idCliente, String celular1, String celular2, String fixo, String recado) {
		this.idFone = idFone;
		this.idCliente = idCliente;
		this.celular1 = celular1;
		this.celular2 = celular2;
		this.fixo = fixo;
		this.recado = recado;
	}



	public Telefone() {
		
	}



	public int getIdFone() {
		return idFone;
	}



	public void setIdFone(int idFone) {
		this.idFone = idFone;
	}



	public int getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}



	public String getCelular1() {
		return celular1;
	}



	public void setCelular1(String celular1) {
		this.celular1 = celular1;
	}



	public String getCelular2() {
		return celular2;
	}



	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}



	public String getFixo() {
		return fixo;
	}



	public void setFixo(String fixo) {
		this.fixo = fixo;
	}



	public String getRecado() {
		return recado;
	}



	public void setRecado(String recado) {
		this.recado = recado;
	}
	
	
	
	

}
