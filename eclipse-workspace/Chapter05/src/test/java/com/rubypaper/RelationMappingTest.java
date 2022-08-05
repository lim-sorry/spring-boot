package com.rubypaper;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.MemberRepository;

@SpringBootTest
public class RelationMappingTest {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void testDelete() {
		// Board 엔티티 상세 조회
		Member member = memberRepository.findById("member2").get();
		memberRepository.delete(member);
	}	
	
	//@Test
	public void testOneToMany() {
		// Board 엔티티 상세 조회
		Member member = memberRepository.findById("member2").get();
		System.out.println("[ " + member.getName() + "가 등록한 게시글 목록 ]");
		List<Board> boardList = member.getBoardList();
		for (Board board : boardList) {
			System.out.println("---> " + board.getSeq() + " : " + board.getTitle());
		}
	}

	// @Test
	public void testManyToOne() {
		// Board 엔티티 상세 조회
		Board board = boardRepository.findById(1).get();
		System.out.println("[ " + board.getSeq() + "번 게시글 상세 정보 ]");
		System.out.println("제목 : " + board.getTitle());
		System.out.println("내용 : " + board.getContent());
		System.out.println("작성자 이름 : " + board.getMember().getName());
		System.out.println("작성자 권한 : " + board.getMember().getRole());
	}

	// @Test
	public void testInsertBoard() {
		Member member1 = new Member();
		member1.setId("member1");
		member1.setPassword("member111");
		member1.setName("둘리");
		member1.setRole("User");
		memberRepository.save(member1);

		Member member2 = new Member();
		member2.setId("member2");
		member2.setPassword("member222");
		member2.setName("또치");
		member2.setRole("Admin");
		memberRepository.save(member2);

		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setTitle("둘리 테스트" + i);
			board.setContent("둘리 테스트 내용" + i);
			board.setRegDate(new Date());
			board.setCnt(0);
			// 게시글 작성자 설정
			board.setMember(member1);
			boardRepository.save(board);
		}

		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setTitle("또치 테스트" + i);
			board.setContent("또치 테스트 내용" + i);
			board.setRegDate(new Date());
			board.setCnt(0);
			// 게시글 작성자 설정
			board.setMember(member2);
			boardRepository.save(board);
		}
	}
}
