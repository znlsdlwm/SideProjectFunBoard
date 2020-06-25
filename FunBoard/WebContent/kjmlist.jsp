<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fm"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
	<nav class="navbar navbar-expand-sm bg-success navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="home.main">메인</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="kjmlist.kjm">게시판</a>
			</li>
			<li class="nav-item"><a class="nav-link Disabled" href="#">...</a>
			</li>
		</ul>
	</nav>
	<div align="right" style="margin-top: 2">
		<c:choose>
			<c:when test="${empty login.id}">
				<form action="Login.kjm" method="post">
					<div style="padding: 0px 106px 0px 0px;">
						ID : <input name="id" style="margin-top: 20px;"> <br>
					</div>
					<div style="padding: 0px 38px 0px 0px;">
						PW : <input name="pw" type="password"> <input
							type="submit" value="로그인">
					</div>
				</form>
				<div style="padding: 0px 225px 30px 0px;">
					<a href="LogInsertui.kjm">회원가입</a>
				</div>
				<div style="margin-bottom: 0"align="center">
					<h1>KJM 게시판</h1>
				</div>
			</c:when>
			<c:otherwise>
				<form action="Logout.kjm" method="post">
					<div style="padding: 0px 130px 0px 0px;">
						${login.id} 님 <input type="submit" value="로그아웃">
					</div>
					<div style="padding: 0px 130px 0px 0px;">
						<a href="LogSelectById.kjm?id=${login.id}">회원정보</a>
					</div>
					<div style="padding: 0px 400px 0px 0px;">
						<h3>
							<a href="kjmInsertui.kjm">글쓰기</a>
						</h3>
					</div>
					<div style="margin-bottom: 0"align="center">
					<h1>KJM 게시판</h1>
				</div>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="container">
		<div>

			<table style="justify-content: center; margin-bottom: 50px;"
				class="table table-hover">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>
				<c:forEach items="${list}" var="dto">
					<tr>
						<th scope="row">${dto.num}</th>
						<td width="450px"><c:forEach begin="1" end="${dto.repIndent}">
			    	&nbsp;&nbsp;
			    </c:forEach> <a href="kjmread.kjm?num=${dto.num}">${dto.title}</a></td>
						<td>${dto.writer}</td>
						<td>${dto.writeday}</td>
						<td>${dto.readcnt}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<div class="container">
		<div>
			<ul style="justify-content: center;" class="pagination">
				<li class="page-item"><a class="page-link"
					href="kjmlist.kjm?curPage=${(to.curPage-1)>0 ? (to.curPage-1):1}">&laquo;</a></li>
				<c:forEach begin="${to.beginPageNum}" end="${to.stopPageNum}"
					var="idx">
					<c:if test="${to.curPage==idx}">
						<li class="page-item"><a class="page-link"
							style="font-size: 20px" href="kjmlist.kjm?curPage=${idx}">${idx}</a></li>
					</c:if>
					<c:if test="${to.curPage!=idx}">
						<li class="page-item"><a class="page-link"
							href="kjmlist.kjm?curPage=${idx}">${idx}</a></li>
					</c:if>
				</c:forEach>
				<li class="page-item"><a class="page-link"
					href="kjmlist.kjm?curPage=${(to.curPage+1) < to.totalPage? (to.curPage+1):to.totalPage}">&raquo;</a></li>
			</ul>
		</div>
	</div>
</body>
</html>