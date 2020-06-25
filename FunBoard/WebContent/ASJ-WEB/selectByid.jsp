<%@page import="ASJ.domain.asjDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
  
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/custom.css" rel="stylesheet">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</head>
<body>
<h1>회원 정보</h1>
<%
asjDTO dto = (asjDTO)request.getAttribute("dto");
%>

	ID:${dto.id}<br>
	NAME:${dto.name}<br>
	Age:${dto.age}<br>
	<a href="updateui.asj?id=${dto.id}">수정</a>|<a href = "delete.asj?id=${dto.id}">삭제</a>|<a href="home.asj">메인페이지가기</a>
</body>
</html>