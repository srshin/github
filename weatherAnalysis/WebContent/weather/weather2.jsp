<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1">
<tr>
<td>지역명</td>
<td>날짜</td>
<td>평균 기온</td>
<td>평균 최고기온</td>
<td>평균 최저기온</td>
<td>월합 강수량 </td>
<td>일조 시간합</td>
</tr>
<c:forEach var="area" items="${radioList}">
<tr>
<td>${area.oneName}</td>
<td>${area.taDate}</td>
<td>${area.average}</td>
<td>${area.taMax}</td>
<td>${area.taMin}</td>
<td>${area.rnDay}</td>
<td>${area.sunLight}</td>
</tr>
</c:forEach>
</table>
