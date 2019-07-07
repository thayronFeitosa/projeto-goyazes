package dao;

import model.Cliente;

public interface IValidar {
	public boolean isValid(Cliente obj);
	public boolean isEmpty(Cliente obj);

}
