<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<div class="row">
 	<div class="col-xs-4">
    <div class="col-xs-4">
    <div class="jumbotron" style="padding-top: 20px;">
    <h2 class="text-center">게시글 보기</h2><p>&nbsp;</p>
    <div class="table table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th class="success">번호 :</th>
				<td>${dto.r_num}</td>
				<th class="success">조회수 :</th>
				<td>${dto.r_writer}</td>
			</tr>
			<tr>
				<th class="success">작성자 :</th>
				<td>${dto.r_writer}</td>
			</tr>
			<tr>
				<th class="success">제목 :</th>
				<td>${dto.r_title}</td>
			</tr>
			<tr>
				<th class="success">내용 :</th>
				<td>${dto.r_content}</td>
			</tr>
			<tr>
				<td colspan="4" class="text-center">
					<input type="button" class="btn btn-primary" value="수정"
					onclick="location.href='updateui.rjs?num=${dto.r_num}'">
					
					<input type="button" class="btn btn-primary" value="삭제"
					onclick="location.href='delete.rjs?num=${dto.r_num}'">
					
					<input type="button" class="btn btn-primary" value="답글"
					onclick="location.href='replyui.rjs?num=${dto.r_num}'">
					
					<input type="button" class="btn btn-primary" value="목록"
					onclick="location.href='list1.rjs'">
					
				</td>
			</tr>
		</thead>
	</table>
	</div>
	</div>	
 	</div>
</div>
</div>




</body>
</html>