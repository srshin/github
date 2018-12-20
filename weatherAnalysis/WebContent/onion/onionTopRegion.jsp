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

<title>Brain Mining_양파 생산량 분석</title>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load('current', {'packages':['table']});
	google.charts.load('current', {'packages':['line']});	
	google.charts.setOnLoadCallback(drawVisualization); //첫 로딩시 불리는 chart 
		
	function drawVisualization() {  
	  var urls = "${pageContext.request.contextPath}/onion/onionByConditioncharts.do";
	  var condition = document.getElementById("condition").value;
	  var param = "?condition=" + condition;
	  var jsonData = $.ajax({
		  url : urls+param,
          dataType: "json",
          async: false
          }).responseText;
//	  console.log(jsonData);
	  var data = new google.visualization.DataTable(jsonData);
/*     alert(data.wg[0]);
	   console.log(data);   */
	   
	   var options = {
	    title : ' 연도별·지역별  양파 '+ condition +' 변화 추이 ',
	    vAxis: {title: condition },
	    hAxis: {title: '연도'},
	  };
	  var chart = new google.charts.Line(document.getElementById('chart_div'));
	  chart.draw(data, google.charts.Line.convertOptions(options));
	  
//find to convert row ro column	  	

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
<h1> 양파 생산 TOP5 지역 연간 변화추이 </h1>
<select name = "condition" id="condition">
  <option value = "unitOutput">생산성</option>   
  <option value = "output" selected="selected">총 생산량</option>
  <option value = "area">총 재배면적</option> 
</select>
<button type="submit" onclick="drawVisualization();">조회</button>
<br><br>
<div id="chart_div" style="width: 1100px; height: 500px;"></div>
<br>
<div id="table_div" style="width: 1100px; height: 500px;"></div>
<br>
<br><Br>
</body>
</html>