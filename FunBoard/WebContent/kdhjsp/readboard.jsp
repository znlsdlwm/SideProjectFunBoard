<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" initial-scale="1">
<title>JSP 웹사이트</title>
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<style type="text/css">
.fl{
float: left;
}
.fr{
float: right;
}
.btn{
margin-left: 3px;
width: 120px;
}
.listBoardHome:link{
text-decoration: none;
}
.listBoardHome{
font-size: 37px;
display: block;
    position: relative;
    top: -33px;
}
#listBoardHomeDiv{
height: 100px;
margin-bottom: 0px;
padding: 50px 24px 52px 18px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark" id="navbars01">
		<a class="navbar-brand" href="home.kdh">KDH의 홈페이지</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbars01" aria-controls="navbars01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<c:if test="${not empty login}">
					<li class="nav-item active"><a class="nav-link"
						href="logout.kdh">로그아웃</a></li>
				</c:if>
				<c:if test="${empty login}">
					<li class="nav-item active"><a class="nav-link"
						href="loginui.kdh">로그인</a></li>
				</c:if>
				<li class="nav-item"><a class="nav-link" href="insertui.kdh">회원가입</a></li>
				<li class="nav-item"><a class="nav-link" href="list.kdh">회원목록</a></li>
				<li class="nav-item"><a class="nav-link" href="listboard.kdh">게시판</a></li>
				<li class="nav-item"><a class="nav-link" href="calculator.kdh">계산기</a></li>
			</ul>
			<form class="form-inline my-2 my-md-0"
				action="listboard.kdh?query=${query}">
				<input class="form-control" name="query" type="text"
					placeholder="Search"> <input
					class="btn btn-outline-primary" type="submit" value="검색">
			</form>
		</div>
	</nav>
		<div class="jumbotron" id="listBoardHomeDiv">
		<a class="listBoardHome" href="listboard.kdh" role="button">기본 게시판</a>
	</div>
	<div class="jumbotron">
		<pre>
	<b>제목: ${dto.title} </b> 글번호: ${dto.num} 
	작성자: ${dto.writer} 작성날짜: ${dto.writeDay} 조회수: ${dto.readcnt}
	
	${dto.content}
	</pre>
	<a class="fl btn btn-info btn-lg" role="button" href="replyboardui.kdh?num=${dto.num}">답글</a>
	<a class="fl btn btn-info btn-lg" role="button" href="listboard.kdh">목록</a>
	<c:if test="${login.id eq dto.writer}">
		<a class="fr btn btn-secondary btn-lg" role="button" href="updateboardui.kdh?num=${dto.num}">수정</a>
		<a class="fr btn btn-secondary btn-lg" role="button" href="deleteboardui.kdh?num=${dto.num}">삭제</a>
	</c:if>
	</div>
	
</body>
</html>