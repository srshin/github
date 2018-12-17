<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1">
<tr>
<td>지역명</td>
<td>기간</td>
<td>평균 기온</td>
<td>평균 최고기온</td>
<td>평균 최저기온</td>
<td>강수량</td>
<td>일조 시간</td>
</tr>
<c:forEach var="result" items="${resultList}">
<tr>
<td>${result.oneName}</td>
<td>${result.taDate}</td>
<td>${result.average}</td>
<td>${result.taMax}</td>
<td>${result.taMin}</td>
<td>${result.rnDay}</td>
<td>${result.sunLight}</td>
</tr>
</c:forEach>
</table>
