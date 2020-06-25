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
body{
background-color :#d4c78c;
}
</style>
<body>

	<div class="jumbotron text-center">
		<h1>여행일지</h1>
		<p>where are you going now?</p>
		<form class="form-inline">		
				<div class="input-group-btn">
					<button type="button" class="btn btn-danger">Home!</button>
				</div>
			</div>
		</form>
	</div>
	<div class="container-fluid text-center bg-main">

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand">웹페이지</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="main.asj">Home</a></li>
					<li><a href="list.asj">page 1</a></li>
					<li><a href="ASJ-WEB/filelist.jsp">page 2</a></li>
					<li><a href="adminlist.asj">page 3</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href=${empty admin_login ? 'adminloginui.asj':'adminlogout.asj'}>${empty admin_login ? '로그인':'로그아웃' }</a></li>
					<li><a href="insertui.asj">회원가입</a></li>
					<li><a href=${empty admin_login ? 'adminloginui.asj':'info.asj'}>회원정보</a></li>
				</ul>
			</div>
		</nav>
	</div>
	
	
	<h4>이름:${admin_dto.num}</h4>
	<h4>글쓴이:${admin_dto.writer}</h4>
	<hr>
	<h3>내용:</h3><br>${admin_dto.content}<br>
	<br>
	

	
	</div>
	
	
</body>
</html>