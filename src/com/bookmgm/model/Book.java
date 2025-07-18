package com.bookmgm.model;

public class Book {
	private String id; 		// 도서번호
	private String name;	// 도서이름
	private String author;	// 저자이름
	private int price;		// 금액
	
	public Book() {}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
