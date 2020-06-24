<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" initial-scale="1">
<title>JSP 웹사이트</title>
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/listboard.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand" href="home.kdh">KDH의 홈페이지</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbars01" aria-controls="navbars01"	
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbars01">
			<ul class="navbar-nav mr-auto">
				<c:if test="${not empty login}">
					<li class="nav-item active"><a class="nav-link"
						href="logout.kdh">로그아웃</a></li>
				</c:if>
				<c:if test="${empty login}">
					<li class="nav-item active"><a class="nav-link"
						href="loginui.kdh">로그인</a></li>
				</c:if>
				<li class="nav-item"><a class="nav-link" href="insertui.kdh">회원가입</a></li>
				<li class="nav-item"><a class="nav-link" href="list.kdh">회원목록</a></li>
				<li class="nav-item"><a class="nav-link" href="listboard.kdh">게시판</a></li>
				<li class="nav-item"><a class="nav-link" href="calculator.kdh">계산기</a></li>
			</ul>
			<form class="form-inline my-2 my-md-0"
				action="listboard.kdh?query=${query}">
				<input class="form-control" name="query" type="text"
					placeholder="Search"> <input
					class="btn btn-outline-primary" type="submit" value="검색">
			</form>
		</div>
	</nav>
	<div class="page_head">
		<div class="container">
			<a href="listboard.kdh" role="button">기본 게시판</a>
		</div>
	</div>
	
	<div class="container jumbotron">
		<div class="container">
			<table class="board_view">
		        <colgroup>
		            <col width="15%">
		            <col width="35%">
		            <col width="15%">
		            <col width="*">
		        </colgroup>
		        <tbody>
		            <tr>
		                <th>제목</th>
		                <td>${dto.title}</td>
		                <th>조회수</th>
		                <td>${dto.readcnt}</td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td>${dto.writer}</td>
		                <th>작성시간</th>
		                <td>${dto.writeDay}</td>
		            </tr>
		            <tr>
		                <td class="view_text" colspan="4">
		                   ${dto.content}
		                </td>
		            </tr>
		        </tbody>
		    </table>
		
		
			<div class="mg-t-16 mg-b-16">
				<div>
					<a class="btn btn-info btn-lg" role="button" onclick="canRep('${login.id}','${dto.num}')">답글</a>
					<a class="btn btn-info btn-lg" role="button" href="listboard.kdh">목록</a>
					<div class="fr">
						<c:if test="${login.id eq dto.writer}">
							<a class="btn btn-secondary btn-lg" role="button"href="updateboardui.kdh?num=${dto.num}">수정</a>
							<a class="btn btn-secondary btn-lg" role="button"href="deleteboardui.kdh?num=${dto.num}">삭제</a>
						</c:if>
					</div>
				</div>
			</div>
			
			<div class="mg-t-16 mg-b-16 h-64">
				<div>
					<div class="fr">
						<table>
							<tr>
								<td id="b_good">${total.b_good_total}</td>
								<td><a class="btn btn-primary btn-lg" role="button" onclick="boardEventListener('${login.id}','${dto.num}','b_good', '추천')"><span class="material-icons">thumb_up</span></a></td>
								<td id="b_bad">${total.b_bad_total}</td>
								<td><a class="btn btn-danger btn-lg" role="button" onclick="boardEventListener('${login.id}','${dto.num}','b_bad', '비추천')"><span class="material-icons">thumb_down</span></a></td>
								<td id="b_warning">${total.b_warning_total}</td>
								<td><a class="btn btn-warning btn-lg" role="button" onclick="boardEventListener('${login.id}','${dto.num}','b_warning', '신고')"><span class="material-icons">report</span></a></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		
			<div class="mg-t-16 mg-r-64 mg-b-64 mg-l-64">
				<form action="insertcommentboard.kdh" method="post">
				<div>
					<input type="hidden" name="num"  value="${param.num}" readonly="readonly">
					<input class="mg-b-16" name="c_writer" placeholder="닉네임" value="${A_Login.id}" required="required">
					<input class="mg-b-16" type="password" name="c_password" placeholder="비밀번호" value="${A_login.pw}" required="required">
				</div>
				<div>
					<textarea class="col-sm-12" rows="3" name="c_content" placeholder="내용을 입력해 주세요" required="required"></textarea>
				</div>
				<div class="fr">
					<input class="btn btn-success" type="submit" value="등록">
					<a class="btn btn-danger" role="button" href="readboard.kdh?num=${dto.num}">취소</a>
				</div>
				</form>
			</div>
			<div class="mg-t-64 mg-r-16 mg-b-64 mg-l-16">
				<div class="container">
					<c:forEach items="${c_list}" var="c">
						<table class="answer_view">
							<colgroup>
				            	<col width="15%">
					            <col width="*">
					            <col width="15%">
					            <col width="10%">
			   			     </colgroup>
			   			    <tbody>
								<tr>
									<td>${c.c_writer}</td>
									<td class="view_text">${c.c_content}</td>
									<td>${c.c_writeday}</td>
									<td>
										<form action="deleteuicommentboard.kdh" method="post">
											<input type="hidden" name="c_num" value="${c.c_num}">
											<input type="hidden" name="num" value="${param.num}">
											<input class="btn btn-danger" type="submit" value="❌">
										</form>
									</td>
								</tr>
			   			    </tbody>
						</table>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function canRep(login, num) {
			if(login==''){
				alert("로그인 후에 이용할 수 있습니다.");
			} else {
				$(location).attr('href','replyboardui.kdh?num='+num);
			}
		}
		
		function boardEventListener(login, num, type, value) {
			if(login==''){
				alert("로그인 후에 이용할 수 있습니다.");
			}else {
				$.ajax({
					type : "get",
					url : "BoardEventListen",
					data : {
						login : login,
						num : num,
						type : type
					},
					success : function(result) {
						if(result==-1){
							alert("한번만 가능합니다.");
						} else {
							alert(value+"하셨습니다.");
							$("#"+type).text(result);
						}
					}
				});
			}
		}
		function CommentEventListener(login, num, type, value) {
			if(login==''){
				alert("로그인 후에 이용할 수 있습니다.");
			}else {
				$.ajax({
					type : "get",
					url : "CommentEventListen",
					data : {
						login : login,
						num : num,
						type : type
					},
					success : function(result) {
						if(result==-1){
							alert("한번만 가능합니다.");
						} else {
							alert(value+"하셨습니다.");
							$("#"+type).text(result);
						}
					}
				});
			}
		}
	</script>
</body>
</html>