package com.rubypaper;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest {

	@Autowired
	private BoardRepository boardRepository;
	
//	//@Test
//	public void testNativeQuery() {
//		List<Object[]> boardList = boardRepository.getBoardListNativeQuery("테스트10");
//		
//		for (Object[] board : boardList) {
//			System.out.println("---> " + Arrays.toString(board));
//		}
//	}
	
//	//@Test
//	public void testQueryAnnotation() {
//		List<Object[]> boardList = boardRepository.getBoardList("테스트10");
//		
//		for (Object[] board : boardList) {
//			System.out.println("---> " + Arrays.toString(board));
//		}
//	}
	
	//@Test
	public void testQueryMethod() {
		// 페이징 처리
		Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
		Page<Board> pageInfo = boardRepository.findByTitleContaining("테스트1", pageable);
		
		System.out.println("검색된 전체 데이터 수 : " + pageInfo.getTotalElements());
		System.out.println("전체 페이지 수 : " + pageInfo.getTotalPages());
		System.out.println("한 페이지에 출력할 데이터 수 : " + pageInfo.getSize());
		System.out.println("-----------------------------------------------");
		System.out.println("현재 페이지 기준으로 이전 페이지가 있나? : " + pageInfo.hasPrevious());
		System.out.println("현재 페이지 기준으로 다음 페이지가 있나? : " + pageInfo.hasNext());
		System.out.println("현재 페이지가 첫번째 페이지인가? : " + pageInfo.isFirst());
		System.out.println("현재 페이지가 마지막 페이지인가? : " + pageInfo.isLast());
		System.out.println("-----------------------------------------------");
		
		for (Board board : pageInfo) {
			System.out.println("---> " + board.toString());
		}
	}

	//@BeforeEach
	public void testInsertBoard() {
		for (int i = 1; i <= 200; i++) {
			Board board = new Board();
			board.setTitle("JPA 테스트" + i);
			//board.setWriter("테스터" + i);
			board.setContent("스프링부트와 JPA 연동" + i);
			board.setRegDate(new Date());
			board.setCnt(0);
			boardRepository.save(board); 
		}
	}
}
