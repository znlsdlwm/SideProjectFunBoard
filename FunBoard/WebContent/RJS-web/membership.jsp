<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>회원가입</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

	
<div class="container">
  <div class="col-xs-4"></div>
  <div class="col-xs-4">
   <div class="jumbotron" style="padding-top: 20px;">
   <form method="post" action="membership.rjs">
    <h3 style="text-align: center;"> 회원가입 </h3>
    <div class="form-group">
     <input type="text" class="form-control" placeholder="아이디" name="id" maxlength="20">
    </div>
    <div class="form-group">
     <input type="text" class="form-control" placeholder="이름" name="name" maxlength="20">
    </div>
    <div class="form-group">
     <input type="number" class="form-control" placeholder="나이" name="age" maxlength="20">
    </div>
    <div class="form-group">
     <input type="password" class="form-control" placeholder="비밀번호" name="pw" maxlength="20">
    </div>
    <input type="submit" class="btn btn-primary form-control" value="가입">
   </form>
  </div>
 </div>
</div>
	
	
</body>
</html>