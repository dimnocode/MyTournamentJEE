package mt.repository;

import java.util.Collection;



public interface IRepository<T> {
	
	T find(int id);
	Collection<T> findAll();
	T update(T entity);
	void delete(int id);
	void create(T entity);
	void close();
}
