package com.bookmgm.repository;

import java.util.List;

import com.bookmgm.model.Book;
import com.scoremgm.model.Member;

public interface BookRepository {
	boolean insert(Book book);
	int getCount();
	List<Book> selectAll();
	Book select(String id);
	void update(Book book);
	void remove(String id);
	void remove(Book book);

}
