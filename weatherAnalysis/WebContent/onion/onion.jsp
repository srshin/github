<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>        
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header2.css">

<title>Brain Mining_양파 생산량 분석</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<ul class="subul">
  <li class="subli" ><a class="active" href="#home">Home</a></li>
  <li class="subli"><a  href="#news">News</a></li>
  <li class="subli"><a  href="#contact">Contact</a></li>
</ul>
<h1> 연도별 양파 총 생산량 </h1>
<br>
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
        <td>${annualTotal.area}</td>
      </c:forEach>     
  </tr>
  <tr>
    <td>10a당 생산량 (kg)</td>
      <c:forEach items="${annualTotal}" var="annualTotal">
        <td>${annualTotal.unitOutput}</td>
      </c:forEach>     
  </tr>      
</table>
</body>
</html>