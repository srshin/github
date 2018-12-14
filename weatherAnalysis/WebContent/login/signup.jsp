<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="container">
	<div class="signup-form">
		<h1> 가입 페이지 </h1>
		<form action="signup.do" method="post">
		<label for="idc">아이디</label>
		<input type="text" name="id" id="idc" required="required">
		<button type="button" id="idchk">아이디 중복체크</button>
		<span id="result"></span>
		<br>
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