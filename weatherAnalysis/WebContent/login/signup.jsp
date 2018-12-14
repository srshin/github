<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/header.jsp"></jsp:include>
<div class="signup">
	<div class="signup-screen">
		<div class="app-title">
			<h1> Signup </h1>
			<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
		</div>
		<div class="signup-from">
			<form action="signup.do" method="post">
				<div class="control-group">
					<label for="id">아이디</label>
					<input type="text" name="id" id="id" required="required">
				</div>
				<div class="control-group">
					<label for="password">비밀번호</label>
					<input type="password" name="password" id="password" required="required">
				</div>
				<div class="control-group">
					<label for="email">이메일</label>
					<input type="email" name="email" id="email" required="required">
					<input type="submit" value="가입하기">
				</div>
			</form>
		</div>
	</div>
</div>


</body>
</html>