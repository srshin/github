<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>            
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Brain Mining_양파 생산량 분석</title>
</head>

<body>
<jsp:include page="/header.jsp"></jsp:include>

<c:set var="path" value="${pageContext.request.contextPath }/onion"></c:set>
<ul class="subul">
  <li class="subli" ><a class="active" href="${path }/onion.do">연도별·지역별 생산규모</a></li>
  <li class="subli"><a  href="${path }/output.do">연도별·지역간 생산량 변화 추이</a></li>
  <li class="subli"><a  href="${path }/area.do">연도별·지역간 재배면적 변화 추이</a></li>
  <li class="subli"><a  href="${path }/unitOutput.do">연도별·지역간 생산성 변화 추이</a></li>
</ul>
<h1> 연도별·지역별 양파 총 생산량 변화추이 </h1>
<br>
<table border="1">
<tr>
  <td></td>
    <c:forEach items="${yearList}" var="yearList">
  	  <th>${yearList}</th>
  	</c:forEach>
</tr>
<c:forEach items="${regionList}" var="regionList">
 <tr>
   <td>${regionList}</td>
    <c:forEach items="${outputList}" var="outputList">	
     <c:if test="${regionList==outputList.region}"><td><fmt:formatNumber>${outputList.output}</fmt:formatNumber></td></c:if>
   </c:forEach>
 </tr>
</c:forEach>
</table>
</body>
</html>