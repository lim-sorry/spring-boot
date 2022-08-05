package com.rubypaper.service;

import java.util.List;

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

	public void run(ApplicationArguments args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager jpa = emf.createEntityManager();

		// JPQL(JPA Query Language) 선언
		String jpql = "select b from Board b order by b.seq desc";
		List<Board> boardList = jpa.createQuery(jpql, Board.class).getResultList();
		for (Board board : boardList) {
			System.out.println("---> " + board.toString() );
		}

		jpa.close();
		emf.close();
	}

	/*
	 * Remove Test public void run(ApplicationArguments args) throws Exception {
	 * EntityManagerFactory emf =
	 * Persistence.createEntityManagerFactory("Chapter04"); EntityManager jpa =
	 * emf.createEntityManager();
	 * 
	 * EntityTransaction tx = jpa.getTransaction(); tx.begin();
	 * 
	 * Board board = jpa.find(Board.class, 1); jpa.remove(board);
	 * 
	 * tx.commit();
	 * 
	 * jpa.close(); emf.close(); }
	 */

	/*
	 * Update Test public void run(ApplicationArguments args) throws Exception {
	 * EntityManagerFactory emf =
	 * Persistence.createEntityManagerFactory("Chapter04"); EntityManager jpa =
	 * emf.createEntityManager();
	 * 
	 * EntityTransaction tx = jpa.getTransaction(); tx.begin();
	 * 
	 * Board board = jpa.find(Board.class, 1); board.setTitle("---수정 제목");
	 * board.setContent("---수정 내용");
	 * 
	 * tx.commit();
	 * 
	 * jpa.close(); emf.close(); }
	 */

	/*
	 * Select One Test public void run(ApplicationArguments args) throws Exception {
	 * EntityManagerFactory emf =
	 * Persistence.createEntityManagerFactory("Chapter04"); EntityManager jpa =
	 * emf.createEntityManager();
	 * 
	 * Board board = jpa.find(Board.class, 1); System.out.println("검색된 게시글 : " +
	 * board.toString());
	 * 
	 * jpa.close(); emf.close(); }
	 */

	/*
	 * Insert Test public void run(ApplicationArguments args) throws Exception { //
	 * EntityManagerFactory 생성 // persistence.xml 파일에 Chapter04로 등록된
	 * persistence-unit 설정을 로딩한다. EntityManagerFactory emf =
	 * Persistence.createEntityManagerFactory("Chapter04"); // EntityManager(JPA 객체)
	 * 생성 EntityManager jpa = emf.createEntityManager();
	 * 
	 * // Transaction 획득 EntityTransaction tx = jpa.getTransaction(); tx.begin(); //
	 * tx 시작
	 * 
	 * Board board = new Board(); board.setTitle("JPA 테스트"); board.setWriter("테스터");
	 * board.setContent("JPA 테스트중입니다..."); // JPA에 생성된 Entity를 등록한다.
	 * jpa.persist(board);
	 * 
	 * tx.commit(); // tx 종료
	 * 
	 * jpa.close(); emf.close(); }
	 */
}
