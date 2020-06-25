<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
  
<!DOCTYPE html>
<html lang ="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width-device-width, initial-scale=1">
<title>Insert title here</title>
<link href="./ASJ-WEB/css/bootstrap.min.css" rel="stylesheet">
<link href="./css/custom.css" rel="stylesheet">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</head>
<style type = "text/css">
body{
background-image:url(image/sky.png);

}

.container{

	position: absolute;
	text-align: center;
	width: 300px;
	height:200px;
	top:50%;
	left:45%;
	margin:-200px 0 0 -50px;
	
	

}


</style>
<body>
<div class = "container">
<h1>new</h1>
<form action = "insert.asj" method = "post">
<div class="form-group">
	<label for= "id">ID:</label>
	<input name ="id" class = "form-control"><br>
</div>
<div class="form-group">
	<label for = "PW">Password</label>
	<input type ="password" class = "form-control" name = "pw"><br>
</div>
<div class="form-group">
	<label for = "name">Name</label>
	<input class ="form-control" name = "name"><br>
</div>
<div class="form-group">
	<label for ="age">Age</label>
	<input class ="form-control" type = "number" name = "age"><br>
</div>
	<button type="submit" class ="btn btn-default">가입하기</button>
</form>
</div>
</body>
</html>