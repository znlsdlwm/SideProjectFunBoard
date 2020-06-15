<%@page import="com.microsoft.kdh.domain.PageTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" initial-scale="1">
<title>JSP 웹사이트</title>
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<style type="text/css">
.listBoardHome:link {
	text-decoration: none;
}

.listBoardHome {
	font-size: 37px;
	display: block;
	position: relative;
	top: -33px;
}

#listBoardHomeDiv {
	height: 100px;
	margin-bottom: 0px;
	padding: 50px 24px 52px 18px;
}

#listBoardTableDiv {
	padding: 0px 32px 0px 32px;
}

.board {
	text-align: center;
}

.board_th_num {
	width: 50px;
	height: 26px;
	text-align: center;
}

.board_td_num {
	font-size: 11px;
	text-align: center;
}

#board_td_title {
	text-align: left;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark" id="navbars01">
		<a class="navbar-brand" href="home.kdh">KDH의 홈페이지</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbars01" aria-controls="navbars01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<c:if test="${not empty login}">
					<li class="nav-item active"><a class="nav-link"
						href="logout.kdh">로그아웃</a></li>
				</c:if>
				<c:if test="${empty login}">
					<li class="nav-item active"><a class="nav-link"
						href="loginui.kdh">로그인</a></li>
				</c:if>
				<li class="nav-item"><a class="nav-link" href="insertui.kdh">회원가입</a></li>
				<li class="nav-item"><a class="nav-link" href="list.kdh">회원목록</a></li>
				<li class="nav-item"><a class="nav-link" href="listboard.kdh">게시판</a></li>
				<li class="nav-item"><a class="nav-link" href="calculator.kdh">계산기</a></li>
			</ul>
			<form class="form-inline my-2 my-md-0"
				action="listboard.kdh?query=${query}">
				<input class="form-control" name="query" type="text"
					placeholder="Search"> <input
					class="btn btn-outline-primary" type="submit" value="검색">
			</form>
		</div>
	</nav>
	<div class="jumbotron" id="listBoardHomeDiv">
		<a class="listBoardHome" href="listboard.kdh" role="button">기본 게시판</a>
	</div>
	<div class="jumbotron" id="listBoardTableDiv">
		<a href="./insertboardui.kdh">글쓰기</a>
		<form
			action="listboard.kdh?query=${query}&curPage=${to.curPage}&option=${option}">
			<select name="option">
				<option value="1">제목</option>
				<option value="2">글쓴이</option>
			</select> <input name="query"> <input type="submit" value="검색">
		</form>
		<table border="1" class="board">
			<tr>
				<th class="board_th_num">번호</th>
				<th>글제목</th>
				<th>글쓴이</th>
				<th>작성시간</th>
				<th>조회수</th>
				<%--
				<th>repRoot</th>
				<th>repStep</th>
				<th>repIndent</th>
				 --%>
			</tr>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td class="board_td_num">${dto.num}</td>
					<td id="board_td_title" width="300px"><c:forEach begin="1"
							end="${dto.repIndent}">
						&nbsp;&nbsp;
					</c:forEach><a href="readboard.kdh?num=${dto.num}"> ${dto.title} </a></td>
					<td>${dto.writer}</td>
					<td>${dto.writeDay}</td>
					<td>${dto.readcnt}</td>
					<%--
					<td>${dto.repRoot}</td>
					<td>${dto.repStep}</td>
					<td>${dto.repIndent}</td>
					 --%>
				</tr>
			</c:forEach>
		</table>
	</div>
	<ul class="pagination">
		<c:if test="${to.curPage>1}">
			<li class="page-item"><a class="page-link"
				href="listboard.kdh?query=${query}&curPage=${1}">처음으로</a></li>
		</c:if>
		<c:if test="${to.beginPageNum>1}">
			<li class="page-item"><a class="page-link"
				href="listboard.kdh?query=${query}&curPage=${to.curPage-to.perPage}">이전</a></li>
		</c:if>
		<c:forEach begin="${to.beginPageNum}" end="${to.stopPageNum}"
			var="idx">
			<c:if test="${idx==to.curPage}">
				<li class="page-item active"><a class="page-link"
					href="listboard.kdh?query=${query}&curPage=${idx}">${idx}</a></li>
			</c:if>
			<c:if test="${idx!=to.curPage}">
				<li class="page-item"><a class="page-link"
					href="listboard.kdh?query=${query}&curPage=${idx}">${idx}</a></li>
			</c:if>	
		</c:forEach>
		<c:if test="${to.stopPageNum<to.totalPage}">
			<li class="page-item"><a class="page-link"
				href="listboard.kdh?query=${query}&curPage=${to.curPage+to.perPage}">다음</a></li>
		</c:if>
		<c:if test="${to.curPage<to.totalPage}">
			<li class="page-item"><a class="page-link"
				href="listboard.kdh?query=${query}&curPage=${to.totalPage}">끝으로</a></li>
		</c:if>
	</ul>
</body>
</html>