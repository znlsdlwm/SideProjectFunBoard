<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css, integrity=sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk, crossorigin=anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js, integrity=sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj ,crossorigin=anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js, integrity=sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo, crossorigin=anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js, integrity=sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI, crossorigin=anonymous"></script>

<meta http-equiv="Content-Type" content = "text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="bootstrap-3.3.1/css/bootstrap.min.css" rel="stylesheet">


<title>Insert title here</title>
</head>
<body>
	<!-- 
	 <h1>회원 가입</h1>
	<form action = "l_insert.sdj" method = "post">
		ID : <input name = "id" ><br>
		Name : <input name = "name"><br>
		Age : <input type="number" name = "age" ><br>
		Pw : <input name="pw" type = "password"><br>
		<input type = "submit" value = "가입">
	</form>
	 -->
	
	 <div class="container">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <div class ="jumbotron" style="padding-top:20px;">
                <form method = "post" action="l_insert.sdj">
                    <h3 style="text-align:center;">회원가입</h3>
                    <div class ="form-group">
                        <input type ="text" class="form-control" placeholder="아이디" name ="id" maxlength='20'>
                    </div>
                    <div class ="form-group">
                        <input type ="text" class="form-control" placeholder="이름" name ="name" maxlength='20'>
                    </div>
                    <div class ="form-group">
                        <input type ="number" class="form-control" placeholder="나이" name ="age" maxlength='20'>
                    </div>
                    <div class ="form-group">
                        <input type ="password" class="form-control" placeholder="비밀번호" name ="pw" maxlength='20'>
                    </div>
                    <input type="submit" class="btn btn-primary form-control" value="가입">
                </form>
            </div> 
        </div> 
        <div class="col-lg-4"></div>
    </div>
	
	
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>

	<script src="js/bootstrap.js"></script>
</body>
</html>