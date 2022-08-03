create table board(
	seq number(5) primary key,
	title varchar(200) not null,
	writer varchar(20) not null,
	content varchar(2000) not null,
	regdate date default current_date,
	cnt number(5) default 0
);

insert into board(seq, title, writer,content)
values(1, '가입인사', '테스터', '잘 부탁드립니다.');

insert into board(seq, title, writer,content)
values(2, 'HelloWorld', '테스터', 'HelloWorld 프로그램');
