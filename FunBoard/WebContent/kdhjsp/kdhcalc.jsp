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
<style type="text/css">
.calcbtn {
	width: 50px;
	height: 50px;
}

.output {
	width: 200px;
	height: 50px;
	background: #e9e9e9;
	font-size: 24px;
	font-weight: bold;
	text-align: right;
	padding: 0px 5px;
}
</style>
</head>
<body>
	<a href="./home.kdh">홈</a>
	<hr>
	<form action="calculator.kdh" method="post">
		<table>
			<tr>
				<td class="output" colspan="4">0</td>
			</tr>
		</table>
		<table>
			<tr>
				<td><input class="calcbtn" type="submit" name="operator"
					value="%"></td>
				<td><input class="calcbtn" type="submit" name="operator"
					value="CE"></td>
				<td><input class="calcbtn" type="submit" name="operator"
					value="BS"></td>
				<td><input class="calcbtn" type="submit" name="operator"
					value="/"></td>
			</tr>
			<tr>
				<td><input class="calcbtn" type="submit" name="value" value="7"></td>
				<td><input class="calcbtn" type="submit" name="value" value="8"></td>
				<td><input class="calcbtn" type="submit" name="value" value="9"></td>
				<td><input class="calcbtn" type="submit" name="operator"
					value="*"></td>
			</tr>
			<tr>
				<td><input class="calcbtn" type="submit" name="value" value="4"></td>
				<td><input class="calcbtn" type="submit" name="value" value="5"></td>
				<td><input class="calcbtn" type="submit" name="value" value="6"></td>
				<td><input class="calcbtn" type="submit" name="operator"
					value="-"></td>
			</tr>
			<tr>
				<td><input class="calcbtn" type="submit" name="value" value="1"></td>
				<td><input class="calcbtn" type="submit" name="value" value="2"></td>
				<td><input class="calcbtn" type="submit" name="value" value="3"></td>
				<td><input class="calcbtn" type="submit" name="operator"
					value="+"></td>
			</tr>
			<tr>
				<td><input class="calcbtn" type="submit" name="operator"
					value="+/-"></td>
				<td><input class="calcbtn" type="submit" name="value" value="0"></td>
				<td><input class="calcbtn" type="submit" name="dot" value="."></td>
				<td><input class="calcbtn" type="submit" name="operator"
					value="="></td>
			</tr>
		</table>
	</form>


</body>
</html>