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
	<a href="home.kdh">메인으로</a>
	<hr>
	<h1>로그인 화면</h1>
	<form action="login.kdh" method="post">
		ID: <input name="id"><br>
		PW: <input name="pw" type="password"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>