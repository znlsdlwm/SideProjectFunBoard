<%@page import="ASJ.domain.asjDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="./ASJ-WEB/css/bootstrap.min.css" rel="stylesheet">
<link href="./css/custom.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<style>
.jb-main {
	font-size: xxx-large;
	font-family:
}
body{
background-color :#d4c78c;
}
.jumbotron {
	background-color: #f4511e; /* Orange */
	color: #ffffff;
}

img{
	width:200px;
	height:100px;
	margin: auto;
	display: block;
}

	
}
</style>
<body>
	<div class="jumbotron text-center">
		<h1 class="glyphicon glyphicon-plane">Trip!</h1>
		<p>where are you going now?</p>
		<form class="form-inline">
				<div class="input-group-btn">
					<button type="button"onclick="location.href='main.asj'" class="btn btn-danger">home!</button>
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

	<div class="container-fluld text-center">
		<div class="row">
			<div class="col-sm-6">
				<h2>자유게시판 이용하기</h2>
				<h4>free gallary</h4>
				<a href="list.asj" class="button btn btn-default btn-lg">let's
					go</a>
			</div>
			<div class="col-sm-6">
				<h2>이달의 추천 여행지</h2>
				<h4></h4>
				<a href="filelist.asj" class="button btn btn-default btn-lg">let's
					go</a>

			</div>
		</div>
	</div>
	


	
</body>


</body>
</html>