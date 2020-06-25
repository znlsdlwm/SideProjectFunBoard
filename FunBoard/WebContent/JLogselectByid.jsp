
<%@page import="member.domain.MemberDTO"%>
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
<h1>회원정보 자세히 보기</h1>
	
	<%
		MemberDTO dto = (MemberDTO) request.getAttribute("dto");
	%>
	
	ID: <%=dto.getId()%> <br>
	NAEM: <%=dto.getName()%> <br>
	AGE: <%=dto.getAge()%> <br>
	PassWord: <%=dto.getPw()%> <br>
	
	<a href="LogUpdateui.kjm?id=<%=dto.getId()%>">수정</a> | <a href="LogDelete.kjm?id=<%=dto.getId()%>">탈퇴</a> | <a href="kjmlist.kjm">게시판으로</a>
	
</body>
</html>