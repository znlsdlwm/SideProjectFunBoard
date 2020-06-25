<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!doctype html>
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

<style type="text/css">
body {
	background: linear-gradient(to left, #80DEEA, #00ACC1);
	;
}

h1 {
	text-align: center;
}

#clock {
	height: 100px;
	width: 800px;
	margin: auto;
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	font-family: courier, monospace;
	text-align: center;
	color: white;
	font-size: 100px;
}

ul {
	height: 50px;
	width: 800px;
	margin: auto;
	position: absolute;
	left: 0;
	bottom: 50px;
	right: 0;
	text-align: center;
}

span {
	color: white;
}

li {
	display: inline;
	margin-right: 15px;
	color: white;
	border: none;
	background: none;
	font-family: helvetica;
	text-transform: uppercase;
	font-size: 14px;
	padding-bottom: 3px;
	cursor: auto;
}

li:not (.active ):hover {
	color: #EDEDED;
	cursor: pointer;
}

.active {
	border-bottom: solid white 1px;
}
</style>
</head>
<body>
	<div id="clock"></div>
	<ul>
		<li>Venezuela</li>
		<li>Miami</li>
		<li>Los Angeles</li>
		<li class="active">Seoul</li>
		<li>Beijing</li>
		<li>Cairo</li>
		<li>Paris</li>
		<li>Sao Paulo</li>
	</ul>
	<h1>
		<a href="main.asj"><span class="glyphicon glyphicon-home white"></span></a>
	</h1>
	<h1>
		<a href="list.asj"><span class="glyphicon glyphicon-modal-window"></span></a>
	</h1>
	<h1>
		<a href="filelist.asj"><span class="glyphicon glyphicon-bookmark"></span></a>
	</h1>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {

							function displayTime() {
								var currentTime = new Date();

								var timeDifference = currentTime
										.getTimezoneOffset() / 60;

								var hours = currentTime.getHours()
										+ timeDifference;

								var minutes = currentTime.getMinutes();
								var seconds = currentTime.getSeconds();

								if ($(".active").text() === "Venezuela") {
									hours = hours - 4;
									if (minutes > 30) {
										minutes = minutes - 30;
									} else {
										hours = hours - 1;
										minutes = minutes + 30;
									}
									$("body")
											.css("background",
													"linear-gradient(to left, #FFE082, #FFCA28)");
								}
								if ($(".active").text() === "Miami") {
									hours = hours - 5;
									$("body")
											.css("background",
													"linear-gradient(to left, #4CB8C4, #3CD3AD)");
								}
								if ($(".active").text() === "Los Angeles") {
									hours = hours - 8;
									$("body")
											.css("background",
													"linear-gradient(to left, #90CAF9, #42A5F5)");
								}
								if ($(".active").text() === "Seoul") {
									hours = hours + 9;
									$("body")
											.css("background",
													"linear-gradient(to left, #9FA8DA, #3949AB)");
								}
								if ($(".active").text() === "Beijing") {
									hours = hours + 8;
									$("body")
											.css("background",
													"linear-gradient(to left, #FFAB91, #FF7043)");
								}
								if ($(".active").text() === "Cairo") {
									hours = hours + 2;
									$("body")
											.css("background",
													"linear-gradient(to left, #FFE082, #FFB300)");
								}
								if ($(".active").text() === "Paris") {
									hours = hours + 1;
									$("body")
											.css("background",
													"linear-gradient(to left, #CE93D8 , #AB47BC)");
								}
								if ($(".active").text() === "Sao Paulo") {
									hours = hours - 2;
									$("body")
											.css("background",
													"linear-gradient(to left, #C5E1A5, #7CB342)");
								}

								if (hours > 24) {
									hours = hours - 24;
								}

								if (hours < 0) {
									hours = hours + 24;
								}

								var meridiem = "AM"; // Default is AM

								if (hours >= 12) {
									hours = hours - 12;
									meridiem = "PM";
								}

								if (hours === 0) {
									hours = 12;
								}

								if (seconds < 10) {

									seconds = "0" + seconds;
								}

								if (minutes < 10) {

									minutes = "0" + minutes;
								}

								if (hours < 10) {

									hours = "0" + hours;
								}

								var clockDiv = document.getElementById('clock');

								clockDiv.innerText = hours + ":" + minutes
										+ ":" + seconds + " " + meridiem;
							}

							$("li").click(function() {

								$("li").removeClass("active");

								$(this).addClass("active");
							});

							displayTime();

							setInterval(displayTime, 500);
						});
	</script>
</body>
</html>
