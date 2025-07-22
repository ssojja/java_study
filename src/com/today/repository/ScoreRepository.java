package com.today.repository;

import com.today.model.Member;

public interface ScoreRepository {
	
	public void insert(Member member);
	public int getCount();

}
