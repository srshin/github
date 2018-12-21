<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>        
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/inchang.css">

<title>Brain Mining_양파 생산량 분석</title>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load('current', {'packages':['table']});
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawVisualization); //첫 로딩시 불리는 chart 
	
	function drawVisualization() {  
	  var urls= "${pageContext.request.contextPath}/onion/onionByRegionCharts.do";
	  var region = document.getElementById("region").value;
	  var param = "?region=" + region;
	  var jsonData = $.ajax({
          url: urls+param,
          dataType: "json",
          async: false
          }).responseText;
	  var data = new google.visualization.DataTable(jsonData);
 	  var options = {
		title : region + ' 생산규모 변화추이',
        vAxes: {
				0: {
					title: '생산량',				
					},
				1: {
					title: '재배면적',				
					},
			},
   		series: {
				0:{
					targetAxisIndex:0
					},
				1:{
					targetAxisIndex:1
				},
				2:{
					targetAxisIndex:1,
					lineDashStyle: [5, 1, 3],
					lineWidth: 4
				},
    		},
       };
	  var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
	  chart.draw(data, options);
	  
	  var table = new google.visualization.Table(document.getElementById('table_div'));
	  table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
 	}
</script>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<c:set var="path" value="${pageContext.request.contextPath }/onion"></c:set>
<ul class="subul">
  <li class="subli"><a class="active" href="${path }/onionTopRegion.do">Top5 지역 항목별 변화 추이</a></li>
  <li class="subli" ><a href="${path }/onion.do">지역별 생산규모 변화추이</a></li>
<%--   <li class="subli"><a  href="${path }/area.do">Top5 지역 재배면적 변화 추이</a></li>
  <li class="subli"><a  href="${path }/unitOutput.do">Top5 지역 생산성 변화 추이</a></li> --%>
</ul>
<div class="body_container">
<h1> 각 지역별 양파 생산규모 변화추이 </h1>
<div class="select">

<select name="region" id="region">
  <c:forEach var="region" items="${region}">
	<option>${region}</option>	
  </c:forEach>
</select>  
</div>
<button  onclick="drawVisualization();" class="btn btn-default">조회</button>
<br><br>

<div id="chart_div" style="width: 1100px; height: 500px;"></div>
<br>
<div id="table_div" style="width: 1100px; height: 500px;"></div>
<br>
</div>
</body>
</html>