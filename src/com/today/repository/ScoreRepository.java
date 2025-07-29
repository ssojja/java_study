package com.today.repository;

import java.util.List;

import com.today.model.Member;

public interface ScoreRepository {
	
	public boolean insert(Member member);
	public int getCount();
	public List<Member> findAll();
	public Member find(String no);

}
