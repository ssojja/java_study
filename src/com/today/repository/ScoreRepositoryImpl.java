package com.today.repository;

import java.util.ArrayList;
import java.util.List;

import com.today.model.Member;

public class ScoreRepositoryImpl implements ScoreRepository{
	
	ArrayList<Member> storage = new ArrayList<Member>();
	
	public boolean insert(Member member) {
		if(member == null) return false;
		return storage.add(member);
	};
	
	public int getCount() {
		return storage.size();
	}
	
	public List<Member> findAll() {
		return storage;
	};
	
	public Member find(String no) {
		no = "2025-"+ no;
		Member member = null;
		
		System.out.println("no > " + no);
		if(no != null) {
//		for(int i = 0; i < storage.size(); i++) {
//			if(storage.get(i).getNo().equals(no)) {
//				member = storage.get(i);
//			}
//		}
			
			for(Member m : storage) {
				System.out.println("m.getNo() >" + m.getNo());
				if(m.getNo().equals(no)) {
					System.out.println("확인 !!!!!!!");
					member = m;
				}
			}			
		}

		return member;
	};
	
}
