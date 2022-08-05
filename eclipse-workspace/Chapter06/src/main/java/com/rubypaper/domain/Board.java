package com.rubypaper.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Board {
	@Id @GeneratedValue
	private int seq;
	private String title;
	
	@Column(updatable = false)
	private String writer;	
	
	private String content;
	private Date regDate = new Date();
	private int cnt = 0;
}





