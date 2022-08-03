package com.rubypaper.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rubypaper.domain.Board;

//@Repository
public class BoardDAOMyBatis {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(Board board) {
		mybatis.insert("insertBoard", board);
	}
	
	public List<Board> getBoardList() {
		return mybatis.selectList("getBoardList");
	}
}
