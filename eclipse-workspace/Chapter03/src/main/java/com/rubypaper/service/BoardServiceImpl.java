package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

// 4. Service 구현 클래스
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	public BoardServiceImpl() {
		System.out.println("===> BoardServiceImpl 생성");
	}

	public String hello(String name) {
		return "hello : " + name;
	}

	public Board getBoard(int seq) {
		return boardRepository.getBoard(seq);
	}

	public List<Board> getBoardList() {
		return boardRepository.getBoardList();
	}
}
