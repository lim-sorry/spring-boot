package com.rubypaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.Board;
import com.rubypaper.service.BoardService;

//@Controller
@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return boardService.hello(name);
	}
	
	@GetMapping("/getBoard/{seq}")
	public Board getBoard(@PathVariable("seq") int seq) {
		return boardService.getBoard(seq);
	}
	
	@GetMapping("/getBoardList")
	public List<Board> getBoardList() {
//		List<Board> boardList = new ArrayList<Board>();
//		for (int i=1; i<= 5; i++) {
//			Board board = new Board();
//			board.setSeq(i);
//			board.setTitle("임시 제목" + i);
//			board.setWriter("테스터");
//			board.setContent("임시 내용,,,,,,,," + i);
//			board.setRegDate(new Date());
//			board.setCnt(0);
//			boardList.add(board);
//		}
		return boardService.getBoardList();
	}
}
