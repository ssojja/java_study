package com.scoremgm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.scoremgm.app.ScoreMgmSystem;
import com.scoremgm.model.Member;
import com.scoremgm.repository.ScoreRepository;
import com.scoremgm.repository.ScoreRepositoryImpl;

public class ScoreServiceImpl implements ScoreService {
	Scanner scan;
	ScoreMgmSystem sms;
	ScoreRepository repository = new ScoreRepositoryImpl();
	
	public ScoreServiceImpl() {}
	public ScoreServiceImpl(ScoreMgmSystem sms) {
		this.sms = sms;
		this.scan = sms.scan;
	}
	
	/**
	 * 학생정보 저장소(storage)의 갯수 가져오기
	 * */
	@Override
	public int getCount() {
		return repository.getCount();
	}
	
	
	/**
	 * 등록
	 * */
	@Override
	public void register() {
		List memberInfo = createMemberInfo();
//		memberInfo.forEach(System.out::println);
		
		// Member 생성
		Member member = new Member();
		member.setNo((String)memberInfo.get(0));
		member.setName((String)memberInfo.get(1));
		member.setDepartment((String)memberInfo.get(2));
		member.setKor((int)memberInfo.get(3));
		member.setEng((int)memberInfo.get(4));
		member.setMath((int)memberInfo.get(5));

		// 저장소 등록을 위한 Repository 호출!
		if(repository.insert(member)) System.out.println("=> 등록 완료");
		else System.out.println("=> 등록 실패");
		
		// 메인메뉴 호출!
		sms.showMenu();
		sms.selectMenu();
	}
	
	/**
	 * 학생 정보 임시 저장
	 * @return List
	 * */
	public List createMemberInfo() {
		String[] labels = {"학생명", "전공", "국어", "영어", "수학"};
		List memberInfo = new ArrayList();
		Random rd = new Random();
		String no = "2025-" + rd.nextLong(1000, 9999);	// 학번 생성
		memberInfo.add(no);
		for(int i = 0; i < labels.length; i++) {
			if(i >= 2) {
				System.out.print(labels[i] +" > ");
				memberInfo.add(scan.nextInt());
			} else {
				System.out.print(labels[i] +" > ");
				memberInfo.add(scan.next());
			}
		}
		return memberInfo;
		
	}
	
	/**
	 * 학생 정보 조회
	 * */
	@Override
	public void list() {
		if(getCount() != 0) {
			List<Member> list = repository.findAll();
			System.out.println("===========================================================");
			System.out.println("학번\t\t이름\t\t전공\t국어\t영어\t수학");
			System.out.println("===========================================================");
			list.forEach((member) -> {
				System.out.print(member.getNo() + " \t");
				System.out.print(member.getName() + " \t");
				System.out.print(member.getDepartment() + " \t");
				System.out.print(member.getKor() + " \t");
				System.out.print(member.getEng() + " \t");
				System.out.print(member.getMath() + " \n");
			});
			System.out.println("===========================================================");
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		sms.showMenu();
		sms.selectMenu();
	}
	
	
	@Override
	public void search() {}
	@Override
	public void update() {}
	@Override
	public void delete() {}
	@Override
	public void exit() {
		System.out.println("-- 프로그램 종료 --");
		System.exit(0);
	}
}
