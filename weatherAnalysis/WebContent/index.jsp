<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.container {
  display: flex;
  flex-flow: row wrap;
}

.c1, .c2, .c3 {
  width: 100%;
}

@media (min-width: 1000px) {
  .c1 {
    width: 60%;
    -webkit-order: 2;
    order: 1;
  }
    .c2 {
    width: 40%;
    -webkit-order: 1;
    order: 2;
  }

  .c3 {
    width: 100%;
    -webkit-order: 3;
    order: 3;
  }


  
}


</style>
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
		colorAxis:  {minValue: 0, maxValue: 50,  
 			colors: ['#ffffff','#ff0000'],
/*				'#dddddd',
				'#000000',
				'#3182BD',
				'#dddddd',
				'#0000ff',
				'#3182BD',
				'#3182BD',
				'#3182BD',
				'#9ECAE1',
				'#9ECAE1',
				'#111111',
				'#9ECAE1',
				'#9ECAE1',
				'#9ECAE1',
				'#9ECAE1',
				'#ffffff',
				'#DEEBF7',
				'#DEEBF7',
				'#DEEBF7',
				'#DEEBF7',
				'#DEEBF7',]
*/		}, 
		legend: 'none',	
		backgroundColor: {fill:'#FFFFFF',stroke:'#FFFFFF' ,strokeWidth:0 },	
		datalessRegionColor: '#f5f5f5',
		displayMode: 'regions', 
		enableRegionInteractivity: 'true', 
		resolution: 'provinces',
		sizeAxis: {minValue: 1, maxValue:1,minSize:10,  maxSize: 10},
		region:'KR', //country code
		keepAspectRatio: true,
		chartArea: {left:20,top:0,width:'50%',height:'75%'},
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
	  var urls= "${pageContext.request.contextPath}/index/indexChart.do";
	  var jsonData = $.ajax({
          url: urls,
          dataType: "json",
          async: false
          }).responseText;
	  var data = new google.visualization.DataTable(jsonData);
	
	  var options = {
	    title : '<연도별 전국 양파생산규모 및 도매가격 변화 추이>',
	    titleTextStyle: {
	        fontSize: 25, 
	        bold: true,    // true or false
	    },
	    
	    vAxis: {title: '생산량'},
	    hAxis: {title: '연'},
	    seriesType: 'bars',
	    series: {3: {type: 'line'}}

	    
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
	    	          title: '<2017 양파 생산량 전국분포>',
	    	          titleTextStyle: {
/* 	    	              color: <string>,    // any HTML string color ('red', '#cc00cc')*/
	    	              fontName: 'header', // i.e. 'Times New Roman' 
	    	              fontSize: 25, // 12, 18 whatever you want (don't specify px)
	    	              bold: true,    // true or false
/* 	    	              italic: <boolean>   // true of false  */  
	    	          	}
	    	          };

		  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
		  chart.draw(data, options);
	 	}
	
</script>

<title>양파생산량과 기상조건분석 사이트</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<ul class="subul">
  <li class="subli" ><a class="active" href="#home">전국 양파생산량과 면적 </a></li>
</ul>

<div class='container'>
<div class='c1'>
<div id='geo_div' style="width:100%; height: 500px; margin:auto"></div>
</div>
<div class='c2'> 
<div id='piechart' style="width:100%; height: 500px;"></div>
</div>
<div class='c3'> 
<div id='chart_div' style="width: 100%; height: 500px;"></div>
</div>

</div>

</body>
</html>