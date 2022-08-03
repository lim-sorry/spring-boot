package com.rubypaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.Board;
import com.rubypaper.service.BoardService;

@RestController
public class BoardController {
	
	// 반드시 Controller는 인터페이스를 통해서 비즈니스 컴포넌트를 호출해야 한다.2
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
		return boardService.getBoardList();
	}
}






















