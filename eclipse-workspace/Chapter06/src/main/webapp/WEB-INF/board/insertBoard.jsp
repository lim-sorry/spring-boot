<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 등록</title>
</head>
<body>
<center>
	<h1>게시글 등록 화면</h1>
	<form action="insertBoard" method="post" enctype="multipart/form-data">
	<table border="1" cellpadding="0" cellspacing="0" width="500">
		<tr>
			<td bgcolor="orange">제목</td>
			<td><input name="title"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">작성자</td>
			<td><input name="writer"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">내용</td>
			<td><textarea name="content" cols="50" rows="5"></textarea></td>
		</tr>
		<tr>
			<td bgcolor="orange">업로드</td>
			<td><input type="file" name="uploadFile"/></td>
		</tr>		
		<tr>
			<td align="center" colspan="2">
				<input type="submit" value="게시글 등록">
			</td>
		</tr>
	</table>	
	</form>
</center>
</body>
</html>