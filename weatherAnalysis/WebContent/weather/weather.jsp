<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
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
	
	var param = "oneName="+ oneName + "&condition=" + condition;
	//alert(param);
			
	var xhttp = new XMLHttpRequest();
			
	xhttp.onreadystatechange = function() {
	if (this.readyState == 4 && this.status == 200) {
	document.getElementById("here").innerHTML = this.responseText;
				}
			};

	xhttp.open("GET", "weatherResult.do?" + param);
	xhttp.send();
		};
</script>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
google.charts.load('current', {'packages':['line']});
google.charts.setOnLoadCallback(drawChart);
/* google.charts.load('current', {'packages':['table']}); */
function drawChart() {
	
	var urls = "${pageContext.request.contextPath}/weather/weatherChart.do";
	var oneName = document.getElementById("oneName").value;
	var condition = document.getElementById("condition").value;
	var param = "?oneName=" + oneName + "&condition=" + condition;
	var jsonData = $.ajax({
		url : urls+param,
		dataType : "json",
		async : false
	}).responseText;	
	console.log(jsonData);
	
	var data = new google.visualization.DataTable(jsonData);
	
	var options = {
	  title: '연도별 기상 데이터',
      vAxis: {title : '연도별'},
      hAxis: {title : '월별'},
      seriesType: 'bars',
      series: {2: {type:'line'}}
	};
	var chart = new google.charts.Line(document.getElementById('line_top_x'));
	chart.draw(data, google.charts.Line.convertOptions(options));
	
    /* var table = new google.visualization.Table(document.getElementById('table_div'));
    table.draw(data, {showRowNumber: true, width: '100%', height: '100%'}); */
}
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
	
	<button type="submit" onclick="retrieve();drawChart();">조회</button>
	
	<div id="line_top_x" style="width: 900px; height: 500px"></div>
	<!-- <div id="table_div" style="width: 900px; height: 500px"></div> -->
	<div id="here">
	</div>
	<br>
</body>
</html>