<%@page import="com.microsoft.kdh.domain.PageTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="./home.kdh">메인으로</a>
<hr>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>글쓴이</th>
			<th>작성시간</th>
			<th>조회수</th>
			<th>repRoot</th>
			<th>repStep</th>
			<th>repIndent</th>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.num}</td>
				<td>${dto.title}</td>
				<td>${dto.writer}</td>
				<td>${dto.writeDay}</td>
				<td>${dto.readcnt}</td>
				<td>${dto.repRoot}</td>
				<td>${dto.repStep}</td>
				<td>${dto.repIndent}</td>
			</tr>
		</c:forEach>
	</table>
	<a>&laquo;</a>
		<c:forEach begin="${to.beginPageNum}" end="${to.stopPageNum}" var="idx">
				<a href="listpage.kdh?curPage=${idx}">${idx}</a>&nbsp;&nbsp;
		</c:forEach>
	<a>&raquo;</a>
</body>
</html>