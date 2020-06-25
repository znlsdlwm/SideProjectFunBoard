<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원정보수정</h1>
<form action="update.asj" method ="post">
변경할 아이디 : <input name = "id" value = "${dto.id}" readonly><br>
변경할 이름 : <input name = "name" value = "${dto.name}"><br>
변경할 나이 : <input name = "age" value = "${dto.age}"type = "number"><br>
변경할 비밀번호 : <input name = "pw" value = "${dto.pw}" type = "number"><br>
<input type = "submit" value = "수정">


</form>
</body>
</html>