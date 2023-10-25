<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글 등록 페이지(boardRegister.jsp)</title>
	</head>
	<body>
		<h2>게시글 등록(화면 url요청: contextpath/service/boardRegister.jsp)</h2>
		<form action="boardForm" method="post">
			작성자: <input type="text" name="name"><br>
			제목:	 <input type="text" name="title"><br>
			내용: <textarea rows="3" name="content"></textarea><br>
			
			<input type="submit" value="regist">
			<input type="button" value="list" onclick="location.href='boardDelete.jsp'">
		</form>
	</body>
</html>