<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Brain Mining_기상 데이터 분석</title>
<script>
	window.onload = function (){
		retrieve();
	}
	
	function retrieve() {
			
	var oneName = document.getElementById("oneName").value;
	var condition = document.getElementById("condition").value;
	
	var param = "oneName="+ oneName + "&condition=" + condition ;
	//alert(param);
			
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
		<li class="subli"><a class="active" href="#home">기상분석</a></li>
		
	</ul>

	지역명 :
	<select name="oneName" id="oneName">
		<!-- <option>전체</option> -->
		<c:forEach var="name" items="${oneName}">
		<option value="${name.oneName}">${name.oneName}</option>
		</c:forEach>
	</select>
	
	기상 조건 :
	<select name="condition" id="condition">
		<option value="average">평균기온</option>
		<option value="taMax">평균 최고기온</option>
		<option value="taMin">평균 최저기온</option>
		<option value="rnDay">강수량</option>
		<option value="sunLight">일조 시간</option>
	</select>
	
	<button type="submit" onclick="retrieve();">조회</button>
	
	<div id="here">
	</div>

</body>
</html>