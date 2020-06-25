<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/custom.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</head>
<style>
.jumbotron {
	background-color: #f4511e; /* Orange */
	color: #ffffff;
}
.jb-main {
	font-size: xxx-large;
	font-family:
}
.container-img {
    padding: 60px 50px;
  }
  .bg-grey {
    background-color: #f6f6f6;
  }
</style>
<body>
<div class="jumbotron text-center">
		<h1 class="glyphicon glyphicon-plane">Trip!</h1>
		<p>where are you going now?</p>
		<form class="form-inline">
				<div class="input-group-btn">
					<button type="button" onclick="location.href='main.asj'" class="btn btn-danger">home!!</button>
				</div>
			</div>
		</form>
	</div>
	<div class="container-fluid text-center bg-main">

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="home.asj">Time</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="main.asj">Home</a></li>
					<li><a href="list.asj">page 1</a></li>
					<li><a href="filelist.asj">page 2</a></li>
					<li><a href="adminlist.asj">page 3</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href=${empty login ? 'loginui.asj':'logout.asj'}>${empty login? '로그인':'로그아웃' }</a></li>
					<li><a href="insertui.asj">회원가입</a></li>
					<li><a href=${empty admin_login ? 'adminloginui.asj':'info.asj'}>회원정보</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="container-img text-center bg-grey">
	<h2>7월의 여행지</h2>
	<h4>더울수록 더 뜨겁게!!</h4>
	<div class="row text-center">
		<div class = "col-sm-4">
			<div class="summer">
			<img src="./image/bat.jpg" alt ="first" width="400" height="300">
			<p><strong>베트남 팔라완</strong>
			<p>한적한 여유로움과 다양한 액티비티를 즐기길 원한다면 필리핀의 팔라완으로 자유여행을 계획해보자. 항공권도 저렴한편</p>
			</div>
		</div>
		<div class = "col-sm-4">
			<div class="summer">
			<img src="./image/uk.jpg" alt ="second" width="400" height="300">
			<p><strong>북유럽</strong>
			<p>항공권은 비싸지만 유럽만의 감성을 받을수 있고 사진 몇만장 찍어도 버릴게없는 풍경을 맛볼수 있다.</p>
			</div>
		</div>
		<div class = "col-sm-4">
			<div class="summer">
			<img src="./image/ku.jpg" alt ="third" width="400" height="300">
			<p><strong>일본의 교토</strong>
			<p>가깝다고도 할수없고 멀다고 할수없는 나라 일본여행을 가본다면 여름축제의 음식과 볼거리를 즐기러 가보자.</p>
			</div>
		</div>
		
	
	</div>
	
	
	</div>
	<h2>국제 환율 2020/06/24일차</h2>
<div id="myCarousel" class="carousel slide text-center" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>


  <div class="carousel-inner" role="listbox">
    <div class="item active">
    <h4>"2020 06 24"<br><span style="font-style:normal;">미국 USD 1,200,00</span></h4>
    </div>
    <div class="item">
      <h4>"2020 06 24"<br><span style="font-style:normal;">유렵EUR 1,358,28</span></h4>
    </div>
    <div class="item">
      <h4>"2020 06 24"<br><span style="font-style:normal;">일본JPY 1,125,81</span></h4>
    </div>
    <div class="item">
    <h4>"2020 06 24"<br><span style="font-style:normal;">중국CNY 169,96</span></h4>
    </div>
    <div class="item">
    <h4>"2020 06 24"<br><span style="font-style:normal;">국제금 1,772,10</span></h4>
    </div>
  </div>

  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</body>
</html>