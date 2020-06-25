<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<br>
	<form action="l_update.sdj" method = "post">
		ID : <input name ="id" value="${dto.id}" readonly> <br>
		Name : <input name ="name" value="${dto.name}"><br>
		Age : <input type="number" name="age" value="${dto.age}"><br>
		Pw : <input name="pw" type="password" value="${dto.pw}" required><br>
		<input type = "submit" value = "수정">
	</form>
</body>
</html>