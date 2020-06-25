
<%@page import="ASJ.domain.asjDTO"%>
<%@page import="ASJ.dao.asjDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width-device-width, initial-scale=1">
<title>Insert title here</title>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/custom.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</head>
<style type="text/css">

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
		<h1 class="glyphicon glyphicon-plane">Trip!</h1>
		<p>where are you going now?</p>
		<form class="form-inline">
			<div class="input-group-btn">
				<button type="button" onclick="location.href='home.asj'"
					class="btn btn-danger">home!!</button>
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
					<li><a href=${empty login ? 'loginui.asj':'logout.asj'}>${empty login? '로그인':'로그아웃'}</a></li>
					<li><a href="insertui.asj">회원가입</a></li>
					<li><a href=${empty admin_login ? 'adminloginui.asj':'info.asj'}>회원정보</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="container">
		<h1>글작성</h1>
		<form action="boardinsert.asj" method="post">
			<label for="writer">ID:</label> <input name="writer"
				value="${login.id}"><br> <label for="title">제목:</label>
			<input name="title"><br> 내용:<br>
			<textarea rows="10" cols="100" name="content"></textarea>
			<br> <input type="submit" value="저장">
		</form>
	</div>


</body>
</html>