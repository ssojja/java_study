package com.today.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.scoremgm.model.MemberVo;
import com.today.app.ScoreMgmSystem;
import com.today.model.Member;
import com.today.repository.ScoreRepositoryImpl;

import db.GenericRepositoryInterface;

public class ScoreServiceImpl implements ScoreService{
	Scanner scan;
	ScoreMgmSystem sms;
	GenericRepositoryInterface<Member> repository = new ScoreRepositoryImpl();
	
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
	
	public List createMemberInfo(Member member) {
		String[] labels = {"국어", "영어", "수학"};
		List memberInfo = new ArrayList();
		// 학번 생성
		for(int i = 0; i < labels.length; i++) {
			System.out.print(labels[i] + " > ");
			memberInfo.add(scan.nextInt());
		}
		return memberInfo;
	}
	
	
	public void register() {
		List memberInfo = createMemberInfo();
		
		Member member = new Member();
		member.setName((String)memberInfo.get(0));
		member.setDepartment((String)memberInfo.get(1));
		member.setKor((int)memberInfo.get(2));
		member.setEng((int)memberInfo.get(3));
		member.setMath((int)memberInfo.get(4));
		
		// 저장소 등록을 위한 Repository 호출!
		if(repository.insert(member) == 1) System.out.println("=> 등록 완료!");
		else System.out.println("=> 등록 실패");
		
		// 메인메뉴 호출!
		sms.showMenu();
		sms.selectMenu();
	};
	
	public void list() {
		
		if(getCount() != 0) {
			List<Member> list = repository.findAll();
			if(list.size() != 0) {
				System.out.println("============================================");
				System.out.println("학번\t이름\t전공\t국어\t영어\t수학");
				System.out.println("============================================");
				list.forEach((member) ->{
					System.out.print(member.getNo() + "\t");
					System.out.print(member.getName() + "\t");
					System.out.print(member.getDepartment() + "\t");
					System.out.print(member.getKor() + "\t");
					System.out.print(member.getEng() + "\t");
					System.out.print(member.getMath() + "\n");
				});
				System.out.println("============================================");
				
			} else {
				System.out.println("=> 등록된 학생이 없습니다.");
			}
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		
		// 메인메뉴 호출!
		sms.showMenu();
		sms.selectMenu();
		
	};
	public void search() {
		if(getCount() != 0) {
			System.out.print("[검색] 학번 입력 > ");
			String no = scan.next();
			Member member = repository.find(no);
			if(member != null) {
				System.out.println("============================================");
				System.out.println("\t\t 학생 정보 검색 결과");
				System.out.println("=============================================");
				System.out.println("학번\t이름\t전공\t국어\t영어\t수학");
				System.out.println("=============================================");
				System.out.print(member.getNo() + " \t");
				System.out.print(member.getName() + " \t");
				System.out.print(member.getDepartment() + " \t");
				System.out.print(member.getKor() + " \t");
				System.out.print(member.getEng() + " \t");
				System.out.print(member.getMath() + " \n");
				System.out.println("=============================================");
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
	
	public void update() {
		if(getCount() != 0) {
			System.out.print("[수정] 학번 입력 >");
			String mid = scan.next();
			Member member = repository.find(mid);
			if(member != null) {
				List memberInfo = createMemberInfo(member);
				member.setKor((int)memberInfo.get(0));
				member.setEng((int)memberInfo.get(1));
				member.setMath((int)memberInfo.get(2));
				
				repository.update(member);
				
				System.out.println("=============================================");
				System.out.println("\t\t 학생 정보 수정 결과");
				System.out.println("=============================================");
				System.out.println("학번\t이름\t전공\t국어\t영어\t수학");
				System.out.println("=============================================");
				System.out.print(member.getNo() + " \t");
				System.out.print(member.getName() + " \t");
				System.out.print(member.getDepartment() + " \t");
				System.out.print(member.getKor() + " \t");
				System.out.print(member.getEng() + " \t");
				System.out.print(member.getMath() + " \n");
				System.out.println("=============================================");
				System.out.println("=> 업데이트 성공!!");
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
	public void delete() {
		if(getCount() != 0) {
			System.out.print("[삭제] 학번 입력 >");
			String mid = scan.next();
			
			Member member = repository.find(mid); 	// 학생 정보 - old
			
			if(member != null) {
				System.out.print("진정으로 삭제하시겠나요? (y: 삭제, 아무키: 종료됨) > ");
				if(scan.next().equals("y")) {
					repository.remove(mid);
					System.out.println("=> 삭제 완료");
				}
			}
			
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		
		sms.showMenu();
		sms.selectMenu();
	};
	public void exit() {
		System.out.println("-- 프로그램 종료 --");
		repository.close();
		System.exit(0);
	};
	public int getCount() {
		return repository.getCount();
	};
}
