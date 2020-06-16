<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" initial-scale="1">
<title>JSP 웹사이트</title>
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/listboard.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand" href="home.kdh">KDH의 홈페이지</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbars01" aria-controls="navbars01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbars01">
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
	<div class="jumbotron">
		<form action="deletecommentboard.kdh" method="post">
			<input type="hidden" name="c_num" id="c_num" value="${param.c_num}" readonly="readonly"> 
			<p><b>비밀 번호를 입력하세요</b></p> 
			<input type="password" name="password" id="password">
			<button class="btn btn-success btn-lg" id="checker">삭제</button>
			<a class="btn btn-danger btn-lg" href="readboard.kdh?num=${num}" role="button">취소</a>
		</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#checker").click(function(event) {
				event.preventDefault();
				var password = $("#password").val();
				var c_num = $("#c_num").val();
				$.ajax({
					type : "post",
					url : "commentpasswordcheck.kdh",
					data : {
						password : password,
						c_num : c_num
					},
					dataType : "text",
					success : function(result) {
						alert(result);
					}
				});
			});
		});
	</script>
</body>
</html>