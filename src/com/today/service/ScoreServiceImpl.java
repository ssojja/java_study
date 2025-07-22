package com.today.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.today.app.ScoreMgmSystem;
import com.today.model.Member;
import com.today.repository.ScoreRepository;
import com.today.repository.ScoreRepositoryImpl;

public class ScoreServiceImpl implements ScoreService{
	Scanner scan;
	ScoreMgmSystem sms;
	ScoreRepository repository = new ScoreRepositoryImpl();
	
	public ScoreServiceImpl() {}
	public ScoreServiceImpl(ScoreMgmSystem sms) {
		this.sms = sms;
		this.scan = scan;
	}
	
	public List createMemberInfo() {
		String[] labels = {"학생명", "전공", "국어", "영어", "수학"};
		List memberInfo = new ArrayList();
		return memberInfo;
	}
	
	public void register() {
		List memberInfo = createMemberInfo();

		
		
		
	};
	public void list() {};
	public void search() {};
	public void update() {};
	public void delete() {};
	public void exit() {
		System.out.println("-- 프로그램 종료 --");
		System.exit(0);
	};
	public int getCount() {
		return 0;
	};
}
