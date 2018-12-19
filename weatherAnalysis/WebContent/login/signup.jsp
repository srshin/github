<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<div class="login">
	<div class="login-screen">
		<div class="app-title">
			<h1> 가입 </h1>
		</div>
		<div class="login-form">
			<form action="signup.do" method="post">
				<div class="control-group">
					<input type="text" name="id" id="id" placeholder="아이디" required="required">
					<span><i class="fas fa-user"></i></span>
				</div>
				<div class="control-group">
					<input type="password" name="password" id="password" placeholder="패스워드" required="required">
					<span><i class="fas fa-unlock-alt"></i></span>
				</div>
				<div class="control-group">
					<input type="email" name="email" id="email" placeholder="이메일" required="required">
					<span><i class="far fa-envelope"></i></span>
				</div>
				<input type="submit" value="가입" class="btn">
			</form>
		</div>
	</div>
</div>


</body>
</html>