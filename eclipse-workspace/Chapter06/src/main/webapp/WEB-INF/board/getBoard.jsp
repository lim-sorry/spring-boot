<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 등록</title>
</head>
<body>
<center>
	<h1>게시글 상세 화면</h1>
	<form action="updateBoard" method="post">
	<input type="hidden" name="seq" value="${board.seq }"/>
	<table border="1" cellpadding="0" cellspacing="0" width="500">
		<tr>
			<td bgcolor="orange">제목</td>
			<td><input name="title" value="${board.title }"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">작성자</td>
			<td><input name="writer" value="${board.writer }"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">내용</td>
			<td><textarea name="content" cols="50" rows="5">${board.content }</textarea></td>
		</tr>
		<tr>
			<td bgcolor="orange">등록일</td>
			<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">조회수</td>
			<td>${board.cnt }</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<input type="submit" value="게시글 수정">
			</td>
		</tr>
	</table>	
	</form>
	<hr>
	<a href="insertBoard">글등록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard?seq=${board.seq }">글삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList">글목록</a>
</center>
</body>
</html>









