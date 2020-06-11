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
<h1>회원가입</h1>

	<form action="LogInsert.kjm" method="post">
		ID : <input name = "id"> <br>
		NAME : <input name = "name"> <br>
		AGE : <input type="number" name = "age"> <br>
		PW : <input name= "pw" type="password"><br>
		<input type="submit" value="가입"><br>
		
	</form> 
</body>
</html>