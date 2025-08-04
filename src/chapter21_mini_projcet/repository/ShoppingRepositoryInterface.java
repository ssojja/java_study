package chapter21_mini_projcet.repository;

import java.util.List;

public interface ShoppingRepositoryInterface<T> {

	int insert(T entity);
	T find(String id);
	List<T> findAll();
	void close();

}
