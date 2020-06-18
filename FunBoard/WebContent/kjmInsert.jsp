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
<H1>게시글 작성</H1>
<form action="kjmInsert.kjm" method="post">
		글쓴이 : <input name ="writer" value="${login.id}" readonly> <br>
		제목&nbsp;&nbsp;&nbsp; : <input name = "title"> <br>
		<div style = "padding: 0px 200px 0px 0px;">  
		내용 :<br>
		</div>
		<div style = "padding: 0px 0px 0px 50px;">  
		<textarea rows="10" cols="23" name = "content"></textarea> 	
		</div>
		<div style = "padding: 0px 0px 0px 200px;">  
		<input type="submit" value="작성"><br>		
		</div>
		
	</form> 
</body>
</html>