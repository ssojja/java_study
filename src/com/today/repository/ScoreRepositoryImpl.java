package com.today.repository;

import java.util.ArrayList;
import java.util.List;

import com.today.model.Member;

import db.DBconn;
import db.GenericRepositoryInterface;

public class ScoreRepositoryImpl extends DBconn
	implements GenericRepositoryInterface<Member>{
	
	public ScoreRepositoryImpl() {
		super();
	}

	@Override
	public int insert(Member member) {
		int rows = 0;
		String sql = "insert into score_member(name, department, kor, eng, math, mdate) values("
				+ "?,?,?,?,?, curdate())";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getDepartment());
			pstmt.setInt(3, member.getKor());
			pstmt.setInt(4, member.getEng());
			pstmt.setInt(5, member.getMath());		
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	};
	
	@Override
	public int getCount() {
		int rows = 0;
		String sql = "select count(*) from score_member";
		
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs != null) rows = rs.getInt(1);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public List<Member> findAll() {
		List<Member> list = null;
		String sql = "select mid, name, department, kor, eng, math, mdate from score_member";
		
		try {
			getPreparedStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs != null) {
				list = new ArrayList<Member>();
				while(rs.next()) {
					Member member = new Member();
					member.setNo(rs.getString(1));
					member.setName(rs.getString(2));
					member.setDepartment(rs.getString(3));
					member.setKor(rs.getInt(4));
					member.setEng(rs.getInt(5));
					member.setMath(rs.getInt(6));
					list.add(member);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	};
	
	@Override
	public Member find(String no) {
		Member member = null;
		String sql = "select mid, name, department, kor, eng, math, mdate from score_member "
				+ "where mid = ?";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setNo(rs.getString(1));
				member.setName(rs.getString(2));
				member.setDepartment(rs.getString(3));
				member.setKor(rs.getInt(4));
				member.setEng(rs.getInt(5));
				member.setMath(rs.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public int remove(String mid) {
		int rows = 0;
		String sql = " delete from score_member where mid = ?";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, mid);
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rows;
		
		
	}

	@Override
	public int update(Member member) {
		int rows = 0;
		String sql = "update score_member set kor = ?, eng = ?, math = ? where mid = ?";
		
		try {
			getPreparedStatement(sql);
			
			pstmt.setInt(1, member.getKor());
			pstmt.setInt(2, member.getEng());
			pstmt.setInt(3, member.getMath());
			pstmt.setString(4, member.getNo());
			rows = pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rows;
	};
	
}
