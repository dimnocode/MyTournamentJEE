package mt.repository;

import java.util.Collection;



public interface IRepository<T> {
	
	T find(int id);
	Collection<T> findAll();
	T updateT(T entity);
	void deleteT(int id);
	void createT(T entity);
	void close();
}
