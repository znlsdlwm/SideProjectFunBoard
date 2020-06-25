<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width-device-width, initial-scale=1">
<title>Insert title here</title>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/custom.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</head>
<body>
<h1>답글쓰기</h1>
<form action="boardreply.asj" method = "post">
<input type="hidden" name = "num" value = "${param.num}">
Writer:<input name = "writer" value = "${login.id}"><br>
Title:<input name = "title" value = Re:><br>
Content<br>
<textarea rows="5" name = "content"></textarea>
<br>
<input type = "submit" value = "댓글달기">
</form>
</body>
</html>