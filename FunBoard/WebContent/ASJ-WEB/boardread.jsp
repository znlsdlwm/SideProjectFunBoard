<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
  
<!DOCTYPE html>
<html lang ="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="./ASJ-WEB/css/bootstrap.min.css" rel="stylesheet">
<link href="./css/custom.css" rel="stylesheet">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>

</head>

<style>
.jumbotron {
	background-color: #f4511e; /* Orange */
	color: #ffffff;
}
.jb-main {
	font-size: xxx-large;
	font-family:
}

</style>
<body>

	<div class="jumbotron text-center">
		<h1>여행일지</h1>
		<p>where are you going now?</p>
		<form class="form-inline">
			<div class="input-group">
				<input type="email" class="form-control" size="50"
					placeholder="나라검색" required>
				<div class="input-group-btn">
					<button type="button" class="btn btn-danger">search</button>
				</div>
			</div>
		</form>
	</div>
	<div class="container-fluid text-center bg-main">

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="home.asj">Time</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="main.asj">Home</a></li>
					<li><a href="list.asj">page 1</a></li>
					<li><a href="filelist.asj">page 2</a></li>
					<li><a href="adminlist.asj">page 3</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href=${empty login ? 'loginui.asj':'logout.asj'}>${empty login? '로그인':'로그아웃' }</a></li>
					<li><a href="insertui.asj">회원가입</a></li>
					<li><a href=${empty admin_login ? 'adminloginui.asj':'info.asj'}>회원정보</a></li>
				</ul>
			</div>
		</nav>
	</div>
	
	
	<h4>이름:${dto.num}</h4>
	<h4>글쓴이:${dto.writer}</h4>
	<hr>
	<h3>내용:</h3><br>${dto.content}<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<hr>
	<hr>
	<button type = "button" onclick="location.href='boardreplyui.asj?num=${dto.num}'" class="btn btn-primary">댓글달기</button>
	<br>
	<br>
	<br>
	<div class = "btn-group">
	<button type = "button" onclick="location.href='boardupdateui.asj?num=${dto.num}'" class="btn btn-primary">수정</button>
	<button type = "button" onclick="location.href='boarddelete.asj?num=${dto.num}'" class="btn btn-primary">삭제</button>
	<button type = "button" onclick="location.href='list.asj'" class="btn btn-primary">목록</button>

	</div>
	
	</div>
	
	
</body>
</html>