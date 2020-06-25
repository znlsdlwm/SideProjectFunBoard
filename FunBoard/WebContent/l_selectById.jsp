<%@page import="sdj.login.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 자세히 보기</h1>
	
	<%
		MemberDTO dto = (MemberDTO)request.getAttribute("dto");
	%>
	
	ID : <%= dto.getId() %><br>
	Name : <%= dto.getName() %><br>
	Age : <%= dto.getAge() %>
	
	
	<a href="l_updateui.sdj?id=<%=dto.getId()%>">수정</a> | <a href="l_delete.sdj?id=<%=dto.getId()%>">삭제</a> | <a href="l_select.sdj">목록</a>
</body>
</html>