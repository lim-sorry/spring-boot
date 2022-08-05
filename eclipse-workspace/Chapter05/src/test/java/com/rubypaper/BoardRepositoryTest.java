package com.rubypaper;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepository;
	
	//@Test
	public void testDeleteBoard() {
		boardRepository.deleteById(1);
	}
	
	//@Test
	public void testUpdateBoard() {
		Board board = new Board();
		board.setSeq(1);
		board.setTitle("---수정 제목");
		//board.setWriter("익명");
		board.setContent("---수정 내용");
		board.setRegDate(new Date());
		board.setCnt(100);
		boardRepository.save(board); // 수정할 때도 save()를 사용
	}
	
	//@Test
	public void testGetBoard() {
//		Optional<Board> result = boardRepository.findById(1);
//		if(result.isPresent()) {
//			Board board = result.get();
//			System.out.println("검색 결과 : " + board.toString());
//		}
		
		Board board = boardRepository.findById(1).get();
		System.out.println("검색 결과 : " + board.toString());
	}
	
	//@Test
	public void testInsertBoard() {
		Board board = new Board();
		board.setTitle("JPA 테스트");
		//board.setWriter("테스터");
		board.setContent("스프링부트와 JPA 연동");
		boardRepository.save(board); // save() == persist() 하지만 수정할 때도 save()를 사용
	}
}
