<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>        


<table border="1">
  <tr>
    <td>연도</td>
      <c:forEach items="${totalByRegion}" var="totalByRegion">
        <td>${totalByRegion.year}</td>
      </c:forEach>
  </tr>
  <tr>
    <td>생산량(톤)</td>
      <c:forEach items="${totalByRegion}" var="totalByRegion">
        <td><fmt:formatNumber>${totalByRegion.output}</fmt:formatNumber></td>
      </c:forEach>    
  </tr>
  <tr>
    <td>재배면적 (ha)</td>
      <c:forEach items="${totalByRegion}" var="totalByRegion">
        <td><fmt:formatNumber>${totalByRegion.area}</fmt:formatNumber></td>
      </c:forEach>     
  </tr>
  <tr>
    <td>10a당 생산량 (kg)</td>
      <c:forEach items="${totalByRegion}" var="totalByRegion">
        <td><fmt:formatNumber>${totalByRegion.unitOutput}</fmt:formatNumber></td>
      </c:forEach>     
  </tr>      
</table>
