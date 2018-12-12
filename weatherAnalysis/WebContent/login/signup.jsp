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
<div class="signup-form">
<h1> 가입 페이지 </h1>
<form action="signup.do" method="post">
<label for="id">아이디</label>
<input type="text" name="id" id="id" required="required"><br>
<label for="password">비밀번호</label>
<input type="password" name="password" id="password" required="required"><br>
<label for="email">이메일</label>
<input type="email" name="email" id="email" required="required"><br>
<input type="submit" value="가입하기">
</form>
</div>
</div>


</body>
</html>