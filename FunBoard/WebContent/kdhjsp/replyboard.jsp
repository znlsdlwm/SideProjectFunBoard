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
	<h1>답글 작성</h1>
	<form action="replyboard.kdh" method="post">
		<input type="hidden" name="num" value="${dto.num}" readonly="readonly">
		title: <input type="text" name="title" required="required"><br>
		writer: <input type="text" name="writer" value="${login.id}" readonly="readonly"><br>
		content: <br>
		<textarea rows="5" name="content"></textarea><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>