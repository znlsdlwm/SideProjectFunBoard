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
<link rel="stylesheet" href="./css/listboard.css">
<link rel="stylesheet" href="../css/bootstrap.css">
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
		<h1 class="listBoardHome">게시글 작성</h1>
		<form action="insertboard.kdh" method="post">
			<input type="text" readonly="readonly" value="${login.id}"><br>
			<br> <input class="col-sm-4" type="text" name="title"
				placeholder="제목을 입력해 주세요." required="required"> <br>
			content: <br>
			<textarea class="col-sm-4" rows="10" name="content"></textarea>
			<br> <input type="submit" value="전송"
				class="btn btn-primary btn-lg"> <a href="listboard.kdh"
				role="button" class="btn btn-info btn-lg">목록으로</a>
		</form>
	</div>
</body>
</html>