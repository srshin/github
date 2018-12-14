<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<script>
		function retrieve() {
			var oneName = document.getElementById("oneName").value;
			
			var arr = [];
			 for(var i = 0; i < $(":checked").length; i++){
			        console.log($(":checked")[i].value);
			        arr.push($(":checked")[i].value);
			    }
				/* var arr = $(":checked")[0].value; */
			
			var param = "oneName=" + oneName + "&col=" + arr;
			
			var xhttp = new XMLHttpRequest();
			
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById("here").innerHTML = this.responseText;
				}
			};

			xhttp.open("GET", "weather2.do?" + param);
			xhttp.send();
		};
	</script>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>

	<ul class="subul">
		<li class="subli"><a class="active" href="#home">Home</a></li>
		<li class="subli"><a href="#news">News</a></li>
		<li class="subli"><a href="#contact">Contact</a></li>
	</ul>

	지역별 :
	<select name="oneName" id="oneName">
		<c:forEach var="name" items="${oneNameList}">
			<option value="${name.oneName}">${name.oneName}</option>
		</c:forEach>
	</select>
	<br>
	기상 조건 : <br>
	<input type="checkbox" name="col" value="taDate" checked="checked">날짜<br>
	<input type="checkbox" name="col" value="average">평균기온<br>
	<input type="checkbox" name="col" value="taMax">평균최고기온<br>
	<input type="checkbox" name="col" value="taMin">평균최저기온<br>
	<input type="checkbox" name="col" value="rnDay">강수량<br>
	<input type="checkbox" name="col" value="sunLight">일조시간<br>

	<button type="submit" onclick="retrieve();">조회</button>

	<h1>기상관련 분석 데이타</h1>

	<p>기상 관련 데이타에 대한 차트와 표</p>

	<div id="here">
		<table border="1">
			<tr>
				<td>지역명</td>
				<td>날짜</td>
				<td>평균 기온</td>
				<td>평균 최고기온</td>
				<td>평균 최저기온</td>
				<td>월합 강수량</td>
				<td>일조 시간합</td>
			</tr>
			<c:forEach var="all" items="${allList}">
				<tr>
					<td>${all.oneName}</td>
					<td>${all.taDate}</td>
					<td>${all.average}</td>
					<td>${all.taMax}</td>
					<td>${all.taMin}</td>
					<td>${all.rnDay}</td>
					<td>${all.sunLight}</td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>