<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>BoardList</title>
	</head>
	<body>
		<h2>Article List</h2>
		<table>
			<tr>
				<th>no</th>
				<th>writer</th>
				<th>title</th>
				<th>content</th>
				<th>confer</th>
			</tr>
			
			<c:forEach var="good" items="${boardList }" varStatus="num">
				<tr>
					<td>${num.index +1}</td>
					<td>${good.name }</td>
					<td>${good.title }</td>
					<td>${good.content }</td>
					<!-- 
					1. boardDelete로 삭제 처리
					2. 삭제 후 목록화면으로 리다이렉트하세요.
					 -->
					
					<td><input type="button" value="delete" onclick="location.href='boardDelete?num=${good.num}'"></td>
				</tr>
			</c:forEach>
		</table>
		<!-- 게시글 작성페이지로 이동 -->
		<a href="boardRegister">게시글 작성</a>
		
	</body>
</html>