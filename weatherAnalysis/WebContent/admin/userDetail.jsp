<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/inchang.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="adminHeader.jsp"></jsp:include>
<div id="search">
<h2 class="admin">회원 정보 수정</h2>
<form action="userUpdate.do" method="post">
<input style="border-color:rgba(217, 83, 78, 0.75);" class='ipt' type="text" name="id" readonly="readonly" value="${user.id }">
<input class='ipt' type="password" name="password" value="${user.password }">
<input class='ipt' type="email" name="email" value="${user.email }">

<input type="submit" class='btn btn-default' value="수정하기" >

</form>
</div>
</body>
</html>