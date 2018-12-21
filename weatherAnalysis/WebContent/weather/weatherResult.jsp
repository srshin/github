<%@ page import="com.brain.model.weather.WeatherVO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.brain.model.weather.WeatherService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 


		<table id="customers">

		<c:forEach var="result" items="${resultString}" varStatus="status">
			<c:if test="${status.first}">
			<tr>	
	 			<th>${result[0]}</th>
				<th>${result[1]}</th>
				<th>${result[2]}</th>
				<th>${result[3]}</th>
				<th>${result[4]}</th>
				<th>${result[5]}</th>
				<th>${result[6]}</th>
				<th>${result[7]}</th>
				<th>${result[8]}</th>
				<th>${result[9]}</th>
				<th>${result[10]}</th>
				<th>${result[11]}</th>
				<th>${result[12]}</th>	 		
			</tr>
			</c:if> 
			
			<c:if test="${!status.first}">
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
		</c:if> 
		</c:forEach>

</table>
