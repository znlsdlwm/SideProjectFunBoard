<%@page import="member.domain.MemberDTO"%>
<%@page import="sdj.login.LoginDTO"%>
<%@page import="sdj.login.LoginCommand"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width; initial-scale=1">
<meta charset="UTF-8">
<link href="bootstrap-3.3.1/css/bootstrap.min.css" rel="stylesheet">

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


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="bootstrap-3.3.1/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="UTF-8">
<title>JSP 게시판 웹 사이트</title>
<style>
#container {
	width: 70%;
	margin: 0 auto; /* 가로로 중앙에 배치 */
	padding-top: 10%; /* 테두리와 내용 사이의 패딩 여백 */
}

#list {
	text-align: center;
}

#write {
	text-align: right;
}

/* Bootstrap 수정 */
.table>thead {
	background-color: #81848c;
}

.table>thead>tr>th {
	text-align: center;
}

.table-hover>tbody>tr:hover {
	background-color: #a4a7b0;
}

.table>tbody>tr>td {
	text-align: center;
}

.table>tbody>tr>#title {
	text-align: left;
}

.pagination {
	display: block;
	text-align: center;
}

.pagination>li>a {
	float: none;
	margin-left: -12px;
}

div>#paging {
	text-align: center;
}

.hit {
	animation-name: blink;
	animation-duration: 1.5s;
	animation-timing-function: ease;
	animation-iteration-count: infinite;
	/* 위 속성들을 한 줄로 표기하기 */
	/* -webkit-animation: blink 1.5s ease infinite; */
}

/* 애니메이션 지점 설정하기 */
/* 익스플로러 10 이상, 최신 모던 브라우저에서 지원 */
@
keyframes blink {
	from {color: white;
}

30%
{
color:yellow;
}
to {
	color: red;
	font-weight: bold;
}
/* 0% {color:white;}
      30% {color: yellow;}
      100% {color:red; font-weight: bold;} */
}
* {
	box-sizing: border-box;
}

/* Style the search field */
form.example input[type=text] {
	padding: 10px;
	font-size: 17px;
	border: 1px solid grey;
	float: left;
	width: 80%;
	background: #f1f1f1;
}

/* Style the submit button */
form.example button {
	float: left;
	width: 20%;
	padding: 10px;
	background: #2196F3;
	color: white;
	font-size: 17px;
	border: 1px solid grey;
	border-left: none; /* Prevent double borders */
	cursor: pointer;
}

form.example button:hover {
	background: #0b7dda;
}

/* Clear floats */
form.example::after {
	content: "";
	clear: both;
	display: table;
}
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



	<title>Insert title here</title>
</head>
<body>

	<br>
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


	<h1 align="center">게시글 목록</h1>
	<div>
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="10%">번호</th>
					<th width="50%">제목</th>
					<th width="10%">작성자</th>
					<th width="20%">작성일</th>
					<th width="10%">조회수</th>

				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td align="center">${dto.num}</td>

						<td width="250px"><c:forEach begin="1" end="${dto.repIndent}">
					&nbsp;&nbsp;[Re]
					</c:forEach> <a href="sdj_read.sdj?num=${dto.num}" align="center">${dto.title}</a></td>

						<td align="center">${dto.writer}</td>
						<td align="center">${dto.writeday}</td>
						<td align="center">${dto.readcnt}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

		<tr>
			<td colspan="7"><p align="center">
					<a href="l_select.sdj" align="center">초기화면</a>&nbsp;&nbsp;&nbsp;&nbsp;




				
		</tr>
		<c:if test="${not empty sessionScope.login}">
			<a href="sdj_insertui.sdj" align="center">글쓰기 </a>
			</td>
		</c:if>
		<!-- 
	<p align="center">
		<a href="sdj_list.sdj" align="center">[처음으로]</a>&nbsp;&nbsp; 
		
		<a href="sdj_list.sdj?curPage=${(to.curPage-1) > 0 ? (to.curPage-1) : 1}">&laquo;</a>&nbsp;&nbsp;

		<c:forEach begin="${to.beginPageNum}" end="${to.stopPageNum}" var="idx">
			<c:if test="${to.curPage == idx}">
				<a style="font-size: 20px;" href="sdj_list.sdj?curPage=${idx}">${idx}</a>&nbsp;&nbsp;
			</c:if>

			<c:if test="${to.curPage != idx}">
				<a href="sdj_list.sdj?curPage=${idx}">${idx}</a>&nbsp;&nbsp;			
			</c:if>
		</c:forEach>
		<a href="sdj_list.sdj?curPage=${(to.curPage+1) < to.totalPage? (to.curPage+1) : to.totalPage}">&raquo;</a>
	 -->


		<p align="center">
		<ul class="pagination">

			<li class="previous"><a href="sdj_list.sdj" align="center">처음</a>
				<a
				href="sdj_list.sdj?curPage=${(to.curPage-1) > 0 ? (to.curPage-1) : 1}">&laquo;&nbsp;</a></li>
			<li><c:forEach begin="${to.beginPageNum}"
					end="${to.stopPageNum}" var="idx">
					<c:if test="${to.curPage == idx}">
						<a style="font-size: 18px;" href="sdj_list.sdj?curPage=${idx}">${idx}</a>&nbsp;&nbsp;
				</c:if>

					<c:if test="${to.curPage != idx}">
						<a href="sdj_list.sdj?curPage=${idx}">${idx}</a>&nbsp;&nbsp;			
				</c:if>
				</c:forEach></li>
			<li class="next"><a
				href="sdj_list.sdj?curPage=${(to.curPage+1) < to.totalPage? (to.curPage+1) : to.totalPage}">&raquo;</a></li>

		</ul>
		</p>


		<form action="sdj_list.sdj" name="search" align="center" method="get">
			<select name="keyField">
				<option value="title">제목</option>
				<option value="writer">작성자</option>

			</select> <input type="text" placeholder="Search.." name="keyWord">
			<button type="submit">
				<i class="fa fa-search"></i>
			</button>
		</form>
	</div>
</body>
</html>

