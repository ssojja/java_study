package chapter21_mini_projcet.repository;

import java.util.List;

public interface ShoppingRepositoryInterface<T> {
	String findId();
	int insert(T entity);
	T find(String id);
	List<T> findAll();
	int update(T entity);
	int remove(String id);
	int removeAll();
	void close();
}
