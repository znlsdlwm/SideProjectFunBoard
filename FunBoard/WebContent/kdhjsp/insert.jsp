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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<style type="text/css">
input {
	text-align: right;
}
</style>
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
		<div class="container">
			<h1 class="display-4">회원가입</h1>

			<form action="insert.kdh" class="needs-validation" novalidate>
				<div class="form-group form-inline">
					<label for="id">ID:</label> <input type="text"
						class="form-control" id="id" placeholder="Enter username"
						name="id" required>
					<button id="checker" class="btn btn-outline-success btn-md">ID 중복체크</button>
					<p></p>
				</div>
				
				<div class="form-group form-inline">
					<label for="pw">PW:</label> <input name="pw"
							type="password" class="form-control" id="pw"
							placeholder="Enter Your Password" required>
				</div>

				<div class="form-group form-inline">
					<label for="name">Name: </label><input name="name"
							type="text" class="form-control" id="name"
							placeholder="Enter Your name" required>
				</div>
				<div class="form-group form-inline">
						<label for="age">Age: </label><input name="age"
							type="text" class="form-control" id="uname"
							placeholder="Enter Your Age" required>
					</div>
				<input type="submit" class="btn btn-success" value="회원가입">
			</form>
			
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#checker").click(function(event) {
				event.preventDefault();
				var id = $("#id").val();
				$.ajax({
					type : "get",
					url : "logidcheck.kdh",
					data : {
						id : id
					},
					dataType : "text",
					success : function(result) {
						$("p").text(result);
					}
				});
			});
		});
	</script>
</body>
</html>