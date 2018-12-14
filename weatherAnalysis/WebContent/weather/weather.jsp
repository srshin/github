<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<ul class="subul">
  <li class="subli" ><a class="active" href="#home">Home</a></li>
  <li class="subli"><a  href="#news">News</a></li>
  <li class="subli"><a  href="#contact">Contact</a></li>
</ul>
<h1> 기상관련 분석 데이타 </h1>

<p>기상 관련 데이타에 대한 차트와 표</p>
<table border="1">
<tr>
<td>행정 구역</td>
<td>평균 기온</td>
<td>평균 최고기온</td>
<td>평균 최저기온</td>
<td>월합 강수량</td>
<td>일조 시간합</td>
</tr>
<c:forEach var="all" items="${allList}">
<tr>
<td>${all.oneName}</td>
<td>${all.average}</td>
<td>${all.taMax}</td>
<td>${all.taMin}</td>
<td>${all.rnDay}</td>
<td>${all.sunLight}</td>
</tr>
</c:forEach>
</table>

<p>기상관련 데이타에 대한 차트와 표</p>
<p>기상관련 데이타에 대한 차트와 표</p>
<p>기상관련 데이타에 대한 차트와 표</p>
<p>기상관련 데이타에 대한 차트와 표</p>
<p>기상관련 데이타에 대한 차트와 표</p>
<p>기상관련 데이타에 대한 차트와 표</p>
<p>기상관련 데이타에 대한 차트와 표</p>
<p>기상관련 데이타에 대한 차트와 표</p>
<p>기상관련 데이타에 대한 차트와 표</p>
<p>기상관련 데이타에 대한 차트와 표</p>
<p>기상관련 데이타에 대한 차트와 표</p>
<p>기상관련 데이타에 대한 차트와 표</p>
<p>기상관련 데이타에 대한 차트와 표</p>
<p>기상관련 데이타에 대한 차트와 표</p>
<p>기상관련 데이타에 대한 차트와 표</p>

</body>
</html>