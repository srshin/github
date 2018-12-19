<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh"   content="3;url=user.do">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="adminHeader.jsp"></jsp:include>

<div class='mcontainer'>
<div class='hcontainer'><h1>' ${did} ' 회원의 정보가 ${message}</h1></div>
</div>



</body>
</html>