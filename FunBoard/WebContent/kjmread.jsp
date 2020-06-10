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
<H1>게시글 보기</H1>
	<div style = "padding: 0px 200px 0px 0px;">  		
	번호 : ${dto.num}<br>
	</div>
	<div style = "padding: 0px 200px 0px 0px;">  
	조회수 : ${dto.readcnt}<br>		
	</div>
	<div style = "padding: 0px 200px 0px 0px;">  
	제목 : ${dto.title}<br>
	</div>
	작성자 : ${dto.writer}  &nbsp;작성일:${dto.writeday}<br>
	<div style = "padding: 0px 300px 0px 0px;">  
	내용 :<br> 
	</div>
	<textarea rows="10" cols="30" name = "content">${dto.content}</textarea>
	<br><br>
	

	<a href="kjmupdateui.kjm?num=${dto.num}">수정</a>|<a href="kjmdelete.kjm?num=${dto.num}">삭제</a>|<a href="덧글예정=${dto.num}">댓글을만들자</a>|<a href="kjmlist.kjm">목록</a>
</body>
</body>
</html>