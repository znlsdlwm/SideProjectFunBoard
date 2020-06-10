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
	<h1>KJM 게시판</h1>

	<table border="1" align="center">
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
					<td>${dto.num}</td>

					<td width="450px" align="justify"><c:forEach begin="1"
							end="${dto.repIndent}">
			    	&nbsp;&nbsp;
			    </c:forEach> <a href="kjmread.kjm?num=${dto.num}">${dto.title}</a></td>
					<td>${dto.writer}</td>
					<td>${dto.writeday}</td>
					<td>${dto.readcnt}</td>
				</tr>
			</c:forEach>
		</tbody>

		<br>
		<br>
	</table>
	<div style = "padding: 0px 0px 0px 720px;">  
	<h3><a href="kjmInsertui.kjm">글쓰기</a></h3>
	</div>
	<a href="kjmlist.kjm?curPage=${(to.curPage-1)>0 ? (to.curPage-1):1}">&laquo;</a>&nbsp;&nbsp;

	<c:forEach begin="${to.beginPageNum}" end="${to.stopPageNum}" var="idx">

		<c:if test="${to.curPage==idx}">
			<a style="font-size: 20px" href="kjmlist.kjm?curPage=${idx}">${idx}</a>&nbsp;&nbsp;
			</c:if>
		<c:if test="${to.curPage!=idx}">
			<a href="kjmlist.kjm?curPage=${idx}">${idx}</a>&nbsp;&nbsp;
			</c:if>
	</c:forEach>
	<a
		href="kjmlist.kjm?curPage=${(to.curPage+1) < to.totalPage? (to.curPage+1):to.totalPage}">&raquo;</a>&nbsp;&nbsp;
</body>
</html>