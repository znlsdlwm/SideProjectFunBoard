<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" initial-scale="1">
<title>JSP 웹사이트</title>
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style type="text/css">
input{
text-align: right;
}
</style>
</head>
<body>
	<a href="./home.kdh">메인으로</a>
	<hr>
	<h1>회원가입</h1>
	<form action="insert.kdh">
		ID: <input name="id" id="id"><button>ID 중복체크</button><br>
		PW: <input name="pw" type="password"><br>
		Name: <input name="name"><br>
		Age: <input name="age"><br>
		<input type="submit" value="확인">
	</form>
	<p></p>
	<script type="text/javascript">
		$(document).ready(function(){
			$("button").click(function(event) {
				event.preventDefault();
				var id = $("#id").val();
				$.ajax({
					type : "get",
					url : "logidcheck.kdh",
					data : {
						id : id
					},
					dataType : "text",
					success : function(result) {
						$("p").text(result);
					}
				});
			});
		});
	</script>
</body>
</html>