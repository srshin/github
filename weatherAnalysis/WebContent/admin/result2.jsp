<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh"   content="4;url=user.do">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/inchang.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="adminHeader.jsp"></jsp:include>

<div id ="search">
<h2 class="admin">${message}</h2>

</div>
<table id="customers">
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이메일</th>
	</tr>
	<tr>
		<td>${user.id}</td>
		<td>${user.password}</td>
		<td>${user.email}</td>
	</tr>
</table>



</body>
</html>