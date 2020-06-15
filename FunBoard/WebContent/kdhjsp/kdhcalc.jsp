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
<link rel="stylesheet" href="../css/bootstrap.css">
<style type="text/css">
.calcbtn {
	width: 50px;
	height: 50px;
}

.output {
	width: 208px;
	height: 50px;
	background: #e9e9e9;
	font-size: 24px;
	font-weight: bold;
	text-align: right;
	padding: 0px 5px;
}
</style>
</head>
<body>
<nav class="navbar navbar-expand navbar-dark bg-dark" id="navbars01">
		<a class="navbar-brand" href="home.kdh">KDH의 홈페이지</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbars01" aria-controls="navbars01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse">
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
	<form action="calculator.kdh" method="post">
	<table>
			<tr>
				<td class="output" colspan="4">${cookie.resultAll.value}</td>
			</tr>
		</table>
		<table>
			<tr>
				<td class="output" colspan="4">${cookie.result.value}</td>
			</tr>
		</table>
		<table>
			<tr>
				<td><input class="calcbtn" type="submit" name="operator"
					value="%"></td>
				<td><input class="calcbtn" type="submit" name="operator"
					value="CE"></td>
				<td><input class="calcbtn" type="submit" name="operator"
					value="BS"></td>
				<td><input class="calcbtn" type="submit" name="operator"
					value="/"></td>
			</tr>
			<tr>
				<td><input class="calcbtn" type="submit" name="value" value="7"></td>
				<td><input class="calcbtn" type="submit" name="value" value="8"></td>
				<td><input class="calcbtn" type="submit" name="value" value="9"></td>
				<td><input class="calcbtn" type="submit" name="operator"
					value="*"></td>
			</tr>
			<tr>
				<td><input class="calcbtn" type="submit" name="value" value="4"></td>
				<td><input class="calcbtn" type="submit" name="value" value="5"></td>
				<td><input class="calcbtn" type="submit" name="value" value="6"></td>
				<td><input class="calcbtn" type="submit" name="operator"
					value="-"></td>
			</tr>
			<tr>
				<td><input class="calcbtn" type="submit" name="value" value="1"></td>
				<td><input class="calcbtn" type="submit" name="value" value="2"></td>
				<td><input class="calcbtn" type="submit" name="value" value="3"></td>
				<td><input class="calcbtn" type="submit" name="operator"
					value="+"></td>
			</tr>
			<tr>
				<td><input class="calcbtn" type="submit" name="operator"
					value="+/-"></td>
				<td><input class="calcbtn" type="submit" name="value" value="0"></td>
				<td><input class="calcbtn" type="submit" name="dot" value="."></td>
				<td><input class="calcbtn" type="submit" name="operator"
					value="="></td>
			</tr>
		</table>
	</form>


</body>
</html>