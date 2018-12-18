<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
${oneName}
${conditionTitle}
<table border="1">
		<c:forEach var="result" items="${resultString}">
	<tr>
			<td>${result[0]}</td>
			<td>${result[1]}</td>
			<td>${result[2]}</td>
			<td>${result[3]}</td>
			<td>${result[4]}</td>
			<td>${result[5]}</td>
			<td>${result[6]}</td>
			<td>${result[7]}</td>
			<td>${result[8]}</td>
			<td>${result[9]}</td>
			<td>${result[10]}</td>
			<td>${result[11]}</td>
			<td>${result[12]}</td>
	</tr>
		</c:forEach>

</table>
