<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
    

<table border="1">
	<tr>
		<td>아이디</td>
		<td>패스워드</td>
		<td>이메일</td>
		<td>회원관리</td>
	</tr>
	<c:forEach items="${userlist }" var="userlist">
	<tr>
		<td>${userlist.id }</td>
		<td>${userlist.password }</td>
		<td>${userlist.email }</td>
		<td><button onclick="call2('${userlist.id}');">수정</button><button onclick="call('${userlist.id}');">삭제</button></td>

	</tr>
	</c:forEach>
</table>