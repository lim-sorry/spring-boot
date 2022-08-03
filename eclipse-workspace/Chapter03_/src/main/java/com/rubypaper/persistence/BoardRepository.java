package com.rubypaper.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rubypaper.domain.Board;

// 2. Repository 클래스
@Repository
public class BoardRepository {
	
	@Autowired
	private JdbcTemplate spring;
	
	// BOARD 관련 SQL
	private String BOARD_GET  = "select * from board where seq = ?";
	private String BOARD_LIST = "select * from board order by seq desc";
	
	public BoardRepository() {
		System.out.println("===> BoardRepository 생성");
	}
	
	public Board getBoard(int seq) {
		System.out.println("BoardRepository--getBoard : " + seq);
		Object[] params = {seq};
		return spring.queryForObject(BOARD_GET, new BoardRowMapper(), params);
	}
	
	public List<Board> getBoardList() {
		return spring.query(BOARD_LIST, new BoardRowMapper());
	}
}
