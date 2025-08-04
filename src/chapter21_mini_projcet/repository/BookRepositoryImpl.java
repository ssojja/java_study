package chapter21_mini_projcet.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_projcet.model.BookVo;
import chapter21_mini_projcet.model.MemberVo;
import db.DBconn;

public class BookRepositoryImpl extends DBconn
	implements ShoppingRepositoryInterface<BookVo>{
	
	public BookRepositoryImpl() {
		super();
	}

	@Override
	public int insert(BookVo member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BookVo find(String id) {
		BookVo book = null;
		
		String sql = "select bid, title, author, price, category, content, bdate from book_market_books where bid = ?";
		try {
				getPreparedStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
					
				while(rs.next()) {
					book = new BookVo();
					book.setBid(rs.getString(1));
					book.setTitle(rs.getString(2));
					book.setAuthor(rs.getString(3));
					book.setPrice(rs.getInt(4));
					book.setCategory(rs.getString(5));
					book.setContent(rs.getString(6));
					book.setBdate(rs.getString(7));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return book;
	}

	@Override
	public List<BookVo> findAll() {
		List<BookVo> list = null;
		String sql = "select bid, title, author, price, category, content, bdate from book_market_books";
		
		try {
			getPreparedStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				list = new ArrayList<BookVo>();
				while(rs.next()) {
					BookVo book = new BookVo();
					book.setBid(rs.getString(1));
					book.setTitle(rs.getString(2));
					book.setAuthor(rs.getString(3));
					book.setPrice(rs.getInt(4));
					book.setCategory(rs.getString(5));
					book.setContent(rs.getString(6));
					book.setBdate(rs.getString(7));
					list.add(book);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	};

}
