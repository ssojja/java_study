package chapter21_mini_projcet.repository;

import java.util.List;

import chapter21_mini_projcet.model.MemberVo;
import db.DBconn;

public class MemberRepositoryImpl extends DBconn 
	implements ShoppingRepositoryInterface<MemberVo>{
	
	
	public MemberRepositoryImpl() {
		super();
	}
	
	@Override
	public int insert(MemberVo member) {
		int rows = 0;
		String sql = "insert into book_market_member(name, phone, addr, mdate) values(?,?,?, now())";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getAddr());
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	@Override
	public MemberVo find(String id) {
		MemberVo member = null;
		
		String sql = "select mid, name, phone, addr, mdate from book_market_member where mid = ? ";
		try {
				getPreparedStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
					
				while(rs.next()) {
					member = new MemberVo();
					member.setMid(rs.getString(1));
					member.setName(rs.getString(2));
					member.setPhone(rs.getString(3));
					member.setAddr(rs.getString(4));
					member.setMdate(rs.getString(5));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return member;
	};

	@Override
	public int update(MemberVo member) {
		int rows = 0;
		String sql = null;

		sql = """ 
				update book_market_member set name = ?, phone = ?, addr = ? where mid = ?
				""";
		try {
				getPreparedStatement(sql);
				pstmt.setString(1, member.getName());
				pstmt.setString(2, member.getPhone());
				pstmt.setString(3, member.getAddr());
				pstmt.setString(4, member.getMid());
				rows = pstmt.executeUpdate();
					
			} catch (Exception e) {
				e.printStackTrace();
			}

		return rows;
	}

	@Override
	public List<MemberVo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findId() {
		String mid = null;
		String sql = """
				select mid from book_market_member
				order by mdate desc
				limit 1
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mid = rs.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mid;
	}

	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeAll() {
		// TODO Auto-generated method stub
		return 0;
	}

}
