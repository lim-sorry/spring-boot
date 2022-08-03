package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.Board;

//@Controller
@RestController
public class BoardController {
	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	//@RequestMapping(value="/hello", method=RequestMethod.GET)
	@GetMapping("/hello")
	//@ResponseBody
	public String hello(String name) {
		return "hello : " + name;
	}
	
	@GetMapping("/getBoard")
	public Board getBoard() {
		Board board = new Board();
		board.setSeq(1);
		board.setTitle("임시 제목");
		board.setWriter("테스터");
		board.setContent("임시 내용,,,,,,,,");
		board.setRegDate(new Date());
		board.setCnt(0);
		return board;
	}
	
	@GetMapping("/getBoardList")
	public List<Board> getBoardList() {
		List<Board> boardList = new ArrayList<Board>();
		for (int i=1; i<= 5; i++) {
			Board board = new Board();
			board.setSeq(i);
			board.setTitle("임시 제목" + i);
			board.setWriter("테스터");
			board.setContent("임시 내용,,,,,,,," + i);
			board.setRegDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		return boardList;
	}
}
