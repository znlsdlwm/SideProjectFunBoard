
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale="1">
<link href="bootstrap-3.3.1/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>

    <div class="container">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <div class ="jumbotron" style="padding-top:20px;">
                <form method = "post" action="l_login.sdj">
                    <h3 style="text-align:center;">로그인 화면</h3>
                    <div class ="form-group">
                        <input type ="text" class="form-control" placeholder="아이디" name ="id" maxlength='20'>
                    </div>
                    <div class ="form-group">
                        <input type ="password" class="form-control" placeholder="비밀번호" name ="pw" maxlength='20'>
                    </div>
                    <input type="submit" class="btn btn-primary form-control" value="로그인">
                </form>
            </div> 
        </div> 
        <div class="col-lg-4"></div>
    </div>
	
	
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>

	<script src="js/bootstrap.js"></script>
</body>
</html>
 

