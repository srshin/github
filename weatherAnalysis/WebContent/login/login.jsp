<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<div class="container">
	<div class="login-form">
		<h1> 로그인 페이지 </h1>
		<form action="login.do" method="post">
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" required="required"><br>
			<label for="password">비밀번호</label>
			<input type="password" name="password" id="password" required="required"><br>
			<input type="submit" value="로그인">
		</form>
	</div>
</div>
</body>
</html>