<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh"   content="3;url=user.do">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="adminHeader.jsp"></jsp:include>
<h1>수정결과</h1>

<p>${message}</p>
<p>아이디 : ${user.id}</p>
<p>수정된 비밀번호 : ${user.password}</p>
<p>수정된 이메일 : ${user.email}</p>

</body>
</html>