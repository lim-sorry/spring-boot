package com.rubypaper.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "boardList")
@Entity
public class Member {
	@Id
	private String id;
	private String password;
	private String name;
	private String role;
	
	// 회원(Member)과 게시글(Board)는 다대일 관계
	// 다대일 관계는 @OneToMany를 사용하여 매핑한다.
	// mappedBy 속성은 연관관계의 주인이 아닌 참조변수에 설정한다.
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Board> boardList = new ArrayList<Board>();
}
