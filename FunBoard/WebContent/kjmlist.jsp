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
<br><br><br><h1>KJM 게시판</h1> 
<Lbody align="right">
<c:choose>
	<c:when test="${empty login.id}">
	<form action="Login.kjm" method="post">
		<div style = "padding: 0px 100px 0px 0px;"> 
		ID : <input name = "id"> <br>
		</div>
		<div style = "padding: 0px 38px 0px 0px;">
		PW : <input name = "pw" type="password">
		<input type="submit" value="로그인">
		</div>
		<br>
	</form>
	<div style = "padding: 0px 210px 0px 0px;">
		<a href="LogInsertui.kjm">회원가입</a>
	</div>
	</c:when>
	<c:otherwise>
	<form action="Logout.kjm" method="post">
		<div style = "padding: 0px 130px 0px 0px;"> 
		${login.id} 님
		<input type="submit" value="로그아웃">
		</div>
		<div style = "padding: 0px 130px 0px 0px;">
	<a href="LogSelectById.kjm?id=${login.id}">회원정보</a>
		</div>
		<div style = "padding: 0px 565px 0px 0px;">  
		<h3><a href="kjmInsertui.kjm">글쓰기</a></h3>
		</div>
	</form>
	</c:otherwise>
</c:choose>	
</Lbody>
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
	<br><br><br>
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