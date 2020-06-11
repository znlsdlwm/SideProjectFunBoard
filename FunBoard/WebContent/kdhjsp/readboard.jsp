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
	글번호: ${dto.num}    작성자: ${dto.writer}    조회수: ${dto.readcnt}<br>
	제목: ${dto.title}                           작성날짜: ${dto.writeDay}<br>
	내용: ${dto.content}<br>
	<a href="updateboardui.kdh?num=${dto.num}">수정</a>|
	<a href="deleteboardui.kdh?num=${dto.num}">삭제</a>|
	<a href="replyboardui.kdh?num=${dto.num}">답글</a>|
	<a href="listboard.kdh">목록</a>
</body>
</html>