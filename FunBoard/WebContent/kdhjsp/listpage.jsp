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
<a href="./insertboardui.kdh">글쓰기</a>
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
	<c:if test="${to.curPage>1}">
		<a href="listpage.kdh?curPage=${1}">처음으로</a>&nbsp;
	</c:if>
	<c:if test="${to.beginPageNum>1}">
		<a href="listpage.kdh?curPage=${to.curPage-to.perPage}">이전</a>&nbsp;
	</c:if>
		<c:forEach begin="${to.beginPageNum}" end="${to.stopPageNum}" var="idx">
				<a href="listpage.kdh?curPage=${idx}">${idx}</a>&nbsp;&nbsp;
		</c:forEach>
	<c:if test="${to.stopPageNum<to.totalPage}">
		<a href="listpage.kdh?curPage=${to.curPage+to.perPage}">다음</a>&nbsp;
	</c:if>
	<c:if test="${to.curPage<to.totalPage}">
		<a href="listpage.kdh?curPage=${to.totalPage}">끝으로</a>&nbsp;
	</c:if>
</body>
</html>