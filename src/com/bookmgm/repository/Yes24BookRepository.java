package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bookmgm.model.Book;

public class Yes24BookRepository implements BookRepository{
	
	List<Book> library = new ArrayList<Book>();
	
	public Yes24BookRepository() {
		System.out.println("** Yes24 Repository **");
	}
	
	@Override
	public boolean insert(Book book) {
		if(book == null) return false;
		return library.add(book);
	};
	
	@Override
	public int getCount() {
		return library.size();
	};
	
	@Override
	public List<Book> selectAll(){
		return library;
	};

	@Override
	public Book select(String id) {
		Book book = null;
		for(Book b : library) {
			if(b.getId().equals(id)) {
				book = b;
				break;
			}
		}
		return book;
	};
	
	@Override
	public void update(Book book) {
		int idx = -1;
//		for(int i = 0; i < library.size();i++) {
//			if(library.get(i).getId().equals(book.getId())) {
//				idx = i;
//				break;
//			}
//		}
		int i = 0;
		for(Book b : library) {
			if(b.getId().equals(book.getId())) {
				idx = i;
				break;
			}
			i++;
		}

		library.set(idx, book);
	};
	
	@Override
	public void remove(String id) {
		Iterator<Book> ie = library.iterator();
		while(ie.hasNext()){
			Book book = ie.next();
			if(book.getId().equals(id)) {
				ie.remove();
			}
		}
		
	};
	
	@Override
	public void remove(Book book) {
		Iterator<Book> ie = library.iterator();
		while(ie.hasNext()){
			Book b = ie.next();
			if(b == book) ie.remove();
		}
		
	};
}
