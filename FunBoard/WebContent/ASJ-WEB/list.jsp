<%@page import="ASJ.domain.asjDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
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

table{
width:100%;
border-top:1px solid #444444;
border-collapse: collapse;

}
th,tb{
border-bottom : 1px solid #444444;
pading: 10px;

}
thead tr {
    background-color: #a3a3a3;
    color: #ffffff;
  }
  tbody tr:nth-child(2n) {
    background-color: #ffffff;
  }
  tbody tr:nth-child(2n+1) {
    background-color: #d3d3d3;
  }
</style>
<body>

	<div class="jumbotron text-center">
		<h1 class="glyphicon glyphicon-plane">Trip!</h1>
		<p>where are you going now?</p>
		<form class="form-inline">
				<div class="input-group-btn">
					<button type="button" onclick="location.href='main.asj'" class="btn btn-danger">home!!</button>
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
	
	<h1>게시글</h1>
	<div align="right">
	<a href=${empty login ? 'loginui.asj':'boardinsertui.asj'} class="btn btn-info" role="button">글쓰기</a>	
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>num</th>
				<th>title</th>
				<th>writer</th>
				<th>writeday</th>
				<th>readcnt</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>

					<td>${dto.num}</td>
					<td width="300px"><c:forEach begin="0" end="${dto.repIndent}">
	 						&nbsp;&nbsp;
	 					</c:forEach> 
	 					<a href="boardread.asj?num=${dto.num}">${dto.title}</a></td>

					<td>${dto.writer}</td>
					<td>${dto.writeday}</td>
					<td>${dto.readcnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<ul class = "pagination">
	  <li><a href="list.asj?curPage=1">&laquo;&laquo;</a>&nbsp;&nbsp;</li>
	  <li><a href="list.asj?curPage=${(to.curPage-1) >0?(to.curPage-1):1}">&laquo;</a>&nbsp;&nbsp;</li>
	<style>
	a{text-decoration:none}
	</style>
	<li><c:forEach begin ="${to.beginPageNum}" end ="${to.stopPageNum}" var ="idx">
		<c:if test="${to.curPage == idx}">
			<a style = "font-size: 20px;"font-color=black;"href = "list.asj?curPage=${idx}">${idx}</a>&nbsp;&nbsp;
		</c:if>
		<c:if test="${to.curPage != idx}">
			<a href = "list.asj?curPage=${idx}">${idx}</a>&nbsp;&nbsp;
		</c:if>
	</c:forEach></li>
	<li><a href="list.asj?curPage=${(to.curPage+1) < to.totalPage?(to.curPage+1):to.totalPage}">&raquo;</a></li>
	<li><a href="list.asj?curPage=${to.totalPage}">&raquo;&raquo;</a></li>
	</ul>
	




</body>
</html>