
<%@page import="sdj.login.LoginDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.js"></script>



<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale='1'">
<link href="bootstrap-3.3.1/css/bootstrap.min.css" rel="stylesheet">

<meta charset="UTF-8">
<title>JSP 게시판 웹 사이트</title>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}
</style>
</head>
<body>


	<nav class="navbar navbar-inverse navbar-expand-md">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="mainhomepage.jsp">동동이</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="l_select.sdj">메인</a></li>
				<li><a href="sdj_list.sdj">게시판</a></li>
				<li><a href="calender.jsp">Calender</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="l_insertui.sdj"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>

				<c:if test="${empty login}">
					<li><a href="l_loginui.sdj"> <span
							class="glyphicon glyphicon-log-in"></span> Login
					</a></li>
				</c:if>

				<c:if test="${not empty login}">
					<li><a href="l_logout.sdj"> <span
							class="glyphicon glyphicon-log-out"></span> Logout
					</a></li>
				</c:if>

			</ul>
		</div>
	</nav>
	<div class="jumbotron text-center">
		<h1>Second Project</h1>
		<p>From ... 동동이</p>
	</div>
	<%
		LoginDTO login = (LoginDTO) session.getAttribute("login");
	%>
	<%
		if (login != null) {
	%>

	<%=login.getId()%>님이 로그인하셨습니다.
	<%
		} else {
	%>
	손님의 방문을 환영합니다.
	<%
		}
	%>
	<hr>


	<div class="container">
		<h2>회원 목록</h2>
		<p>회원 목록을 보려면 클릭하세요.</p>
		<button type="button" class="btn btn-info" data-toggle="collapse"
			data-target="#demo">Click</button>
		<div id="demo" class="collapse">
			<c:forEach items="${list}" var="dto">
				<c:if test="${not empty sessionScope.login}">
					<a href="l_selectById.sdj?id=${dto.id}">${dto.id} : ${dto.name}</a>
				</c:if>
				<br>
			</c:forEach>
		</div>
	</div>


</body>
</html>
