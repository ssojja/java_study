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
		String sql = "insert into book_market_member(name, phone) values(?,?)";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPhone());			
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	@Override
	public MemberVo find(String phone) {
		MemberVo member = null;
		
		String sql = "select mid, name, phone, addr from book_market_member where phone = ? ";
		try {
				getPreparedStatement(sql);
				pstmt.setString(1, phone);
				rs = pstmt.executeQuery();
					
				while(rs.next()) {
					member = new MemberVo();
					member.setMid(rs.getString(1));
					member.setName(rs.getString(2));
					member.setPhone(rs.getString(3));
					member.setAddr(rs.getString(4));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return member;
	};
	
	@Override
	public List<MemberVo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
