package com.today.repository;

import java.util.List;

import com.today.model.Member;

public interface ScoreRepository {
	
	boolean insert(Member member);
	int getCount();
	List<Member> findAll();
	Member find(String no);

}
