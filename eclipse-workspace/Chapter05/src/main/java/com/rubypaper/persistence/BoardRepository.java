package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rubypaper.domain.Board;

//@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

	// 쿼리 메소드 작성
	// SELECT b FROM Board b WHERE b.title = ?
	List<Board> findByTitle(String searchKeyword);

	List<Board> findByContentContaining(String searchKeyword);

	List<Board> findByTitleContainingOrContentContaining(String title, String content);

	List<Board> findByTitleContainingOrderBySeqDesc(String title);

	// Page 객체는 웹 화면에서 페이징 결과를 사용할 때, 다양한 정보들을 제공한다.
	Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);

	//@Query("select b.seq, b.title, b.writer, b.regDate from Board b where b.title like %:keyword% order by b.seq desc")
	//List<Object[]> getBoardList(@Param("keyword") String searchKeyword);

	//@Query(value = "select seq, title, writer, content, reg_date, cnt from board where title like '%'||:keyword||'%' order by seq desc", nativeQuery = true)
	//List<Object[]> getBoardListNativeQuery(@Param("keyword") String searchKeyword);
}
