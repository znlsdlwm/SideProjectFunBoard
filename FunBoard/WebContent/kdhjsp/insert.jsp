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
<style type="text/css">
input{
text-align: right;
}
</style>
</head>
<body>
	<a href="./home.kdh">kdh메인으로</a>
	<h1>회원가입</h1>
	<form action="insert.kdh">
		ID: <input name="id"><br>
		PW: <input name="pw"><br>
		Name: <input name="name"><br>
		Age: <input name="age"><br>
		<input type="submit" value="확인">
	</form>
</body>
</html>