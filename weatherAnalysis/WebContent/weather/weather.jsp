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
	var taDate = document.getElementById("taDate").value;
	var arr = [];
	var chk = document.getElementsByName("col");
	
	for(var i=0; i< chk.length ;i++){
		if(chk[i].checked == true){
			arr.push(chk[i].value);
		}
	}

			var param = "oneName="+ oneName +"&taDate="+taDate +"&col=" + arr;
		    alert(param);
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

	지역명 :
	<select name="oneName" id="oneName">
		<option>전체</option>
		<c:forEach var="name" items="${oneName}">
		<option value="${name.oneName}">${name.oneName}</option>
		</c:forEach>
	</select>
	
	일시(연도) :
	<select name="taDate" id="taDate">
		<option>전체</option>
		<c:forEach var="year" items="${Year}">
		<option value="${year.taDate}">${year.taDate}</option>
		</c:forEach>
	</select>
	<br>
	
	기상 조건 : <br>
		<input type="checkbox" name="col" value="average" checked="checked">평균 기온<br>
		<input type="checkbox" name="col" value="taMax" checked="checked">평균 최고기온<br>
		<input type="checkbox" name="col" value="taMin" checked="checked">평균 최저기온<br>
		<input type="checkbox" name="col" value="rnDay" checked="checked">강수량<br>
		<input type="checkbox" name="col" value="sunLight" checked="checked">일조 시간<br>					

	<button type="submit" onclick="retrieve();">조회</button>

	<h1>기상관련 분석 데이타</h1>

	<p>기상 관련 데이타에 대한 차트와 표</p>
	<div id="here">
		<table border="1">
			<tr>
				<td>지역명</td>
				<td>기간</td>
				<td>평균 기온</td>
				<td>평균 최고기온</td>
				<td>평균 최저기온</td>
				<td>강수량</td>
				<td>일조 시간</td>
			</tr>
			<c:forEach var="all" items="${all}">
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