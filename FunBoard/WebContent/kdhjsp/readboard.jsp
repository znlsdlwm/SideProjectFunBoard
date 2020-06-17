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
	<div class="jumbotron" id="listBoardHomeDiv">
		<a class="listBoardHome" href="listboard.kdh" role="button">기본 게시판</a>
	</div>
	<div class="jumbotron" id="mg-bottom_0">
		<div class="mg-auto_10">
			<div><b>제목: ${dto.title}</b></div>  
			<div class="fr mg-right_32">글번호: ${dto.num} </div>
			<div class="fl">작성자: ${dto.writer}</div>
			<div class="fr" style="margin-right: 10%;">조회수: ${dto.readcnt}</div>
			<div class="fr" style="margin-right: 10%;">작성날짜: ${dto.writeDay}</div>
		</div>
	</div>
	<div id="newjumbotron" class="pd-bottom-32 pd-top-32">
		<div style="margin-left: 32px;">${dto.content}</div>
	</div>
	<div id="newjumbotron" class="pd-bottom-32 pd-top-32">
		<div class="container">
			${total.b_good_total}
			${total.b_bad_total}
			${total.b_warning_total}
		</div>
	</div>	
	<div id="newjumbotron" class="pd-bottom-64 pd-top-16">	
		<div class="fl">
			<div class="container">
				<a class="fl btn btn-info btn-lg" role="button" href="replyboardui.kdh?num=${dto.num}">답글</a>
				<a class="fl btn btn-info btn-lg" role="button" href="listboard.kdh">목록</a>
				<a class="fl btn btn-primary btn-lg" role="button" onclick="boardEventListener('${login.id}','${dto.num}','b_good', '추천')"><span class="material-icons">thumb_up</span></a>
				<a class="fl btn btn-danger btn-lg" role="button" onclick="boardEventListener('${login.id}','${dto.num}','b_bad', '비추천')"><span class="material-icons">thumb_down</span></a>
				<a class="fl btn btn-info btn-lg" role="button" onclick="boardEventListener('${login.id}','${dto.num}','b_warning', '신고')"><span class="material-icons">report</span></a>
				<c:if test="${login.id eq dto.writer}">
					<a class="fr btn btn-secondary btn-lg" role="button"
						href="updateboardui.kdh?num=${dto.num}">수정</a>
					<a class="fr btn btn-secondary btn-lg" role="button"
						href="deleteboardui.kdh?num=${dto.num}">삭제</a>
				</c:if>
			</div>
		</div>
	</div>
	<div id="newjumbotron" class="pd-bottom-32 pd-top-32">
		<div class="container">
			<form action="insertcommentboard.kdh" method="post">
			<input type="hidden" name="num"  value="${param.num}" readonly="readonly">
			<div class="row">
				<div class="col-sm-2 fr">
					<div class="row">
						<input type="text" name="c_writer" placeholder="닉네임">
					</div>
					<div class="row">
						<input type="password" name="c_password" placeholder="비밀번호">
					</div>
				</div>
				<div class="col-sm-10">
					<textarea class="col-sm-12" rows="3" name="c_content" placeholder="내용을 입력해 주세요"></textarea>
				</div> 
			</div>
			<div class="row fr">
				<div class="col-sm-4">
					<input class="col-sm-12 btn btn-success" type="submit" value="등록">
				</div>
				<div class="col-sm-4">
					<a class="col-sm-12 btn btn-danger" role="button" href="readboard.kdh?num=${dto.num}">취소</a>
				</div>
			</div>
			</form>
		</div>
	</div>
	<div id="newjumbotron" class="pd-top-32">
		<div class="container">
			<c:forEach items="${c_list}" var="c">
				${c.c_num}
				${c.c_writer}
				${c.c_content}
				${c.c_password} 
				${c.c_writeday} 
				${c.c_good} 
				${c.c_bad}
				${c.c_warning} 
				${c.c_root} 
				${c.c_step}
				${c.c_indent}<br>
				<form action="deleteuicommentboard.kdh" method="post">
					<input type="hidden" name="c_num" value="${c.c_num}">
					<input type="hidden" name="num" value="${param.num}">
					<input class="btn btn-danger btn-sm" type="submit" value="❌">
				</form>
			</c:forEach>
		</div>
	</div>
	<script type="text/javascript">
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
						if(result=='성공'){
							alert(value+"하셨습니다.");
						} else {
							alert("한번만 가능합니다.");
						}
					}
				});
			}
		}
	</script>
</body>
</html>