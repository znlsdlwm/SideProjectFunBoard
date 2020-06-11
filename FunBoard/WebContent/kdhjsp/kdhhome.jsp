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
	<c:if test="${not empty login}">
		<h1>${login.id} 님 환영합니다.</h1>
	</c:if>
	<c:if test="${empty login}">
		<h1>KDH의 메인 홈 입니다.</h1>
	</c:if>
	<c:if test="${not empty login}">
		<a href="logout.kdh">로그아웃</a>
	</c:if>
	<c:if test="${empty login}">
		<a href="loginui.kdh">로그인</a>
	</c:if>
	<a href="insertui.kdh">회원가입</a>
	<a href="list.kdh">회원목록</a>
	<br>
	<br>
	<a href="calculator.kdh"> KDH의 계산기 </a><br>
	<a href="listboard.kdh"> 게시판 </a><br>

	<br>
	<br>
	<br>
	<br>
	<a href="home.main">모두의 메인으로</a>
</body>
</html>