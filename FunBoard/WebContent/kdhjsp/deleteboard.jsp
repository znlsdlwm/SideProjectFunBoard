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
	<form action="deleteboard.kdh" method="post">
		<input type="hidden" name="num" value="${num}" readonly="readonly">
		정말로 삭제하시겠습니까? <input type="submit" value="예">
	</form>
	<form action="listboard.kdh" method="post">
		<input type="submit" value="아니오">
	</form>
</body>
</html>