package com.rubypaper.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;

// 4. Service 구현 클래스
@Service
public class BoardServiceRunnerWithJPA implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// EntityManagerFactory 생성
		// persistence.xml 파일에 Chapter04로 등록된 persistence-unit 설정을 로딩한다.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		
		// EntityManager(JPA 객체) 생성
		EntityManager jpa = emf.createEntityManager();
		
		// Transaction 획득
		EntityTransaction tx = jpa.getTransaction();
		tx.begin(); // tx 시작
		
		Board board = new Board();
		board.setTitle("Mybatis 테스트");
		board.setWriter("테스터");
		board.setContent("Mybatis 테스트중입니다...");
		// JPA에 생성된 Entity를 등록한다.
		jpa.persist(board);
		
		tx.commit(); // tx 종료

//		List<Board> boardList = boardDAO.getBoardList();
//		for (Board data : boardList) {
//			System.out.println("---> " + data.toString());
//		}
	}
}
