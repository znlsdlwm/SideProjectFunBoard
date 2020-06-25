<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>게시판</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	
</head>
<body>





<div class="container-fluid">
<div class="jumbotron" style="padding-top: 20px;">
	<h2>IT게시판</h2>
	<input type="button" class="btn btn-primary" value="홈" onclick="location.href='list1.rjs'">
	<input type="button" class="btn btn-primary" value="글쓰기" onclick="location.href='insertui1.rjs'">
	<input type="button" class="btn btn-primary" value="로그아웃" onclick="location.href='logout.rjs'">
	<table class="table table-striped" border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.r_num}</td>
					
					<td width="300px">
					
					<c:forEach begin="0" end="${dto.r_repIndent }">
						&nbsp;&nbsp; <%--칸띄우기 드려쓰기 --%>
						
					</c:forEach>
					<a href="read.rjs?num=${dto.r_num}">${dto.r_title}</a>
					
					</td>
					<td>${dto.r_writer}</td>
					<td>${dto.r_writeday}</td>
					<td>${dto.r_readcnt+1}</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
	

 


	
	<a href="list1.rjs?curPage=${(to.curPage-1) > 0? (to.curPage-1):1}">&laquo;</a>&nbsp;&nbsp;
	<c:forEach begin="${to.beginPageNum}" end="${to.stopPageNum}" var="idx">
	
		<c:if test="${to.curPage == idx}">
			<a style="font-size: 20px" href="list1.rjs?curPage=${idx}">${idx}</a>&nbsp;&nbsp;
		</c:if>
		<c:if test="${to.curPage != idx}">
			<a href="list1.rjs?curPage=${idx}">${idx}</a>&nbsp;&nbsp;
		</c:if>
		
	</c:forEach>
	<a href="list1.rjs?curPage=${(to.curPage+1) < to.totalPage? (to.curPage+1) : to.totalPage}">&raquo;</a>


<form action="list1.rjs" name="search" align="center" method="get">
      <select name="keyField">
         <option value="title">제목</option>
         

      </select>
      <input type="text" name="keyWord" />
      <input type="submit" value="검색">
</form>

	</div>   
</div>

	<script src="js/jquery=3.1.1.js""></script>
	<script src="js/bootstrap.js""></script>
</body>
</html>