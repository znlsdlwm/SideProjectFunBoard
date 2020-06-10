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
<body align="center">
<h1>게시글 수정</h1>

	<form action="kjmupdate.kjm" method="post">
	번호 : <input name="num" value="${dto.num}" readonly><br>
	제목 : <input name="title" value="${dto.title}"><br>
	작성자 : <input name="writer" value="${dto.writer}"><br>
	<div style = "padding: 0px 200px 0px 0px;"> 
	내용 : <br>
	</div>
	<textarea rows="10" cols="30" name="content" value="${dto.content}"></textarea> <br>
	<input type="submit" value="수정"><br>
	</form>
</body>
</html>