package com.today.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
		this.scan = sms.scan;
	}
	
	public List createMemberInfo() {
		String[] labels = {"학생명", "전공", "국어", "영어", "수학"};
		List memberInfo = new ArrayList();
		Random rd = new Random();
		// 학번 생성
		String no = "2025-" + rd.nextLong(1000, 9999); // 1000 ~ 9999
		memberInfo.add(no);
		for(int i = 0; i < labels.length; i++) {
			System.out.print(labels[i] + " > ");
			if(i >= 2) {
				memberInfo.add(scan.nextInt());
			} else {
				memberInfo.add(scan.next());
			}
		}
		return memberInfo;
	}
	
	public void register() {
		List memberInfo = createMemberInfo();
		
		Member member = new Member();
		member.setNo((String)memberInfo.get(0));
		member.setName((String)memberInfo.get(1));
		member.setDepartment((String)memberInfo.get(2));
		member.setKor((int)memberInfo.get(3));
		member.setEng((int)memberInfo.get(4));
		member.setMath((int)memberInfo.get(5));
		
		// 저장소 등록을 위한 Repository 호출!
		if(repository.insert(member)) System.out.println("=> 등록 완료!");
		else System.out.println("=> 등록 실패");
		
		// 메인메뉴 호출!
		sms.showMenu();
		sms.selectMenu();
	};
	
	public void list() {
		
		if(getCount() != 0) {
			List<Member> list = repository.findAll();
			System.out.println("===========================================================");
			System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
			System.out.println("===========================================================");
			list.forEach((member) ->{
				System.out.print(member.getNo() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getDepartment() + "\t");
				System.out.print(member.getKor() + "\t");
				System.out.print(member.getEng() + "\t");
				System.out.print(member.getMath() + "\n");
			});
			System.out.println("===========================================================");
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		
		// 메인메뉴 호출!
		sms.showMenu();
		sms.selectMenu();
		
	};
	public void search() {
		if(getCount() != 0) {
			System.out.print("학번 뒤 4자리 입력 > ");
			String no = scan.next();
			Member member = repository.find(no);
			if(member != null) {
				System.out.println("===========================================================");
				System.out.println("\t\t 학생 정보 검색 결과");
				System.out.println("===========================================================");
				System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
				System.out.println("===========================================================");
				System.out.print(member.getNo() + " \t");
				System.out.print(member.getName() + " \t");
				System.out.print(member.getDepartment() + " \t");
				System.out.print(member.getKor() + " \t");
				System.out.print(member.getEng() + " \t");
				System.out.print(member.getMath() + " \n");
				System.out.println("===========================================================");				
			} else {
				System.out.println("=> 검색된 학생 정보 없음");
			}
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		
		// 메인메뉴 호출!
		sms.showMenu();
		sms.selectMenu();
	};
	
	public void update() {};
	public void delete() {};
	public void exit() {
		System.out.println("-- 프로그램 종료 --");
		System.exit(0);
	};
	public int getCount() {
		return repository.getCount();
	};
}
