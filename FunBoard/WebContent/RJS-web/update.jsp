<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>수정</title>
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
		<h2>글수정</h2>
  		<form action="update.rjs" method="post">
    	<div class="form-group">
    	num : <input name="num" readonly value="${dto.r_num}"><br>
    	작성자: <input name="writer" value="${dto.r_writer}" readonly><br>
		제목: <input name="title" value="${dto.r_title}"><br>
      	<label for="comment">내용:</label>
      	<textarea class="form-control" rows="5" id="comment" name="content">${dto.r_content}</textarea>
    	</div>
    		<button type="submit" class="btn btn-primary">Submit</button>
  		</form>
  		</div>
  		</div>
  		</div>
  		</div>
	</div>
</body>
</html>