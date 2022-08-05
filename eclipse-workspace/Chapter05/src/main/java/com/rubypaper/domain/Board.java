package com.rubypaper.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "member")
@Entity
public class Board {
	@Id @GeneratedValue
	private int seq;
	private String title;	
	//private String writer;	
	private String content;
	private Date regDate = new Date();
	private int cnt = 0;
	
	// 게시글 : 회원은 다대일 관계
	@ManyToOne(fetch = FetchType.LAZY)
	// @JoinCoumn이 설정된 객체의 식별자 필드 값이 MEMBER_ID 칼럼에 자동으로 등록
	@JoinColumn(name = "MEMBER_ID")
	private Member member;
}





