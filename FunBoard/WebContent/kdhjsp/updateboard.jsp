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
	<h1>글 수정</h1>
	<form action="updateboard.kdh" method="post">
		글번호: <input name="num" value="${dto.num}" readonly="readonly"><br>
		글쓴이: <input name="writer" value="${dto.writer}" readonly="readonly"><br>
		글제목: <input name="title" value="${dto.title}"><br>
		글내용: <textarea name="content" rows="10" cols="50">${dto.content}</textarea><br>
		<input type="submit" value="확인">
	</form>
</body>
</html>