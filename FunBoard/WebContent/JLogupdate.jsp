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
	<h3>수정할 아이디를 입력하세요</h3>
	<form action="LogUpdate.kjm" method="post">
    ID : <input name="id" value="${dto.id}" readonly><br>
    NAME : <input name="name" value="${dto.name}"><br>
    AGE : <input type="number" name="age" value="${dto.age}"><br> 
    PW : <input name="pw" type="password" value="${dto.pw}" required><br>
    <input type="submit" value="수정"><br>
	</form>
</body>
</html>