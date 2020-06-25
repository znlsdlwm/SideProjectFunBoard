<%@page import="sdj.kr.co.domain.BoardDTO"%>
<%@page import="sdj.login.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width; initial-scale=1">
<link href="bootstrap-3.3.1/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

	 
	<%
		BoardDTO dto = (BoardDTO)request.getAttribute("dto");
	%>
<!--
	
	NUM : ${dto.num}<br>
	Writer : ${dto.writer}<br>
	ReadCnt : ${dto.readcnt} <br>
	Title : ${dto.title}<br>
	Content : ${dto.content} <br>
	
	<a href="sdj_updateui.sdj?num=${dto.num}&writer=${dto.writer}">수정</a> | <a href="sdj_delete.sdj?num=${dto.num}&writer=${dto.writer}">삭제</a> | <a href="sdj_replyui.sdj?num=${dto.num}">답글</a> | <a href="sdj_list.sdj">목록</a>
	 -->
	 <div class="row">
    <div class="col-lg-2 col-md-2"></div>
    <div class="col-lg-8 col-md-8">
    <h2 class="text-center">게시글 보기</h2><p>&nbsp;</p>
    <div class="table table-responsive">
        <table class="table">
        <tr>
            <th class="active">글번호</th>
            <td>${dto.num}</td>
            <th class="active">조회수</th>
            <td>${dto.readcnt}</td>
        </tr>
           
         
        <tr>
            <th class="active">작성자</th>
            <td>${dto.writer}</td>
            <th class="active">작성일</th>
            <td>${dto.writeday}</td>
        </tr>
         
        <tr>
            <th class="active">제목</th>
            <td colspan="3">${dto.title}</td>
        </tr>
         
        <tr>
            <th class="active">글 내용</th>
            <td colspan="3">${dto.content}</td>
        </tr>
         
        <tr>
            <td colspan="4" class="text-center">
    			<input type="button" class="btn btn-secondary" value="수정하기" onclick="location.href='sdj_updateui.sdj?num=${dto.num}&writer=${dto.writer}'">          
				<input type="button" class="btn btn-secondary" value="삭제하기" onclick="location.href='sdj_delete.sdj?num=${dto.num}&writer=${dto.writer}'">
				<input type="button" class="btn btn-secondary"  value="답글 쓰기" 
					onclick="location.href='sdj_replyui.sdj?num=${dto.num}'">
				<input type="button" class="btn btn-secondary" value="목록보기" onclick="location.href='sdj_list.sdj'">
            </td>
        </tr>
     
             
         
        </table>
    </div>
     
    </div>
</div>
	
</body>
</html>