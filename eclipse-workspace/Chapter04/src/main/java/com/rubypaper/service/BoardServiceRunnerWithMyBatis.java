package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardDAOMyBatis;

// 4. Service 구현 클래스
//@Service
public class BoardServiceRunnerWithMyBatis implements ApplicationRunner {

	@Autowired
	private BoardDAOMyBatis boardDAO;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Board board = new Board();
		board.setTitle("Mybatis 테스트");
		board.setWriter("테스터");
		board.setContent("Mybatis 테스트중입니다...");
		boardDAO.insertBoard(board);

		List<Board> boardList = boardDAO.getBoardList();
		for (Board data : boardList) {
			System.out.println("---> " + data.toString());
		}
	}
}
