<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fm"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-success navbar-dark" style="margin-bottom: 50px;">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="home.main">메인</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="kjmlist.kjm">게시판</a>
			</li>
			<li class="nav-item"><a class="nav-link Disabled" href="#">Disabled</a>
			</li>
		</ul>
	</nav>
	<div align="center">
	<h3>수정할 아이디를 입력하세요</h3>
	<form action="LogUpdate.kjm" method="post">
    -ID   : <input name="id" value="${dto.id}" readonly><br>
    Name : <input name="name" value="${dto.name}"><br>
    AGE  : <input type="number" name="age" value="${dto.age}"><br> 
    -PW   : <input name="pw" type="password" value="${dto.pw}" required><br>
    <input type="submit" value="수정"><br>
	</form>
	</div>
</body>
</html>