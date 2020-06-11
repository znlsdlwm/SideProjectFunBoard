<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="./home.kdh">메인으로</a>
	<hr>
	<h1>회원목록</h1>
	<c:forEach items="${list}" var="dto">
		<a href="#">ID: ${dto.id}&nbsp;&nbsp;Name: ${dto.name}&nbsp;&nbsp;Age: ${dto.age}</a><br>
	</c:forEach>
</body>
</html>