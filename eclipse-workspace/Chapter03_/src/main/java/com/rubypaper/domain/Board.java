package com.rubypaper.domain;

import java.util.Date;

import lombok.Data;

// 1. Entity 클래스
@Data
public class Board {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
}
