package chapter21_mini_projcet.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_projcet.model.BookVo;
import chapter21_mini_projcet.model.CartVo;
import chapter21_mini_projcet.model.MemberVo;
import db.DBconn;

public class CartRepositoryImpl extends DBconn
	implements ShoppingRepositoryInterface<CartVo>{
	
	public CartRepositoryImpl() {
		super();
	}

	@Override
	public int insert(CartVo cart) {
		int rows = 0;
		String sql = "insert into book_market_cart(bid, mid) values(?,?)";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, cart.getBid());
			pstmt.setString(2, cart.getMid());			
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public CartVo find(String id) {

		CartVo cart = null;
		
		String sql = "select bid, title, author, price, category, content, bdate from book_market_books where bid = ?";
		try {
				getPreparedStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
					
				while(rs.next()) {
					cart = new CartVo();
					cart.setBid(rs.getString(1));
					cart.setCnt(rs.getInt(2));
					cart.setTotPrice(rs.getInt(3));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return cart;
	}

	@Override
	public List<CartVo> findAll() {
		List<CartVo> list = null;
		String sql = "select a.bid, count(a.bid) as count, sum(b.price) as price\r\n"
				+ "from book_market_cart a inner join book_market_books b \r\n"
				+ "on a.bid = b.bid\r\n"
				+ "where a.mid = ?\r\n"
				+ "group by a.bid";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, sql);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				list = new ArrayList<CartVo>();
				while(rs.next()) {
					/* order_id, bid, mid, order_date, delivery */
					CartVo cart = new CartVo();
					cart.setBid(rs.getString(1));
					cart.setCnt(rs.getInt(2));
					cart.setTotPrice(rs.getInt(3));
					list.add(cart);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
