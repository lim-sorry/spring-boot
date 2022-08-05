package com.rubypaper.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

// 1. Entity 클래스
@Entity // JPA는 @Entity가 설정된 객체만 관리한다.(필수)
@Data
//@TableGenerator(name = "BOARD_SEQ_GENERATOR", table = "SEQUENCE_TABLE", initialValue = 0, allocationSize = 1)
//@SequenceGenerator(name = "BOARD_SEQ_GENERATOR", sequenceName = "BOARD_SEQUENCE", initialValue = 1, allocationSize = 1)
public class Board {
	// @Id : 식별자 변수(PK와 매핑된 변수)에 설정해야 한다.(필수)
	// @GeneratedValue : 1부터 1씩 자동으로 증가시키는 기능을 제공한다.
	@Id
	@GeneratedValue//(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate = new Date();
	private int cnt = 0;
}
