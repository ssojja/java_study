package db;

import java.util.List;

public interface GenericRepositoryInterface<T> {
	int insert(T entity);
	int remove(String mid);
	int update(T entity);
	T find(String id);
	int getCount();
	List<T> findAll();
	void close();
}
 