<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Brain Mining_양파 생산량 분석</title>

<script>
  function retrieve() {
	  
	var region = document.getElementById("region").value;
	var param = "region=" + region;
//	alert(param);
	
	var xhttp = new XMLHttpRequest();
	 xhttp.onreadystatechange = function() {
	   if (this.readyState == 4 && this.status == 200) {
	     document.getElementById("here").innerHTML = this.responseText;
	   }
	 };
	 xhttp.open("GET", "onionByRegion.do?"+ param);
	 xhttp.send();
}
</script>    
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script>
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawVisualization);
	
	function drawVisualization() {
	  // Some raw data (not necessarily accurate)
	  var data = google.visualization.arrayToDataTable([
	  	${result}
	  ]);
	
	  var options = {
	    title : 'Monthly Coffee Production by Country',
	    vAxis: {title: 'Cups'},
	    hAxis: {title: 'Month'},
	    seriesType: 'bars',
	    series: {2: {type: 'line'}}
	  };
	
	  var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
	  chart.draw(data, options);
	}
</script>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<ul class="subul">
  <li class="subli" ><a class="active" href="#home">Home</a></li>
  <li class="subli"><a  href="#news">News</a></li>
  <li class="subli"><a  href="#contact">Contact</a></li>
</ul>

<h1> 지역별 양파 총 생산량 </h1>
지역 : 
<select name="region" id="region">
  <option>전국</option>
  <c:forEach var="reg" items="${region}">
	<option>${reg.region}</option>
	
  </c:forEach>
</select>  
<button  onclick="retrieve();">조회</button>
<br><br>

<div id="chart_div" style="width: 900px; height: 500px;"></div>

<div id="here">
<table border="1">
  <tr>
    <td>연도</td>
      <c:forEach items="${annualTotal}" var="annualTotal">
        <td>${annualTotal.year}</td>
      </c:forEach>
  </tr>
  <tr>
    <td>생산량(톤)</td>
      <c:forEach items="${annualTotal}" var="annualTotal">
        <td><fmt:formatNumber>${annualTotal.output}</fmt:formatNumber></td>
      </c:forEach>    
  </tr>
  <tr>
    <td>재배면적 (ha)</td>
      <c:forEach items="${annualTotal}" var="annualTotal">
        <td><fmt:formatNumber>${annualTotal.area}</fmt:formatNumber></td>
      </c:forEach>     
  </tr>
  <tr>
    <td>10a당 생산량 (kg)</td>
      <c:forEach items="${annualTotal}" var="annualTotal">
        <td><fmt:formatNumber>${annualTotal.unitOutput}</fmt:formatNumber></td>
      </c:forEach>     
  </tr>      
</table>
</div>
</body>
</html>