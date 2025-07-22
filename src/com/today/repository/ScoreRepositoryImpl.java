package com.today.repository;

import java.util.ArrayList;
import com.today.model.Member;

public class ScoreRepositoryImpl implements ScoreRepository{
	
	ArrayList<Member> storage = new ArrayList<Member>();
	
	public void insert(Member member) {
		
	};
	
	public int getCount() {
		return storage.size();
	}
	
}
