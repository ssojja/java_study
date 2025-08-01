package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.List;

import com.bookmgm.model.Book;
import db.DBconn;
import db.GenericRepositoryInterface;

public class InMemoryBookRepository extends DBconn
	implements GenericRepositoryInterface<Book>{
	
	static final String TJ = "book_tj";
	static final String YES24 = "book_yes24";
	static final String ALADIN = "book_aladin";
	String tableName = "";
	
	public InMemoryBookRepository(int rno) {
		super();
		createTitle(rno);
	} 

	public void createTitle(int rno) {
		String name = "";
		if(rno == 1) {
			name = "교육센터";
			tableName = TJ;
		}
		else if(rno == 2) {
			name = "알라딘";
			tableName = ALADIN;
		}
		else if(rno == 3) {
			name = "예스24";
			tableName = YES24;
		} 
		System.out.println("** " + name + " Repository **");
	}
	
	@Override
	public int insert(Book book) {
		int rows = 0;
		String sql = " insert into " + tableName + "(title, author, price, isbn, bdate) " 
					  + " values(?, ?, ?, ?, now())";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setInt(4, book.getIsbn());
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	};
	
	@Override
	public int getCount() {
		int rows = 0;
		String sql = "select count(*) from " + tableName;

		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) rows = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	};
	
	@Override
	public List<Book> findAll(){
		List<Book> list = null;
		String sql = "select bid, title, author, price, isbn, bdate from " + tableName;
		
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			if(rs != null) {
				list = new ArrayList<Book>();
				while(rs.next()) {
					Book book = new Book();
					book.setBid(rs.getString(1));
					book.setName(rs.getString(2));
					book.setAuthor(rs.getString(3));
					book.setPrice(rs.getInt(4));
					book.setIsbn(rs.getInt(5));
					book.setBdate(rs.getString(6));
					list.add(book);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	};

	@Override
	public Book find(String id) {
		Book book = null;
		String sql = "select bid, title, author, price, isbn, bdate from "
				+ tableName + " where bid = ? ";
		try {
				getPreparedStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
					
				while(rs.next()) {
					book = new Book();
					book.setBid(rs.getString(1));
					book.setName(rs.getString(2));
					book.setAuthor(rs.getString(3));
					book.setPrice(rs.getInt(4));
					book.setIsbn(rs.getInt(5));
					book.setBdate(rs.getString(6));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return book;
	};
	
	@Override
	public int update(Book book) {
		int rows = 0;
		String sql = " update " + tableName + " set title = ?, author = ?, price = ? where bid = ? ";

		try {
			getPreparedStatement(sql);
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getBid());
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	};
	
	@Override
	public int remove(String bid) {
		int rows = 0;
		String sql = " delete from " + tableName + " where bid = ?";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, bid);
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	};
}
