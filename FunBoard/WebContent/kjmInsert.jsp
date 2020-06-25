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
<H1>게시글 작성</H1>
<form action="kjmInsert.kjm" method="post">
		글쓴이 : <input name ="writer" value="${login.id}" readonly> <br>
		제목&nbsp;&nbsp;&nbsp; : <input name = "title"> <br>
		<div style = "padding: 0px 200px 0px 0px;">  
		내용 :<br>
		</div>
		<div style = "padding: 0px 0px 0px 50px;">  
		<textarea rows="10" cols="23" name = "content"></textarea> 	
		</div>
		<div style = "padding: 0px 0px 0px 200px;">  
		<input type="submit" value="작성"><br>		
		</div>
	</form> 
	</div>		
</body>
</html>