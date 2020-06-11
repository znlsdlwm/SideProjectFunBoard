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
	<h1>게시글 작성</h1>
	<form action="insertboard.kdh">
		title: <input type="text" name="title"><br>
		writer: <input type="text" readonly="readonly" value="${login.id}"><br>
		content: <br>
		<textarea rows="5" name="content"></textarea><br>
		<input type="submit" value="전송">
	</form>
	<br><br><br>
	<a href="listboard.kdh">목록으로</a>
</body>
</html>