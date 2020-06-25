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
			<li class="nav-item"><a class="nav-link" href="kjmlist.kjm">kjm게시판</a>
			</li>
			<li class="nav-item"><a class="nav-link Disabled" href="#">Disabled</a>
			</li>
		</ul>
	</nav>
	<div style="
    background-color: #dee2e6;">
		<div class="container" style="margin-top: 50px;background-color: #f8f9fa;">
			<h2>회원가입</h2>
			<p>
				kjm 사이트의 대한
				<code>이용약관, 개인정보 수집 및 이용</code>
				에 대해 동의 합니다.
			</p>

			<form action="LogInsert.kjm" class="was-validated" method="post">
				<div class="form-group">
					<label for="id">UserID:</label> <input type="text"
						class="form-control" id="id" placeholder="Enter userid" name="id"
						required="" style="width: 850px;">
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">영,숫자를 조합하여 아이디를 적으세요.(3글자)</div>
				</div>

				<div class="form-group">
					<label for="name">Username:</label> <input type="text"
						class="form-control" id="name" placeholder="Enter username"
						name="name" required="" style="width: 850px;">
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">이름을 입력하세요.</div>
				</div>

				<div class="form-group">
					<label for="age">Age:</label> <input type="text"
						class="form-control" id="age" placeholder="Enter age" name="age"
						required="" style="width: 850px;">
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">나이를 입력하세요.</div>
				</div>

				<div class="form-group">
					<label for="pw">Password:</label> <input type="password"
						class="form-control" id="pw" placeholder="Enter password"
						name="pw" required="" style="width: 850px;">
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">비밀번호를 입력하세요.</div>
				</div>
				<div class="form-group form-check">
					<label class="form-check-label"> <input
						class="form-check-input" type="checkbox" name="remember"
						required=""> 약관 등 수집에 동의 합니다.
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Check this checkbox to
							continue.</div>
					</label>
				</div>
				<button type="submit" class="btn btn-primary">보내기</button>
			</form>
		</div>
	</div>
	<div>
	</div>
<div>
</div>

</body>
</html>