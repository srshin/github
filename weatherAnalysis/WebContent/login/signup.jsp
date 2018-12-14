<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$("#idchk").on("click",function(){
		var idStr = $("#idc").val();
		$.ajax({
			url : "idcheck.do?idc=" + idStr,
			success : function(data){
				if(data == "success"){
					$("#result").text("사용 가능한 아이디 입니다.");
				}else if(data == "fail") {
					$("#result").text("중복된 아이디 입니다.");
				}
			}
			
		});	
	});
});

 
</script>


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
					<input type="text" name="id" id="id" required="required"><br>
					<button type="button" id="idchk">아이디 중복체크</button>
					<span id="result"></span>
				</div>
				<div class="control-group">
					<label for="password">비밀번호</label>
					<input type="password" name="password" id="password" required="required"><br>
				</div>
				<div class="control-group">
					<label for="email">이메일</label>
					<input type="email" name="email" id="email" required="required"><br>
					<input type="submit" value="가입하기">
				</div>
			</form>
			<a href="${path}/login/login.do">이미 가입하셨나요?</a>
		</div>
	</div>
</div>


</body>
</html>