package user.repository;

import java.util.ArrayList;

public interface IRepository<T, V> {

	// C
	public void post(T dto);

	// R one
	public T findById(V id);

	// R all
	public ArrayList<T> findAll();

	// U
	public void update(V id, T dto);

	// D
	public void delete(V id);
}
