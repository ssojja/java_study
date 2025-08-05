package chapter21_mini_projcet.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_projcet.model.CartVo;
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
		
		String sql = "select order_id, qty, bid, mid, cdate, delivery from book_market_cart where bid = ?";
		try {
				getPreparedStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
					
				if(rs != null) {
					while(rs.next()) {
						cart = new CartVo();
						cart.setOrderId(rs.getString(1));
						cart.setCnt(rs.getInt(2));
						cart.setBid(rs.getString(3));
						cart.setMid(rs.getString(4));
						cart.setOrderDate(rs.getString(5));
						cart.setDelivery(rs.getString(6));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return cart;
	}
	
	@Override
	public List<CartVo> findAll() {
		List<CartVo> list = null;
		String sql = """
					select a.bid, sum(a.qty) as sum, sum(b.price*a.qty) as price
					from book_market_cart a inner join book_market_books b
					on a.bid = b.bid
					where a.mid = (select mid from book_market_member
									order by mdate desc
									limit 1)
					group by a.bid
				""";
		
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				list = new ArrayList<CartVo>();
				while(rs.next()) {
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
	
	@Override
	public int update(CartVo cart) {
		int rows = 0;
		String sql = null;
		if(cart.getBid() != null){
				sql = """ 
					update book_market_cart set qty = ? where bid = ? and mid = (select mid from book_market_member
					order by mdate desc
					limit 1)
				""";
				try {
					getPreparedStatement(sql);
					pstmt.setInt(1, cart.getCnt());
					pstmt.setString(2, cart.getBid());
					rows = pstmt.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		} else {
			sql = """ 
					update book_market_cart set delivery = now() where mid = (select mid from book_market_member
					order by mdate desc
					limit 1)
				""";
			try {
				getPreparedStatement(sql);
				rows = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return rows;
	}

	@Override
	public String findId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(String id) {
		int rows = 0;
		String sql = """
					delete from book_market_cart where bid = ? and mid = (select mid from book_market_member
					order by mdate desc
					limit 1)
				""";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int removeAll() {
		int rows = 0;
		String sql = """
					delete from book_market_cart where mid = (select mid from book_market_member
					order by mdate desc
					limit 1)
				""";
		try {
			getPreparedStatement(sql);
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
}
