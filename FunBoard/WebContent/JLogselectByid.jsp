
<%@page import="member.domain.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fm"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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