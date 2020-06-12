
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 목록</h1>

<!--  
<form action="sdj_list.sdj?query=${query}" method="get">

		제목 : <input type="text" size="20" name="title" />&nbsp; 
		<input type="submit" value="검색" />
	</form>
-->	

	<div id="searchForm">
        <form>
            <select name="opt">
                <option value="0">제목</option>
                <option value="1">내용</option>
                <option value="2">제목+내용</option>
                <option value="3">글쓴이</option>
            </select>
            <input type="text" size="20" name="condition"/>&nbsp;
            <input type="submit" value="검색"/>
        </form>    
    </div>


	<button type="button" onclick="location.href='sdj_insertui.sdj' ">글쓰기</button>
	<table border="1">
		<thead>
			<tr>
				<th>num</th>
				<th>title</th>
				<th>writer</th>
				<th>writeday</th>
				<th>readcnt</th>

			</tr>
		</thead>

		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.num}</td>

					<td width="250px"><c:forEach begin="1" end="${dto.repIndent}">
						&nbsp;&nbsp;
					</c:forEach> <a href="sdj_read.sdj?num=${dto.num}">${dto.title}</a></td>

					<td>${dto.writer}</td>
					<td>${dto.writeday}</td>
					<td>${dto.readcnt}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>


	<a href="sdj_list.sdj?curPage=${(to.curPage-1) > 0 ? (to.curPage-1) : 1}">&laquo;</a>&nbsp;&nbsp;
	<c:forEach begin="${to.beginPageNum}" end="${to.stopPageNum}" var="idx">
		<c:if test="${to.curPage == idx}">
			<a style="font-size: 20px;"
				href="sdj_list.sdj?query=${query}?curPage=${idx}">${idx}</a>&nbsp;&nbsp;
		</c:if>

		<c:if test="${to.curPage != idx}">
			<a href="sdj_list.sdj?query=${query}?curPage=${idx}">${idx}</a>&nbsp;&nbsp;			
		</c:if>
	</c:forEach>
	<a
		href="sdj_list.sdj?query=${query}?curPage=${(to.curPage+1) < to.totalPage? (to.curPage+1) : to.totalPage}">&raquo;</a>

</body>
</html>