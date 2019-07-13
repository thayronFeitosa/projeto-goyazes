package model;

import java.util.List;

public interface IDao<T> {

	public boolean insert(T valor);
	
	public boolean delete(int i);
	
	public boolean update(T valor);
	
	public List<T> listarTodos();
}
