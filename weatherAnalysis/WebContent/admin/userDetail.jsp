<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="adminHeader.jsp"></jsp:include>
<h1>회원 정보 수정</h1>
<form action="userUpdate.do" method="post">
아이디 : <input type="text" name="id" readonly="readonly" value="${user.id }"><br>
비밀번호 : <input type="password" name="password" value="${user.password }"><br>
이메일 : <input type="email" name="email" value="${user.email }"><br>
<input type="submit" value="수정하기" >
</form>
</body>
</html>