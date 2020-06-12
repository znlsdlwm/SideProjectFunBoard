<%@page import="sdj.login.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<c:if test="${empty login}">
		<a href="l_loginui.sdj"> 로그인 </a><br>
	</c:if>
	<c:if test="${not empty login}">
		<a href="l_logout.sdj"> 로그아웃 </a><br>
	</c:if>

	
	<a href="l_insertui.sdj">회원 가입</a><br>
	
	
	<a href="sdj_list.sdj">게시판</a><br>
	<br><br>
	
	
	<h2>회원목록</h2>
	<c:forEach items="${list}" var="dto">
		<a href="l_selectById.sdj?id=${dto.id}">${dto.id} : ${dto.name}</a>
		<br>

	</c:forEach>
	
</body>	
</html>