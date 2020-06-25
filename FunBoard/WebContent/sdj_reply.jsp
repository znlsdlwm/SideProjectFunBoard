<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width; initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">

<link href="bootstrap-3.3.1/css/bootstrap.min.css" rel="stylesheet">


<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<form method="post" action="sdj_reply.sdj">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">

					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">글쓰기</th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<td>
							<input type="hidden" name="num" value = "${param.num}">
							<input type="text" class="form-control"
								placeholder="작성자" name="writer" value ="${login.id}" readonly/></td>
						</tr>		
						
						<tr>
							<td><input type="text" class="form-control"
								placeholder="제목" name="title" maxlength="50" /></td>
						</tr>

						<tr>
							<td><textarea class="form-control" placeholder="내용"
									name="content" maxlength="2048" style="height: 350px;"></textarea></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" class="btn btn-primary pull-right" value="완료" />
			</form>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

	<script src="js/bootstrap.js"></script>


</body>
</html>