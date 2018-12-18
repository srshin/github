<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.container {
  display: -webkit-flex;
  display: flex;
  -webkit-flex-flow: row wrap;
  flex-flow: row wrap;
}

.c1, .c2, .c3, .c4 {
  width: 100%;
}

@media (min-width: 600px) {
  .c1 {
    width: 40%;
  }

  .c4 {
    width: 40%;
  }

}

@media (min-width: 1200px) {
  .container {
    width: 1200px;
    margin-left: auto;
    margin-right: auto;
  }
}</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type='text/javascript' src='http://www.google.com/jsapi'></script>
<script type='text/javascript'>
google.load('visualization', '1', {'packages': ['geochart']});
google.setOnLoadCallback(drawGeo);

function drawGeo() {
	  var urls= "${pageContext.request.contextPath}/index/indexGeo.do";
	  var jsonData = $.ajax({
          url: urls,
          dataType: "json",
          async: false
          }).responseText;
	  
	  var data = new google.visualization.DataTable(jsonData);
	var options = {
		backgroundColor: {fill:'#FFFFFF',stroke:'#FFFFFF' ,strokeWidth:0 },
		colorAxis:  {minValue: 0, maxValue: 21,  
			colors:['#000000','#ffffff',]},
/* 			colors: ['#3182BD',
				'#ffffff',
				'#000000',
				'#3182BD',
				'#dddddd',
				'#0000ff',
				'#3182BD',
				'#3182BD',
				'#3182BD',
				'#9ECAE1',
				'#9ECAE1',
				'#9ECAE1',
				'#9ECAE1',
				'#9ECAE1',
				'#9ECAE1',
				'#9ECAE1',
				'#9ECAE1',
				'#DEEBF7',
				'#DEEBF7',
				'#DEEBF7',
				'#DEEBF7',
				'#DEEBF7',]}, */
		legend: 'none',	
		backgroundColor: {fill:'#FFFFFF',stroke:'#FFFFFF' ,strokeWidth:0 },	
		datalessRegionColor: '#f5f5f5',
		displayMode: 'regions', 
		enableRegionInteractivity: 'true', 
		resolution: 'provinces',
		sizeAxis: {minValue: 1, maxValue:1,minSize:10,  maxSize: 10},
		region:'KR', //country code
		keepAspectRatio: true,
		tooltip: {textStyle: {color: '#444444'}, trigger:'focus'}	
	};
	
	var chart = new google.visualization.GeoChart(document.getElementById('geo_div')); 
	google.visualization.events.addListener(chart, 'select', function() {
	 	var selection = chart.getSelection();
	 	if (selection.length == 1) {
	 		var selectedRow = selection[0].row;
	 		var selectedRegion = data.getValue(selectedRow, 0);
	 		if(ivalue[selectedRegion] != '') {
	 			document.getElementsByTagName('body')[0].style.background=ivalue[selectedRegion]; 
	 		}
	 	}
	});
	chart.draw(data, options);
}
 </script>
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 <script>
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);
	
	function drawChart() {  
	  var urls= "${pageContext.request.contextPath}/onion/onionChart.do";
	  var jsonData = $.ajax({
          url: urls,
          dataType: "json",
          async: false
          }).responseText;
	  var data = new google.visualization.DataTable(jsonData);
	
	  var options = {
	    title : '양파 생산량',
	    vAxis: {title: '생산량'},
	    hAxis: {title: '연'},
	    seriesType: 'bars',
	    series: {2: {type: 'line'}}
	  };
	  var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
	  chart.draw(data, options);
 	}
	
	google.charts.setOnLoadCallback(drawPie);
	function drawPie() {  
		  var urls= "${pageContext.request.contextPath}/index/indexPie.do";
		  var jsonData = $.ajax({
	          url: urls,
	          dataType: "json",
	          async: false
	          }).responseText;
		  var data = new google.visualization.DataTable(jsonData);
		
	       var options = {
	    	          title: '전국분포'
	    	        };
		  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
		  chart.draw(data, options);
	 	}
	
</script>

<title>양파생산량과 기상조건분석 사이트</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>


<h1>전국 양파생산량과 면적 </h1>
<div class='container'>
<div class='c1' style="height:600px">
<div  id='geo_div' ></div>
</div>
<div class='c4'> 
<div class='c2'  id="piechart" ></div>
<div class='c3'id="chart_div"></div>
</div>

</div>

</body>
</html>