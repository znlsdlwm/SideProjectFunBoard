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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
		<h1 class="text-center">부트 스트랩 연습</h1>
		<p class="text-center">다양한 연습</p>
		<c:if test="${not empty login}">
			<h1 class="display-4">${login.id}님환영합니다.</h1>
		</c:if>
		<c:if test="${empty login}">
			<h1 class="display-4">KDH의 메인 홈 입니다.</h1>
		</c:if>
		<p class="lead">이 사이트는 기본적으로 JSP와 Bootstrap을 이용하여 만들었습니다.</p>
		<a class="btn btn-primary btn-lg" href="insertui.kdh" role="button">회원가입</a>
		<br>
		<br>
		<br>
		<br> <br> <a href="home.main">모두의 메인으로</a>
	
	<div class="jumbotron container display-flex">
			<div class="col-sm-6">
				<h2>가장 높은 조회수 게시글</h2>
				<table border="1" class="table table-striped table-hover board_list">
					<colgroup>
				        <col width="*"/>
				        <col width="18%"/>
				        <col width="18%"/>
				        <col width="10%"/>
				        <col width="10%"/>
				    </colgroup>
				    <thead>
						<tr>
							<th>글제목</th>
							<th>글쓴이</th>
							<th>조회수</th>
							<th><span class="material-icons">thumb_up</span></th>
							<th><span class="material-icons">thumb_down</span></th>
						</tr>
				    </thead>
					<tbody>
						<c:forEach items="${readcnt}" var="dto">
							<tr>
								<td class="title" width="300px">
									<a href="readboard.kdh?num=${dto.num}">${dto.title}</a></td>
								<td>${dto.writer}</td>
								<td>${dto.readcnt}</td>
								<td>${dto.b_good_total}</td>
								<td>${dto.b_bad_total}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			
			</div>
			<div class="col-sm-6">
			<h2>추천수 가장 높은 게시글</h2>
			<table border="1" class="table table-striped table-hover board_list">
				 <colgroup>
			        <col width="*"/>
			        <col width="18%"/>
			        <col width="18%"/>
			        <col width="10%"/>
			        <col width="10%"/>
			    </colgroup>
			    <thead>
					<tr>
						<th>글제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th><span class="material-icons">thumb_up</span></th>
						<th><span class="material-icons">thumb_down</span></th>
					</tr>
			    </thead>
				<tbody>
					<c:forEach items="${best}" var="dto">
						<tr>
							<td class="title" width="300px">
								<a href="readboard.kdh?num=${dto.num}">${dto.title}</a></td>
							<td>${dto.writer}</td>
							<td>${dto.readcnt}</td>
							<td>${dto.b_good_total}</td>
							<td>${dto.b_bad_total}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			</div>
		</div>
		</div>
</body>
</html>